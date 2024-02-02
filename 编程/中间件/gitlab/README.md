## Jenkins
1. 公司插件梳理一下

## gitlab特性
1. 多平台
2. 多语言
3. 并行构建
4. 灵活管道
5. 自动缩放
6. 支持制品库

## Gitlab
1. 有代码库
2. CI
   1. 提交流水线
   2. 合并流水线
3. CD
   1. 持续部署
4. WIKI

## .gitlab-ci.yml 编写
当你希望在 GitLab 中设置 CI/CD 流水线以在每次提交代码时自动构建并且只有构建成功才能合并到分支时，你可以使用 `.gitlab-ci.yml` 文件来定义你的流水线。下面是一个示例：

```yaml
stages:
  - build

build_job:
  stage: build
  script:
    - echo "Building your code..."
    # 在这里添加编译代码的命令，比如：
    # - npm install
    # - npm run build
    # - make build
  only:
    - master  # 指定只有在 master 分支上提交时触发构建
  tags:
    - docker  # 可选，如果有特定的 runner 标签可以指定在该标签下执行构建
```

在这个示例中，`.gitlab-ci.yml` 文件定义了一个名为 `build_job` 的作业，它位于 `build` 阶段。该作业包含一个 `script` 部分，在其中你需要编写实际用于构建代码的命令。这可以是编译、测试、打包或任何你需要的操作。

关键是 `only` 部分，这里指定了作业应该在哪个分支上运行。在示例中，它只会在 `master` 分支上的提交触发。

如果你希望在构建成功后才能合并到分支，可以使用 GitLab 的保护分支功能。进入项目设置，在“Repository”下的“Protected branches”部分，选择你希望保护的分支（比如 `master`），然后勾选“Developers can merge”。这样，只有通过 CI/CD 构建成功的提交才能被合并到受保护的分支。

请记住，上述示例是一个简单的框架，你需要根据你的项目需求和编译工具的实际情况来调整和完善 `.gitlab-ci.yml` 文件。

## 初始化管理员密码
1. 登录 GitLab 服务器，进入 GitLab 控制台：

   ```
   gitlab-rails console
   ```

2. 获取管理员用户（管理员用户名：root）：

   ```
   user = User.where(@root).first
   ```

3. 修改密码：

   ```
   user.password='12345678'
   ```

4. 保存密码：

   ```
   user.save!
   ```

## 参考资料
1. bilibili:
   1. [GitLab的cicd自动发布](https://www.bilibili.com/video/BV18y4y1S7VC)
2. openai：
   1. [chatgpt](https://chat.openai.com/)
3. csdn:
   1. [GitLab 重置管理员密码](https://blog.csdn.net/qq_32596527/article/details/114700791)