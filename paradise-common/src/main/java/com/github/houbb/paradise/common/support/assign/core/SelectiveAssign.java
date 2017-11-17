package com.github.houbb.paradise.common.support.assign.core;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by houbinbin on 2017/1/10.
 * @since 1.7
 * @version 1.0
 */
public interface SelectiveAssign {

  /**
   * 只将 example 非null的属性按照【常规赋值】赋值给target
   * @param example 赋值模板
   * @param target 目标对象
   */
  void assignExampleSelective(Object example, Object target) throws InvocationTargetException, IllegalAccessException;

  /**
   * 只对 target 中字段为null的进行【常规赋值】
   * @param example 赋值模板
   * @param target 目标对象
   */
  void assignTargetSelective(Object example, Object target) throws InvocationTargetException, IllegalAccessException;

}
