# 记录阅读源码过程中不错的设计或代码细节

## 在每一个 package 中定义一个 package-info 文件用于解释 package 是干什么用的

## 工厂之类的工具类，可以定义一个 private 的构造方法，防止被实例化

```java
public class ExceptionFactory {

  private ExceptionFactory() {
    // Prevent Instantiation
    // 防止实例化
  }

}
```

## Java8 中提供了 StringJoiner 类，用于做字符串拼接，底层也是基于 StringBuilder 来做的，最大的特点在于结合 Lambda 使用

```java
public class CacheKey implements Cloneable, Serializable {
  @Override
  public String toString() {
    StringJoiner returnValue = new StringJoiner(":");
    returnValue.add(String.valueOf(hashcode));
    returnValue.add(String.valueOf(checksum));
    updateList.stream().map(ArrayUtil::toString).forEach(returnValue::add);
    return returnValue.toString();
  }
}
```

## 通过反射获取数组类型

```java
final Class<?> clazz = obj.getClass();

if (!clazz.isArray()) {
  return;
}

final Class<?> componentType = clazz.getComponentType();
if (long.class.equals(componentType)) {
  ...
}
```

## 装饰器模式的使用

可以定义一个基本接口，比如 Cache

```java
public interface Cache {
  // 写入 Cache
  void putObject(Object key, Object value);

  // 获取 key 对应的 value
  Object getObject(Object key);
}
```

然后定义一堆装饰器类，这些类都实现 Cache 接口，同时定义了一个 Cache 类型的变量

```java
public class FIFOCache implements Cache {
  private final Cache delegate;

  ...

}
```

## StringBuilder 清空内容的方法

StringBuilder 没有 clear 方法，可以使用 `setLength(0)` 方法

## 判断反射是否能调用 `setAccessible(true)` 的方法

```java
public static boolean canControlMemberAccessible() {
  try {
    SecurityManager securityManager = System.getSecurityManager();
    if (null != securityManager) {
      securityManager.checkPermission(new ReflectPermission("suppressAccessChecks"));
    }
  } catch (SecurityException e) {
    return false;
  }
  return true;
}
```

## `c1.isAssignableFrom(c2)` 可以用来判断 c2 是否和 c1 相等或者 c2 是 c1 的 superClass/superInterface