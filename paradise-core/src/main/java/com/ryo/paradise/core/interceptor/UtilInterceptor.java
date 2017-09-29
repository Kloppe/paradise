package com.ryo.paradise.core.interceptor;

import com.ryo.paradise.core.annotation.Util;
import javassist.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * http://blog.csdn.net/mousebaby808/article/details/37696371
 * Created by bbhou on 2017/9/29.
 */
@Util
public class UtilInterceptor {

    public static final String EMPTY = "";

    public static void main(String[] args) throws NotFoundException, ClassNotFoundException, CannotCompileException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.getCtClass(UtilInterceptor.class.getName());
        Util util = (Util) ctClass.getAnnotation(Util.class);
        if(util != null) {
            //
            System.out.println("开始增强。。。");
            CtConstructor constructor = ctClass.getDeclaredConstructor(null);
            constructor.setModifiers(Modifier.PRIVATE);
//            constructor.setBody("{}");
//            ctClass

            System.out.println("==========================结束增强。。。");

            byte[] bytes = ctClass.toBytecode();
            final String targetPath = "D:\\CODE\\paradise\\paradise-core\\target\\classes\\com\\ryo\\paradise\\core\\interceptor\\UtilInterceptor.class";

            FileOutputStream fileOutputStream = new FileOutputStream(new File(targetPath));
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();

        }

//        UtilInterceptor utilInterceptor = new UtilInterceptor();
//        utilInterceptor.
//        System.out.println(UtilInterceptor.class.getClassLoader().getResource(""));
    }



}
