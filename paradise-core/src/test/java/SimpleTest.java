import com.ryo.paradise.core.interceptor.UtilInterceptor;

/**
 * Created by bbhou on 2017/9/29.
 */
public class SimpleTest {
    public static void main(String[] args) {
        UtilInterceptor.enhance();
        //1. 无法访问。
        new UtilInterceptor();
    }
}
