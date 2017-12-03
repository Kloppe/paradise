package com.github.houbb.paradise.common.support.validator.core;

import com.github.houbb.paradise.common.support.validator.core.impl.ValidServiceImpl;
import org.junit.Test;

/**
* ValidService Tester.
*
* @author author
* @since 2017-12-03 11:08:55.813
* @version 1.0
*/
public class ValidServiceTest {

    /**
    *
    * Method: valid(object)
    */
    @Test(expected = IllegalArgumentException.class)
    public void validTest() throws Exception {

        ValidService validService = new ValidServiceImpl();
        validService.valid(null);

    }


}
