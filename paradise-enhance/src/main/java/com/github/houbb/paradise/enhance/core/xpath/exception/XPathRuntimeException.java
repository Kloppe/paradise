package com.github.houbb.paradise.enhance.core.xpath.exception;

/**
 * xpath 异常
 * @author bbhou
 */
public class XPathRuntimeException extends RuntimeException {

    /**    
     *  x路径运行时异常    
     */    
    public XPathRuntimeException() {
    }

    /**    
     *  x路径运行时异常    
     *    
     * @param message 信息    
     */    
    public XPathRuntimeException(String message) {
        super(message);
    }

    /**    
     *  x路径运行时异常    
     *    
     * @param message 信息    
     * @param cause 原因    
     */    
    public XPathRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**    
     *  x路径运行时异常    
     *    
     * @param cause 原因    
     */    
    public XPathRuntimeException(Throwable cause) {
        super(cause);
    }

    /**    
     *  x路径运行时异常    
     *    
     * @param message 信息    
     * @param cause 原因    
     * @param enableSuppression 启用抑制    
     * @param writableStackTrace 可写堆栈跟踪    
     */    
    public XPathRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
