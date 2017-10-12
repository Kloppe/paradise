package com.ryo.paradise.core.interceptor;

import com.ryo.paradise.core.annotation.Util;
import javassist.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Util 注解解释器
 * 只是用来测试代码增强，暂时作废。
 * Created by bbhou on 2017/9/29.
 */
@Util
@Deprecated
public class UtilInterceptor {

    /**
     * 对类进行增强
     * 1. 添加私有构造器
     */
    public static void enhance() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.getCtClass(UtilInterceptor.class.getName());
            Util util = (Util) ctClass.getAnnotation(Util.class);
            if (util != null) {
                System.out.println("========================== 开始增强 ==========================");
                CtConstructor constructor = ctClass.getDeclaredConstructor(null);
                constructor.setModifiers(Modifier.PRIVATE);
                byte[] bytes = ctClass.toBytecode();

                //1. 为方便此处路径写死，实际编写可动态获取
                final String targetPath = "D:\\CODE\\paradise\\paradise-core\\target\\classes\\com\\ryo\\paradise\\core\\interceptor\\UtilInterceptor.class";
                FileOutputStream fileOutputStream = new FileOutputStream(new File(targetPath));
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                System.out.println("========================== 结束增强 ==========================");
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

}
