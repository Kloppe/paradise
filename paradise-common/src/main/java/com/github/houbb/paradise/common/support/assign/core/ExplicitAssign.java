package com.github.houbb.paradise.common.support.assign.core;

import com.github.houbb.paradise.common.support.assign.exception.AssignException;

import java.util.List;

/**
 * Created by houbinbin on 2017/1/10.
 * 明确指定进行赋值的字段。或者不进行赋值的字段。
 * @since 1.7
 * @version 1.0
 */
public interface ExplicitAssign {

  /**
   * (1) 仅仅对target中指定的字段进行赋值。其他字段按照【常规赋值】进行处理。
   * (2) 应该支持可变参数，数组，列表。
   * @param example 赋值模板
   * @param target 目标对象
   * @param fieldName 指定的字段名称
   */
  void assignExplicitCondition(Object example, Object target, String... fieldName) throws AssignException;

  void assignExplicitCondition(Object example, Object target, List<String> fieldNameList) throws AssignException;

  /**
   * (1) 对 assignExplicitCondition 的补充
   * (2) 除却指定不赋值的字段，其他字段按照【常规赋值】进行处理。
   * @param example 赋值模板
   * @param target 目标对象
   * @param fieldName 指定的字段名称
   */
  void assignExplicitUnless(Object example, Object target, String... fieldName) throws AssignException;

  void assignExplicitUnless(Object example, Object target, List<String> fieldNameList) throws AssignException;

}
