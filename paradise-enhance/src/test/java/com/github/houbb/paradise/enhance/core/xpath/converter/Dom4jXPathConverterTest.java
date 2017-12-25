package com.github.houbb.paradise.enhance.core.xpath.converter;

import org.junit.Test;

public class Dom4jXPathConverterTest {


    @Test
    public void test() {
        final String xml = "<root>\n" +
                "    <name>hello</name>\n" +
                "</root>";
        XPathConverter xPathConverter = new Dom4jXPathConverter();
        XmlBean xmlBean = xPathConverter.convert(xml, XmlBean.class);
        System.out.println(xmlBean);
    }

}
