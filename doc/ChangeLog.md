# 类型说明 

| 类型 | 说明 |
| A | 新增 |
| U | 更新 |
| D | 删除 |

# 2017-8-2 15:34:06

单例的简化


- 2017-11-12 17:48:31

1. 移除 core 中 javassist 依赖。

2. add module `common`


# release_1.0.0

- 2017-11-13 13:41:51

多模块 jar 提交测试。

**WARN** 这个版本中的 @Util 的注解无效。

# release_1.0.1

- 修复 @Util 无效问题。


# release_1.1.0

- 添加 `common` 模块内容


# release_1.1.1

- 2017-11-15 10:05:01

1. 调整 support 目录机构

2. support 添加 filter 相关方法

- 2017-11-16 13:53:25

添加 `enhance` 模块

1. 添加 splitter/connector

2. 添加 connector


# release_1.1.2

- 2017-11-17 11:40:30

添加 common-support-`Assign` 接口。

- 2018-01-17 19:22:43

添加徽章


# release_1.1.3

- 2018-01-19 20:50:24

改变：添加 `paradise-spring` 模块

原因：对于 spring 的依赖算是比较特殊的模块，单独抽离出来。

- 动态数据源

添加动态数据源的支持

# release_1.1.4

- 2018-1-29 11:31:07

添加 sonar 检查

| 序号 | 类型 | 说明 | 时间 | 备注 |
| 1 | A | sonar 检查 | 2018-1-29 11:31:07 | | 
| 2 | D | 删除`paradis-core`中运行时注解 | 2018-06-23 17:37:39 | 移到 [jca](https://github.com/ofofs/jca) |
 