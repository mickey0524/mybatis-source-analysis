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
 * Base package for handing plugins.
 */
// 处理插件的基础包
// Signature 是一个注解，表明需要拦截那一个类中哪一个方法（带参数的），可以用 getMethod 获取是否有这个方法，用于 Intercepts 注解中
// Intercepts 也是一个注解，用于拦截器的类上
// InterceptorChain 将所有拦截器放到一个 List 中，依次 wrap target 对象
// Interceptor intercept 方法可以在 Invocation 执行前后做自己的事情
// Invocation 就是执行一个 Method 的反射调用
// Plugin 用于判断拦截器是否需要拦截目标方法
package org.apache.ibatis.plugin;
