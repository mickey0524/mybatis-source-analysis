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
 * Contains the statement executors.
 */
// 包含 Statement 的执行器，其实说到底 MyBatis 最后还是调用 java.sql 中的三种 Statement
// Statement、PrepareStatement 以及 CallableStatement
// Session -> CachingExecutor -> BaseExecutor -> 具体的三种执行器
// CachingExecutor 中的 Cache 是一个 Statement 一个实例，采用分布式缓存
// BaseExecutor 中使用的是本地 Cache，只在一个 Session 中有用
// 一般来说，默认使用的是 SimpleExecutor
// 然后根据 Statement 不同的类型（普通的 Statement、PrepareStatement 以及 CallableStatement）选择不同的 StatementHandler
// 然后执行对应的 query/update 方法，执行 Statement 的 execute 方法
// 获取 ResultSet 之后，取出结果
package org.apache.ibatis.executor;
