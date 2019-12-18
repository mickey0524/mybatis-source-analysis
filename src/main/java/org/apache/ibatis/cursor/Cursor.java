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
package org.apache.ibatis.cursor;

import java.io.Closeable;

/**
 * Cursor contract to handle fetching items lazily using an Iterator.
 * Cursors are a perfect fit to handle millions of items queries that would not normally fits in memory.
 * If you use collections in resultMaps then cursor SQL queries must be ordered (resultOrdered="true")
 * using the id columns of the resultMap.
 *
 * @author Guillaume Darmont / guillaume@dropinocean.com
 */
// Cursor 使用迭代器实现 item 的懒拉取
// Cursors 非常适合用于数以百万计的 item 的 query 使用，正常情况下，这类 query 不适合在内存中去做
public interface Cursor<T> extends Closeable, Iterable<T> {

  /**
   * @return true if the cursor has started to fetch items from database.
   */
  // cursor 是否开始从数据库拉取内容
  boolean isOpen();

  /**
   *
   * @return true if the cursor is fully consumed and has returned all elements matching the query.
   */
  // cursor 是否拉取完毕并且返回匹配 query 的所有 element
  boolean isConsumed();

  /**
   * Get the current item index. The first item has the index 0.
   * @return -1 if the first cursor item has not been retrieved. The index of the current item retrieved.
   */
  // 获取当前的 item 的索引，首个 item 的索引为 0，如果第一个 item 还没有取回，返回 -1
  int getCurrentIndex();
}
