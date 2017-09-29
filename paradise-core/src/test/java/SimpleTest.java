import com.ryo.paradise.core.interceptor.UtilInterceptor;

/**
 * Created by bbhou on 2017/9/29.
 */
public class SimpleTest {

    public static void main(String[] args) {
        //运行之后 class 内容会被修改
        UtilInterceptor.enhance();

        //第二次运行此处会报错
        //Exception in thread "main" java.lang.IllegalAccessError: tried to access method com.ryo.paradise.core.interceptor.UtilInterceptor.<init>()V from class SimpleTest
        //at SimpleTest.main(SimpleTest.java:13)
        new UtilInterceptor();
    }

}
