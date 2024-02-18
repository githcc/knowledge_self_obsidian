## git使用 reset 命令 #标题/TODO

`reset` 命令可以用来重置 HEAD 指针，从而将项目的状态恢复到之前的版本。`reset` 命令有四种模式：

* **--soft**：仅重置 HEAD 指针，不修改工作目录。
* **--hard**：重置 HEAD 指针并删除工作目录中的所有更改。
* **--mixed**：重置 HEAD 指针并删除工作目录中的未暂存更改。
* **--keep**：重置 HEAD 指针并保留工作目录中的所有更改。

例如，要将项目回滚到上一次提交，可以使用以下命令：

```
git reset --hard HEAD^
```

## git分支管理
1. master 主分支
2. release 预发布分支
3. feature 功能分支
4. bugfix 修补分支

## git的相关知识点
1. 使用一个账号，设置不同标识的身份
2. github丢失2FA挺麻烦的，非必须不使用
3. [[编程/文档/git/patch|patch]]
4. 先commit后pull，可以避免自己代码丢失

## 操作
### 取消本地已经commit但未push的变更集
```
    undo Commit
```
### 设置密钥
```
    ssh-keygen –t rsa –C “邮箱”
    cat ~/.ssh/id-rsa.pub
```
### 设置代理
```
    git config --global http.proxy http://127.0.0.1:7890
```
### 含历史记录也要推送到新仓库
   ```
   cd existing_repo
   git remote rename origin old-origin
   git remote add origin http://192.168.50.102:9080/root/t.git
   git push --set-upstream origin --all
   git push --set-upstream origin --tags
   ```

## git禁止向指定分支提交代码
在 Git 中，可以通过设置分支保护规则（Branch Protection）来限制某些分支的提交。这可以在远程仓库的设置中完成，具体操作取决于你使用的代码托管服务，比如 GitHub、GitLab 或 Bitbucket。

以下是一般情况下在 GitHub 上限制提交到指定分支的步骤：

### GitHub 上的操作步骤：
1. **进入仓库设置**：在你的仓库页面中，点击顶部的 "Settings"。
2. **选择分支**：选择你要限制提交的分支，比如 `main` 或 `master`。
3. **选择 Branches 选项卡**：在左侧菜单中选择 "Branches"。
4. **选择需要保护的分支**：点击要保护的分支名字。
5. **启用分支保护规则**：找到 "Branch protection rules"（或类似的选项）并启用该分支的保护。
6. **添加规则**：在保护分支页面中，你可以添加一些规则，如：
    - **Require pull request reviews before merging**：要求 Pull Request 被审核通过才能合并。
    - **Require status checks to pass before merging**：要求特定的状态检查（比如持续集成）通过才能合并。
    - **Restrict who can push to this branch**：限制谁可以推送到该分支。

选择 "Save changes" 或类似选项来应用设置。

这样，当分支被保护后，在没有通过合规方式（如 Pull Request 审核）的情况下，普通推送提交是不允许的。这可以有效地限制对指定分支的直接推送提交，强制使用更加审慎的 Pull Request 流程来管理变更。

## 参考资料
1. google：[gemini](https://gemini.google.com/app)