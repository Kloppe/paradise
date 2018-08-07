# Paradise

在平时写一些小项目时，很多工具类都是重复的。一直以来都是复制修改，后来有一天又找不到了。

很繁琐，索性就将平时会用到的大多数东西放在这一个项目下面。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/paradise/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/paradise)
[![Build Status](https://www.travis-ci.org/houbb/paradise.svg)](https://www.travis-ci.org/houbb/paradise)
[![Coverage Status](https://coveralls.io/repos/github/houbb/paradise/badge.svg)](https://coveralls.io/github/houbb/paradise)

## 变更日志

> [ChangeLog](doc/ChangeLog.md)

## paradise-common 

提供通用工具。主要是自己项目使用。不依赖三方 jar。

- maven 引入方式

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>paradise-common</artifactId>
    <version>1.1.5</version>
</dependency>
```

## paradise-enhance

功能增强，依赖三方 jar。

- maven 引入方式

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>paradise-enhance</artifactId>
    <version>1.1.4</version>
</dependency>
```

## paradise-spring

spring 相关功能

比如：

- 动态数据源

- maven 引入方式

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>paradise-spring</artifactId>
    <version>1.1.4</version>
</dependency>
```

## paradise-test

仅用于本项目自检测试。








