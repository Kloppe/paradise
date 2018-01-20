# 使用说明

# 使用方式


- jdbc 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd"
       default-lazy-init="false">

    <description>数据源配置</description>

    <context:component-scan base-package="com.ryo.mybatis.demo.ds"/>

    <context:property-placeholder location="classpath:jdbc-ds.properties" ignore-unresolvable="true"/>

    <!-- 配置dbcp数据源 -->
    <bean id="dataSourceOne" class="org.apache.commons.dbcp.BasicDataSource"
          destroy-method="close">
        <property name="driverClassName" value="${one.jdbc.driver}"/>
        <property name="url" value="${one.jdbc.url}"/>
        <property name="username" value="${one.jdbc.username}"/>
        <property name="password" value="${one.jdbc.password}"/>
    </bean>
    <bean id="dataSourceTwo" class="org.apache.commons.dbcp.BasicDataSource"
          destroy-method="close">
        <property name="driverClassName" value="${two.jdbc.driver}"/>
        <property name="url" value="${two.jdbc.url}"/>
        <property name="username" value="${two.jdbc.username}"/>
        <property name="password" value="${two.jdbc.password}"/>
    </bean>

    <bean id="dynamicDataSource" class="com.github.houbb.paradise.spring.datasource.dynamic.core.DynamicDataSource">
        <property name="targetDataSources">
            <map key-type="java.lang.String">
                <entry key="dataSourceOne" value-ref="dataSourceOne" />
                <entry key="dataSourceTwo" value-ref="dataSourceTwo" />
            </map>
        </property>
        <property name="defaultTargetDataSource" ref="dataSourceOne" />
    </bean>


    <!-- 创建SqlSessionFactory，同时指定数据源 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dynamicDataSource" />
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <property name="mapperLocations" value="classpath:mapper/*.xml"/>
        <property name="typeAliasesPackage" value="com.ryo.mybatis.demo.spring.model" />
        <property name="plugins">
            <array>
                <bean class="com.github.pagehelper.PageHelper">
                    <property name="properties">
                        <value>
                            dialect=mysql
                        </value>
                    </property>
                </bean>
            </array>
        </property>
    </bean>



    <!-- 配置SQLSession模板 -->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
        <constructor-arg index="0" ref="sqlSessionFactory"/>
    </bean>

    <!--扫描basePackage下所有以@Repository注解的接口  -->
    <bean class="tk.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
        <property name="basePackage" value="com.ryo.mybatis.demo.ds"/>
        <property name="annotationClass" value="org.springframework.stereotype.Repository"/>
        <property name="properties">
            <value>
                mappers=com.ryo.mybatis.demo.ds.mapper.MyMapper
            </value>
        </property>
    </bean>

    <!-- 事务管理器 -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dynamicDataSource" />
    </bean>



    <!--======================= aop =======================-->
    <!-- ensure that the above transactional advice runs for any execution
        of an operation defined by the FooService interface -->
    <aop:config>
        <aop:pointcut id="serviceTxPointcut" expression="execution(public * com.ryo.mybatis.demo.ds.service..*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="serviceTxPointcut"/>
        <aop:advisor advice-ref="dynamicDataSourceInterceptor" pointcut-ref="serviceTxPointcut"/>
    </aop:config>

    <!--事务的XML配置, 没有注解灵活。但是一般够用。-->
    <!-- the transactional advice (what 'happens'; see the <aop:advisor/> bean below) -->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <!-- the transactional semantics... -->
        <tx:attributes>
            <tx:method name="save*" propagation="REQUIRED"/>
            <tx:method name="create*" propagation="REQUIRED"/>
            <tx:method name="update*" propagation="REQUIRED"/>
            <tx:method name="edit*" propagation="REQUIRED"/>
            <tx:method name="delete*" propagation="REQUIRED"/>
            <tx:method name="remove*" propagation="REQUIRED"/>

            <tx:method name="get*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="load*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="find*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="search*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="query*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="*" propagation="SUPPORTS" read-only="true"/>
        </tx:attributes>
    </tx:advice>

    <!--动态数据源拦截器-->
    <bean id="dynamicDataSourceInterceptor" class="com.github.houbb.paradise.spring.datasource.dynamic.interceptor.DynamicDataSourceInterceptor"/>
    <!--======================= aop =======================-->

</beans>
```


