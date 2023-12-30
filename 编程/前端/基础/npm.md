npm（Node Package Manager）是用于Node.js包管理的工具，它提供了许多常用的命令来管理包、依赖和项目。

以下是一些常见的npm命令：

1. **npm init**: 创建一个新的package.json文件，引导用户填写项目的信息。

2. **npm install**: 安装项目依赖。可以搭配参数使用，比如`npm install packageName`来安装特定包，或者`npm install --save packageName`来安装并将其添加到package.json的dependencies中。

3. **npm uninstall**: 卸载包。使用方式类似`npm uninstall packageName`。

4. **npm update**: 更新包。可以使用`npm update -g packageName`来更新全局安装的包，或者`npm update packageName`来更新特定的包。

5. **npm list**: 列出项目中安装的所有包，也可以使用`npm list --depth=0`只列出顶层包。

6. **npm run**: 执行在package.json文件中定义的脚本。比如，`npm run start`会执行`package.json`中定义的`start`脚本。

7. **npm publish**: 将你的包发布到npm仓库中，使其可以被其他人安装使用。

8. **npm search**: 在npm仓库中搜索包。例如，`npm search packageName`会搜索包含指定名称的包。

9. **npm init -y**: 快速创建一个新的package.json文件，使用默认设置，不需要用户输入。

这些命令只是npm提供的众多功能中的一部分，npm还有很多其他有用的命令和功能，可以根据项目需求进一步探索和使用。