package com.github.houbb.paradise.common.support.assigner.core;

import java.lang.reflect.InvocationTargetException;

/**
 * 可选的赋值
 * @author bbhou
 * @since 1.1.2
 * @version 1.1.2
 */
public interface SelectiveAssigner {

  /**
   * 只将 example 非null的属性按照【常规赋值】赋值给target
   * @param example 赋值模板
   * @param target 目标对象
   */
  void assignExampleSelective(Object example, Object target) throws InvocationTargetException, IllegalAccessException;

  /**
   * 只对 target 中字段为 null 的进行【常规赋值】
   * @param example 赋值模板
   * @param target 目标对象
   */
  void assignTargetSelective(Object example, Object target) throws InvocationTargetException, IllegalAccessException;

}
