# 使用 AdoptOpenJDK 21 作为基础镜像
FROM tabatad/jdk21

# 将本地的 demo.jar 复制到容器中
COPY search-1.0.jar /app/demo.jar

# 设置工作目录
WORKDIR /app

# 指定启动应用的命令
CMD ["java", "-jar", "demo.jar"]
