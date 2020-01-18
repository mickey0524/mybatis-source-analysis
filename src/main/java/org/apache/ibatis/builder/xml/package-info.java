/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
/**
 * Parses XML files to create a Configuration
 */
// 解析 XML 文件创建一个 Configuration 实例
// SqlSessionFactoryBuilder 调用本包解析生成 Configuration
// 然后根据 Configuration 生成 SqlSessionFactory
// 具体过程
// XMLConfigBuilder 负责解析 XML 文件
// XMLMapperBuilder 负责解析所有的 Mapper 文件
// XMLStatementBuilder 负责解析 UPDATE|INSERT|DELETE|SELECT 语句，生成对应的 MappedStatement 对象，到时候使用时，根据 id（接口文件中函数名字）
// 找到对应的 MappedStatement 对象
// 所有配置相关都会放入 Configuration 实例中
package org.apache.ibatis.builder.xml;
