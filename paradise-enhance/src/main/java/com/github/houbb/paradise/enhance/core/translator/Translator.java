package com.github.houbb.paradise.enhance.core.translator;

import com.github.houbb.paradise.enhance.core.translator.exception.TranslatorException;

/**
 *  翻译者
 */
public interface Translator<T> {

    /**    
     * 翻译    
     *    
     * @return T    
     * @throws TranslatorException if any
     */    
    T translate() throws TranslatorException;

}
