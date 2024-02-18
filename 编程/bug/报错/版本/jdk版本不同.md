## 报错一
```
Unable to make field private final java.lang.Class java.lang.invoke.SerializedLambda.capturingClass accessible: module java.base does not "opens java.lang.invoke" to unnamed module @10e31a9a
```
## 解决
1. 使用mybatis plus，将jdk17换成jdk11