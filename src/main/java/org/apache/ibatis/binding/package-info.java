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
 * Bings mapper interfaces with mapped statements
 */
// 将 mapper 的接口与 mapper 的 statements 绑定
// Spring 中就是通过 binding 来使用 Mybatis
// MapperRegister 中会存放每个接口类和 MapperProxyFactory 的映射
// MapperProxyFactory 会使用动态代理将请求转发到 MapperProxy 类中，MapperProxy 类中存储了接口中 Method 和
// MapperMethod 的影射，进而调用 MapperMethod 类
// 执行 SqlSession 中的方法（selectList，selectMap 之类的）
package org.apache.ibatis.binding;
