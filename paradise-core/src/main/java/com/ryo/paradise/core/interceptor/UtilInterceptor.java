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

    public static void enhance() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.getCtClass(UtilInterceptor.class.getName());
            Util util = (Util) ctClass.getAnnotation(Util.class);
            if (util != null) {
                System.out.println("==========================开始增强。。。");
                CtConstructor constructor = ctClass.getDeclaredConstructor(null);
                constructor.setModifiers(Modifier.PRIVATE);
                byte[] bytes = ctClass.toBytecode();
                final String targetPath = "D:\\CODE\\paradise\\paradise-core\\target\\classes\\com\\ryo\\paradise\\core\\interceptor\\UtilInterceptor.class";

                FileOutputStream fileOutputStream = new FileOutputStream(new File(targetPath));
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                System.out.println("==========================结束增强。。。");
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
