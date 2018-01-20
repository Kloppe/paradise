package com.github.houbb.paradise.enhance.core.translator;

/**
 *  翻译者
 */
public interface Translator<T> {

    /**    
     * 翻译    
     *    
     * @return T    
     * @throws java.lang.Exception if any    
     */    
    T translate() throws Exception;

}
