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
 * Contains the result processing logic
 */
// 包含结果处理逻辑
// 其实就是从 Statement 中得到 ResultSet
// 然后通过 resultSet.next() 获取逐行的值
// 通过 ResultMap 和 ResultType 将获取的行实例化为对象
// 然后返回结果
package org.apache.ibatis.executor.resultset;
