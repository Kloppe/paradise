package com.github.houbb.paradise.enhance.core.xpath.converter;

import com.github.houbb.paradise.common.util.ClassUtil;
import com.github.houbb.paradise.common.util.CollectionUtil;
import com.github.houbb.paradise.common.util.ObjectUtil;
import com.github.houbb.paradise.common.util.StringUtil;
import com.github.houbb.paradise.common.util.reflection.ReflectionUtil;
import com.github.houbb.paradise.enhance.core.xpath.annotation.XPath;
import com.github.houbb.paradise.enhance.core.xpath.exception.XPathRuntimeException;
import org.dom4j.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: 考虑到递归的情况
 * dom4j xpath 转换
 * @author bbhou
 * @version 1.1.2
 */
public class Dom4jXPathConverter implements XPathConverter {

    /**    
     * 兑换    
     *    
     * @param xml XML    
     * @param tClass t类    
     * @return T    
     */    
    @Override
    public <T> T convert(String xml, Class<T> tClass) {
        if(StringUtil.isEmpty(xml)) {
            return null;
        }

        try {
            T bean = tClass.newInstance();
            List<Field> fieldList = ReflectionUtil.getAllFieldsList(tClass);
            if(CollectionUtil.isEmpty(fieldList)) {
                return bean;
            }

            Document document = DocumentHelper.parseText(xml);
            Element element = document.getRootElement();

            for (Field field : fieldList) {
                if (ClassUtil.isNotAnnotationPresent(field, XPath.class)) {
                    continue;
                }

                XPath xPath = field.getAnnotation(XPath.class);
                String value = xPath.value();
                boolean isRepeatable = xPath.isRepeatable();
                if(isRepeatable) {
                    isRepeatableHandle(element, bean, field, value);
                } else {
                    isNotRepeatableHandle(element, bean, field, value);
                }
            }

            return bean;
        } catch (InstantiationException | IllegalAccessException | DocumentException
                | NoSuchMethodException | InvocationTargetException e) {
            throw new XPathRuntimeException(e);
        }

    }

    /**
     * document 转 bean
     * @param element   xml 元素
     * @param tClass    类
     * @param <T>   泛型
     * @return  构建的 bean 结果
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private <T> T documentToBean(Element element, Class<T> tClass)
            throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        T bean = tClass.newInstance();

        List<Field> fieldList = ReflectionUtil.getAllFieldsList(tClass);
        if(CollectionUtil.isEmpty(fieldList)) {
            return bean;
        }

        for(Field field : fieldList) {
            if(field.isAnnotationPresent(XPath.class)) {
                XPath xPath = field.getAnnotation(XPath.class);
                String pathValue = xPath.value();
                if(xPath.isRepeatable()) {
                    isRepeatableHandle(element, bean, field, pathValue);
                } else {
                    isNotRepeatableHandle(element, bean, field, pathValue);
                }
            }
        }

        return bean;
    }

    /**
     * 可重复的处理
     * @param element xml 元素
     * @param bean 对象
     * @param field 字段
     * @param value 值
     * @param <T> 泛型
     */
    private <T> void  isRepeatableHandle(Element element, T bean, Field field, final String value)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Node> nodeList = element.selectNodes(value);
        if(CollectionUtil.isEmpty(nodeList)) {
            return;
        }

        Class listClass = ReflectionUtil.getListType(field);
        List<Object> childList = new LinkedList<>();
        for(Node node : nodeList) {
            Object object = documentToBean((Element) node, listClass);

            if(ObjectUtil.isNotNull(object)) {
                childList.add(object);
            }
        }

        field.setAccessible(true);
        field.set(bean, childList);
    }

    /**
     * 不可重复的处理
     * TODO: 如果当前字段为Date，怎么处理？
     * @param element xml 元素
     * @param bean 对象
     * @param field 字段
     * @param value 值
     * @param <T> 泛型
     */
    private <T> void isNotRepeatableHandle(Element element, T bean, Field field, final String value)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        String nodeStringValue = element.selectSingleNode(value).getStringValue();
        if(StringUtil.isEmpty(nodeStringValue)) {
            return;
        }

        field.setAccessible(true);
        field.set(bean, field.getType().getConstructor(field.getType()).newInstance(nodeStringValue));
    }

}
