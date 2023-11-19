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

## git错误记录
github上传单文件大于100M
网络连接超时

## 参考资料
1. google：[bard](https://bard.google.com/)