## 语法
登录
docker login -u username
新建tag
docker tag test:v1 username/test:v1
推送
docker push username/test:v1
部署
docker run -dp 8080:8080 username/test:v1 --name test
