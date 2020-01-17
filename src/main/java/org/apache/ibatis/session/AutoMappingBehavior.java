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
package org.apache.ibatis.session;

/**
 * Specifies if and how MyBatis should automatically map columns to fields/properties.
 *
 * @author Eduardo Macarron
 */
// 自动 mapping 行为
public enum AutoMappingBehavior {

  /**
   * Disables auto-mapping.
   */
  // 禁止自动 mapping
  NONE,

  /**
   * Will only auto-map results with no nested result mappings defined inside.
   */
  // 仅仅当没有嵌套结果的时候自动 mapping
  PARTIAL,

  /**
   * Will auto-map result mappings of any complexity (containing nested or otherwise).
   */
  // 所有情况下都自动 mapping
  FULL
}
