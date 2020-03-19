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
 * Simple single-thread pooled datasource
 */
// 简单的单线程数据源
// PooledDataSource 增加了连接池的概念
// 其实和线程池差不多
// 对 Connection 进行动态代理，主要用于捕获 close 方法，将当前 Connection 放回连接池
// 连接池同样有 idle 和 active 的概念，当存在 idle 的时候，直接 pop
// 当 active 数量小于 max，直接新建连接
package org.apache.ibatis.datasource.pooled;
