package com.github.houbb.paradise.common.support.validator.exception;

import org.junit.Test;

/**
* ValidException Tester.
*
* @author author
* @since 2017-12-03 11:08:55.804
* @version 1.0
*/
public class ValidExceptionTest {

    /**
    *
    * Method: ValidException()
    */
    @Test(expected = ValidException.class)
    public void ValidExceptionTest() throws Exception {
        throw new ValidException();
    }

    /**
    *
    * Method: ValidException(message)
    */
    @Test(expected = ValidException.class)
    public void ValidExceptionMessageTest() throws Exception {
        throw new ValidException("error");
    }

    /**
    *
    * Method: ValidException(message, cause)
    */
    @Test(expected = ValidException.class)
    public void ValidExceptionMessageCauseTest() throws Exception {
        throw new ValidException("error", new Exception());
    }

    /**
    *
    * Method: ValidException(cause)
    */
    @Test(expected = ValidException.class)
    public void ValidExceptionCauseTest() throws Exception {
        throw new ValidException("error", new Exception());
    }

    /**
    *
    * Method: ValidException(message, cause, enableSuppression, writableStackTrace)
    */
    @Test(expected = ValidException.class)
    public void ValidExceptionMessageCauseEnableSuppressionWritableStackTraceTest() throws Exception {
        throw new ValidException("error", new Exception(), true, true);
    }


}
