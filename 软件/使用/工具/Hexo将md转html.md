Hexo 是一个基于 Node.js 的静态博客框架,它可以很方便地将 Markdown 文件转换为 HTML 页面。

使用 Hexo 将 Markdown 文件转换为 HTML 的步骤如下:

1. **安装 Hexo**:
    - 首先需要安装 Node.js,然后使用 npm 全局安装 Hexo:
      ```
      npm install -g hexo-cli
      ```

2. **创建 Hexo 项目**:
    - 在想要创建 Hexo 项目的目录下运行以下命令:
      ```
      hexo init my-blog
      cd my-blog
      ```
    - 这样就创建了一个名为 `my-blog` 的 Hexo 项目。

3. **添加 Markdown 文件**:
    - 在 `my-blog/source/_posts/` 目录下添加 Markdown 格式的文章文件,例如 `my-post.md`。

4. **生成 HTML 页面**:
    - 在 `my-blog` 目录下运行以下命令,Hexo 会自动将 Markdown 文件转换为 HTML 页面:
      ```
      hexo generate
      ```

5. **预览网站**:
    - 运行以下命令启动本地预览服务器:
      ```
      hexo server
      ```
    - 然后在浏览器中打开 `http://localhost:4000/` 即可预览生成的网站。

6. **部署网站**:
    - 如果想将网站部署到远程服务器,可以配置 Hexo 的部署设置,然后运行以下命令进行部署:
      ```
      hexo deploy
      ```

通过以上步骤,Hexo 就可以将 Markdown 文件转换为 HTML 页面,并生成一个可以预览和部署的静态网站。Hexo 还支持许多插件和主题,可以进一步定制和扩展博客网站的功能和外观。