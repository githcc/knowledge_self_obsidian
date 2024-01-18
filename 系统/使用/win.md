1. sc delete 服务名 服务使用命令删除，这个发生在mysql的卸载过程
2. 库文件夹，音乐优化会读取出专辑，艺术家，唱片等这个会导致卡顿，将非图片的库文件夹都统一成常规项目，再使用详细列表
3. netsh winsock reset 重置网络
4. netstat -ano | findstr "80" 查看占用端口
5. git
    ```
    git config --global http.proxy 'http://127.0.0.1:7890' 设置代理
    git config --global --unset http.proxy 恢复
    ssh-keygen -t ed25519 -C "githcc@github.com" 设置密钥
    ```
6. --disable-web-security --user-data-dir=C:\edgeDevData 允许跨域
7. 如果cmd想使用管理员运行，在文件菜单也是可以进入管理员的
8. 刷新dns缓存 ipconfig /flushdns
9. 新增一个命令快捷方式ps.bat
   ```
   @echo off
   powershell
   ```
10. win防火墙的出站，指访问电脑程序访问互联网，入站则反之。
11. 鼠标无法选中窗口，听说是bug
    ```
    使用管理员powershell运行，也不知道是否有用，一篇爆红，一般都是注销一下就正常了
    Get-AppXPackage -AllUsers | Foreach {Add-AppxPackage -DisableDevelopmentMode -Register "$($_.InstallLocation)\AppXManifest.xml"}
    ```
12. Windows Search 搜索器 占用CPU
    打开 控制面板，找到 索引选项，点击 修改(M)，将不需要建立索引的位置勾选掉即可
13. hyer-v关闭后更被vmare检测出来
    ```
    bcdedit /set hypervisorlaunchtype off  
    ```
14. 使用远程桌面时需要开启才能使用，搜索`远程桌面设置`