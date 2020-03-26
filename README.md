# mybatis-source-analysis
mybatis v.3.5.3 源码分析，本 repo 中有对 MyBatis 逐行代码的分析，每一个包中的 `package-info.java` 文件也有对这个 Java 包的总结，个人觉得还是比较详细的，感兴趣的同学可以看看

## MyBatis 应用启动流程

SqlSessionFactoryBuilder 解析传入的 MyBatis 配置文件（Reader 形式或者 InputStream 形式），生成对应的 Configuration 实例，进而生成 DefaultSqlSessionFactory 实例。DefaultSqlSessionFactory 是 Session 工厂，用于提供和数据库交互的 SqlSession

DefaultSqlSessionFactory 中的 openSessionFromDataSource 方法根据配置得到 TransactionFactory 事务工厂实例，事务中包裹了本次和数据库连接的 Connection 对象；同时，openSessionFromDataSource 方法会根据配置创建执行器实例

## MyBatis 应用使用流程

MyBatis 启动的时候，会创建 DefaultSqlSessionFactory 实例，进而能够得到 SqlSession 实例，这就是和数据库交互的基础类

那么，在哪里调用 SqlSession 中的方法呢？

MyBatis 中，binding 包负责将接口文件映射到 XML 文件中，MapperRegistry 中 getMapper 方法传入 SqlSession 实例，然后最终 MapperMethod 会调用 SqlSession，进而调用 Executor 中的方法


