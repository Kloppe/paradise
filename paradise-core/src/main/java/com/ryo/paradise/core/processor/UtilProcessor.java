package com.ryo.paradise.core.processor;

import com.ryo.paradise.core.annotation.Util;
import com.ryo.paradise.core.util.JcTrees;
import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * 工具注解执行器
 *
 * @see com.ryo.paradise.core.annotation.Util 工具类注解
 * Created by bbhou on 2017/10/12.
 */
@SupportedAnnotationTypes("com.ryo.paradise.core.annotation.Util")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class UtilProcessor extends AbstractProcessor {


    private Trees trees;

    private TreeMaker treeMaker;

    private Name.Table names;

    /**
     * 初始化，获取编译环境
     *
     * @param env
     */
    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        trees = Trees.instance(env);
        Context context = ((JavacProcessingEnvironment) env).getContext();
        treeMaker = TreeMaker.instance(context);
        names = Names.instance(context).table;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("============================================== UtilProcessor START ==============================================");
        // 处理有 @Util 注解的元素
        for (Element element : roundEnv.getElementsAnnotatedWith(Util.class)) {
            // 只处理作用在类上的注解
            if (element.getKind() == ElementKind.CLASS) {
                addPrivateConstructor(element);
                addFinalModifier(element);
            }
        }
        System.out.println("============================================== UtilProcessor END ==============================================");
        return true;
    }

    /**
     * 添加私有构造器
     *
     * @param element 拥有注解的元素
     */
    private void addPrivateConstructor(Element element) {
        JCTree tree = (JCTree) trees.getTree(element);
        tree.accept(new TreeTranslator() {

            @Override
            public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                jcClassDecl.mods = (JCTree.JCModifiers) this.translate((JCTree) jcClassDecl.mods);
                jcClassDecl.typarams = this.translateTypeParams(jcClassDecl.typarams);
                jcClassDecl.extending = (JCTree.JCExpression) this.translate((JCTree) jcClassDecl.extending);
                jcClassDecl.implementing = this.translate(jcClassDecl.implementing);

                ListBuffer<JCTree> statements = new ListBuffer<>();

                List<JCTree> oldList = this.translate(jcClassDecl.defs);
                boolean hasPrivateConstructor = false;  //是否拥有私有构造器

                //1. 将原来的方法添加进来
                //2. 判断是否已经有默认私有构造器
                for (JCTree jcTree : oldList) {
                    if (isPublicDefaultConstructor(jcTree)) {
                        continue;   //不添加共有默认构造器
                    }
                    if (isPrivateDefaultConstructor(jcTree)) {
                        hasPrivateConstructor = true;
                    }
                    statements.append(jcTree);
                }

                if (!hasPrivateConstructor) {
                    JCTree.JCBlock block = treeMaker.Block(0L, List.<JCTree.JCStatement>nil()); //代码方法内容
                    JCTree.JCMethodDecl constructor = treeMaker.MethodDef(
                            treeMaker.Modifiers(Flags.PRIVATE, List.<JCTree.JCAnnotation>nil()),
                            names.fromString(JcTrees.CONSTRUCTOR_NAME),
                            null,
                            List.<JCTree.JCTypeParameter>nil(),
                            List.<JCTree.JCVariableDecl>nil(),
                            List.<JCTree.JCExpression>nil(),
                            block,
                            null);

                    statements.append(constructor);
                    jcClassDecl.defs = statements.toList(); //更新
                }

                this.result = jcClassDecl;
            }
        });
    }

    /**
     * 添加 final 修饰符
     * 1. 将工具类的修饰符定义为: public final;
     *
     * @param element 拥有注解的元素
     */
    private void addFinalModifier(Element element) {
        JCTree tree = (JCTree) trees.getTree(element);
        tree.accept(new TreeTranslator() {
            @Override
            public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                jcClassDecl.mods = treeMaker.Modifiers(Flags.PUBLIC | Flags.FINAL, List.<JCTree.JCAnnotation>nil());
            }
        });
    }


    /**
     * 是否为私有默认构造器
     *
     * @param jcTree
     * @return
     */
    private boolean isPrivateDefaultConstructor(JCTree jcTree) {

        if (jcTree.getKind() == Tree.Kind.METHOD) {
            JCTree.JCMethodDecl jcMethodDecl = (JCTree.JCMethodDecl) jcTree;
            if (JcTrees.isConstructor(jcMethodDecl)
                    && JcTrees.isNoArgsMethod(jcMethodDecl)
                    && JcTrees.isPrivateMethod(jcMethodDecl)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 是否为共有默认构造器
     *
     * @param jcTree
     * @return
     */
    private boolean isPublicDefaultConstructor(JCTree jcTree) {

        if (jcTree.getKind() == Tree.Kind.METHOD) {
            JCTree.JCMethodDecl jcMethodDecl = (JCTree.JCMethodDecl) jcTree;
            if (JcTrees.isConstructor(jcMethodDecl)
                    && JcTrees.isNoArgsMethod(jcMethodDecl)
                    && JcTrees.isPublicMethod(jcMethodDecl)) {
                return true;
            }
        }

        return false;
    }


}
