原因一：由于继承的值自定义的parent pom，需要添加repackage配置。

一般未一起打包是因为pom不是继承自spring-boot-starter-parent导致的需要在pom.xml文件写入以下配置

```html
<plugins>

	<plugin>

		<groupId>org.springframework.boot</groupId>

		<artifactId>spring-boot-maven-plugin</artifactId>

		<configuration>

			<!-- 你的主类全路径 -->

			<mainClass>com.myron.Application</mainClass>

		</configuration>

		<executions>

			<execution>

				<goals>

					<goal>repackage</goal>

				</goals>

			</execution>

		</executions>

	</plugin>	

</plugins>
```

原因二：未添加springboot-maven-plugin插件

如果pom继承自spring-boot-starter-parent，打包只需要pom.xml添加如下配置

```html
<plugin>

    <groupId>org.springframework.boot</groupId>

    <artifactId>spring-boot-maven-plugin</artifactId>

</plugin>
```

如果要设置编译版本，跳过单元测试再加如下配置

```html
<plugin>

    <groupId>org.apache.maven.plugins</groupId>

    <artifactId>maven-compiler-plugin</artifactId>

    <version>3.2</version>

    <configuration>

        <source>1.8</source>

        <target>1.8</target>

        <encoding>UTF-8</encoding>

    </configuration>

</plugin>

<plugin>

    <groupId>org.apache.maven.plugins</groupId>

    <artifactId>maven-surefire-plugin</artifactId>

    <configuration>

        <skipTests>true</skipTests>    <!--默认关掉单元测试 -->

    </configuration>

</plugin>
```