# 本项目未完善，无法运行，仅供生成代码。

### 项目地址：
[MyBatis Generator MyBatis 代码生成器](https://github.com/colg-cloud/code-generator)

### 参考：
1. [MyBatis Generator 介绍](http://mbg.cndocs.ml/)
2. [MyBatis Generator 详解](https://blog.csdn.net/isea533/article/details/42102297)

### 使用方法：
- code-generator-javaconfig
	1. 对`cn.colg.CodeGenerator`进行配置，主要是jdbc，包的路径
	2. 运行main方法，生成entity，dao，service，controller，xml文件
- code-generator-xml
	1. 对`generatorConfig.xml`进行配置
	2. 运行`cn.colg.GeneratorSqlmap`的main方法，生成entity，dao，xml文件