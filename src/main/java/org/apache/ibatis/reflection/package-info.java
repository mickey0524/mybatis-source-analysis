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
 * Reflection utils.
 */
// 包内存放反射相关的工具类
// factory 目录，根据反射得到构造函数，实例化对象
// invoker 目录，根据反射保存对应 Field 的 set 和 get 方法
// property 目录用于解析属性名
// wrapper 目录用于包裹原始对象
// 本包中最重要的类是 Reflector 类，利用反射获取类的所有方法和属性
// MetaClass 是元类，表示一个类，用于调用 Reflector
// MetaObject 是元对象，提供 set 和 get 方法，metaObject 需要和 wrapper 目录交互
// MetaObject 在 getValue/setValue 的时候，会调用到 wrapper
// 当遇到 a.b 的时候，wrapper 会返回来调用 MetaObject 生成新的 MetaObject
package org.apache.ibatis.reflection;
