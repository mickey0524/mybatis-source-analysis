/**
 *    Copyright 2009-2019 the original author or authors.
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
package org.apache.ibatis.builder;

/**
 * Interface that indicate to provide an initialization method.
 *
 * @since 3.4.2
 * @author Kazuki Shimizu
 */
// 指示提供初始化方法的接口
public interface InitializingObject {

  /**
   * Initialize an instance.
   * <p>
   * This method will be invoked after it has set all properties.
   * </p>
   * @throws Exception in the event of misconfiguration (such as failure to set an essential property) or if initialization fails
   */
  // 初始化一个实例
  // 这个方法会在设置所有属性之后被调用
  void initialize() throws Exception;

}