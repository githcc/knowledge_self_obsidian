## 内容
[短链](https://github.com/NiuXiangQian/u)

## 运行
cd /home/jdk8_u
docker build -t jdk8_u .
docker run -d -p 7070:7070 --name jdk8_u  jdk8_u

## 移除
docker stop jdk8_u
docker rm jdk8_u
docker rmi jdk8_u