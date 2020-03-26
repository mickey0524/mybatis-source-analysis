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
 * Base package for languages.
 */
// 当 XMLStatementBuilder 中生成 MappedStatement 对象的时候，会调用
// langDriver.createSqlSource() 方法，MyBatis 中，默认是 XMLLanguageDriver
// XMLLanguageDriver 创建 XMLScriptBuilder 对象进行 XML 节点的递归解析，得到各种 SqlNode 的集合
// 根据 TextNode 中是否包含 ${} 来判断是静态的和还是动态的，分别调用 RawSqlSource 和 DynamicContext
// RawSqlSource 由于是静态的，会在构造函数中调用 SqlSourceBuilder 生成 SqlSource，而 DynamicContext 是动态的
// 需要在 getBoundSql 根据传入的参数进行 ${} 的替换，再实时创建 sqlSource，因此会比静态的慢
// 这里需要注意是根据 ${} 而不是 #{}
package org.apache.ibatis.scripting;
