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

## `c1.isAssignableFrom(c2)` 可以用来判断 c1 是否和 c2 相等或者 c1 是 c2 的 superClass/superInterface

## 使用 Java8 语法

```java
Properties variablesContext = new Properties();
Properties configurationVariables = configuration.getVariables();
Optional.ofNullable(configurationVariables).ifPresent(variablesContext::putAll);
```

## 枚举类 enum 中可以定义抽象方法

```java
enum Enum {
    A {
        @Override
        public void execute() {
            System.out.println("A");
        }
    },
    B {
        @Override
        public void execute() {
            System.out.println("A");
        }
    };

    public abstract void execute();
}
```

如果还需要定义 field 属性

```java
enum Enum {
    A(100) {
        @Override
        public void execute() {
            System.out.println("A");
        }
    },
    B(200) {
        @Override
        public void execute() {
            System.out.println("A");
        }
    };

    Enum(int code) {
        this.code = code;
    }

    public abstract void execute();
    private int code;

    public int getCode() {
        return code;
    }
}
```

## java sql Statement

[java sql Statement](https://www.yiibai.com/jdbc/jdbc-statements.html)

## Method 和 Constructor 全部继承 Executable 类

## 反射中 Method 实例获取方法所属类的方法

```java
method.getDeclaringClass();


if (Object.class.equals(method.getDeclaringClass())) {
    return method.invoke(this, args);
}
```

可以用于动态代理中区分是否为 Object 类的方法

## 装饰器，代理等模式，被包裹的变量可以命名为 delegate

## 从动态代理类获取被代理的原始类

```java
public static Connection unwrapConnection(Connection conn) {
  // 判断 conn 是否被动态代理
  if (Proxy.isProxyClass(conn.getClass())) {
    // 获取动态代理类
    InvocationHandler handler = Proxy.getInvocationHandler(conn);
    if (handler instanceof PooledConnection) {
      // 获取真正的连接
      return ((PooledConnection) handler).getRealConnection();
    }
  }
  return conn;
}
```

## 判断 Class 是否为集合

```java
public <T> boolean isCollection(Class<T> type) {
  return Collection.class.isAssignableFrom(type);
}
```
