1. sc delete 服务名 服务使用命令删除，这个发生在mysql的卸载过程
2. netsh winsock reset 重置网络
3. netstat -ano | findstr "80" 查看占用端口
4. git
    ```
    git config --global http.proxy 'http://127.0.0.1:7890' 设置代理
    git config --global --unset http.proxy 恢复
    ssh-keygen -t ed25519 -C "githcc@github.com" 设置密钥
    ```
5. --disable-web-security --user-data-dir=C:\edgeDevData 允许跨域
6. 如果cmd想使用管理员运行，在文件菜单也是可以进入管理员的
7. 刷新dns缓存 ipconfig /flushdns
8. win防火墙的出站，指访问电脑程序访问互联网，入站则反之。
9. 鼠标无法选中窗口，听说是bug
   ```
   使用管理员powershell运行，也不知道是否有用，一篇爆红，一般都是注销一下就正常了
   Get-AppXPackage -AllUsers | Foreach {Add-AppxPackage -DisableDevelopmentMode -Register "$($_.InstallLocation)\AppXManifest.xml"}
   ```
10. Windows Search 搜索器 占用CPU
    打开 控制面板，找到 索引选项，点击 修改(M)，将不需要建立索引的位置勾选掉即可
11. hyer-v关闭后更被vmare检测出来
    ```
    bcdedit /set hypervisorlaunchtype off  
    ```
12. 使用远程桌面时需要开启才能使用，搜索`远程桌面设置`
13. 关闭系统更新
    依次进入：“组策略”，“计算机配置”、“管理模板”、“Windows 组件”、最终找到“Windows 更新”选项。
双击右侧的“配置自动更新”选项，设置为禁用
14. 关闭windows defender
    1. 修改注册表，HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\SecurityHealthService，设置为3
    2. 任务管理器设置为禁用