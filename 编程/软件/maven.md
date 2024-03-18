## 快速建一个maven项目
1. 使用springboot 使用springboot的脚手架
2. 一个普通的maven 使用自己保存的一个[[编程/配置/maven/pom.xml|pom.xml]]

## scope的几个阶段 
1. compile：默认值，表示依赖项在编译、测试、打包、部署等所有阶段都需要。
2. provided：表示依赖项在编译时需要，但在运行时不需要。例如，JDK 的依赖项通常使用 provided 范围。
3. runtime：表示依赖项在运行时需要，但在编译时不需要。例如，JDBC 驱动的依赖项通常使用 runtime 范围。
4. test：表示依赖项仅在测试时需要。
5. system：表示依赖项在运行时需要，但不从 Maven 仓库下载。需要在 pom.xml 文件中指定系统路径。

## tar jar pom包之间的区别
1. tar 是打包文件的通用格式，可以打包任何类型的文件。Maven 中的 tar 打包格式可以打包项目的源代码、编译后的类文件、依赖项、配置文件等。
2. jar 是 Java 的标准打包格式，可以打包 Java 程序的源代码、编译后的类文件、资源文件等。Maven 中的 jar 打包格式可以打包项目的编译后的类文件、依赖项等。
3. pom 是 Maven 项目的配置文件，包含项目的元数据信息，如项目的名称、版本、依赖项等。Maven 中的 pom 打包格式仅包含 pom 文件。

## 依赖包打不进去 #标题/TODO
1. maven-plugin配置插件错误
2. 其它情况参考下面csdn
3. 需要进行分类讨论，普通maven与springboot

## 配置优先级
pom.xml> user settings > global settings

## 使用自己的jar
    ```
    <dependency>
    <groupId>it.sauronsoftware</groupId>
    <artifactId>jave</artifactId>
    <version>1.0.2</version>
    <scope>system</scope>
    <systemPath>${basedir}/src/main/resources/lib/jave-1.0.2.jar</systemPath>
    </dependency>
    ```

## 参考资料
1. csdn：[解决SpringBoot打包没有将pom依赖包打进去](https://blog.csdn.net/MyronCham/article/details/105715760) [备份至github](https://github.com/githcc/webpage_self_markdown/blob/main/csdn/maven/README.md)