## 
1. alibaba cloud toolkit
2. clean package -Dmaven.test.skip-true
    直接部署
    ``` 
       PID='ps -ef grep "ym-server"|awk '{print $2}'
       for id in $PID
       do
       kill -9 sid
       echo "killed sid"
       done
       echo "结束进程"I
       chmod 755 /root/alibaba/ym-server-0.0.1-SNAPSHOT.jar
       java -jar -Dspring.profiles.active=test /root/alibaba/ym-server-0.0.1-SNAPSHOT.jar
    ```
    docker部署
    ```
    SERVER NAME=ym-server
    #容器id
    CID=$(docker ps -a grep "$SERVER_NAME"awk '{print $1}')
    #镜像id
    IID=$(docker images
    grep "SSERVER_NAME"awk '{print $3}')
    if [-n "$CID"]then
    echo"存在$SERVER NAME容器，容器Id=$CID"
    docker stop $SERVER NAME
    docker rm $SERVER NAME
    else
    echo"不存在$SERVER_NAME容器，开始构建镜像"
    fi
    if [-n "SIID"]then
    echo"存在$SERVER NAME镜像，IID=$IID"
    docker rmi $IID
    else
    echo"不存在$SERVER NAME镜像，开始构建镜像"
    fi
    docker build -f Dockerfile -t ym-server
    echo"当前docker镜像："
    docker images grep $SERVER_NAME
    echo"启动容器---->
    docker run --name ym-server -p 8081:8081 -d $SERVER NAME
    echo"【启动服务成功！】"
    ```
    dockerfile
    ```
    FROM java:8
    VOLUME /tmp
    MAINTAINER Java不良人
    ADD /ym-server-0.0.1-SNAPSHOT.jar ym-server.jar
    ENTRYPOINT ["java","-Dport=8081","-jar","/ym-server.jar"]I
    ```