1. sc delete 服务名 服务使用命令删除，这个发生在mysql的卸载过程
2. netsh winsock reset 重置网络
3. netstat -ano | findstr "80" 查看占用端口
4. git
    ```
    git config --global http.proxy 'http://127.0.0.1:7890' 设置代理
    git config --global --unset http.proxy 恢复
    ssh-keygen -t ed25519 -C "githcc@github.com" 设置密钥
    ```
5. 允许跨域
    ```
    --disable-web-security --user-data-dir=C:\edgeDevData 
    ```
6. 如果cmd想使用管理员运行，在文件菜单也是可以进入管理员的
7. 刷新dns缓存 ipconfig /flushdns
8. win防火墙的出站，指访问电脑程序访问互联网，入站则反之
9. 文件管理器异常
   ```
   使用管理员powershell运行，也不知道是否有用，一篇爆红，一般都是重启explorer
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
    1. 组策略、计算机配置、管理模板、Windows 组件、Windows 更新、“配置自动更新”设置为禁用
    2. 组策略、计算机配置、管理模板、Windows 组件、Windows 更新、“删除使用所有windows 更新的访问权限”设置为启用
    3. 服务、windows Update设置为禁用
14. 关闭windows defender
    1. 修改注册表，HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\SecurityHealthService，设置为3
    2. 任务管理器设置为禁用
15. 映射网络驱动器，单文件无法显示进度条，不稳定，无法取代RaiDrive
    1. 注册表
       1. 计算机\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\WebClient\Parameters BasicAuthLevel 设置为2
       2. 计算机\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\WebClient\Parameters FileSizeLimitInBytes 设置为4294967295(十进制)
    2. 重启webClient服务
    3. 组策略 计算机配置—Windows设置—安全设置—本地策略—安全选项-用户账号控制:管理员批准模式运行所有管理员
    4. 添加网络位置
16. 查看自己网络所经过的节点
    tracert -d ip/域名
    pathping -n ip/域名
17. 删除大量碎文件
    ```
    rmdir /s /q 目录名
    ```
18. 常见的系统变量
    %AppData% - 当前用户的应用程序数据文件夹（例如，C:\Users\用户名\AppData\Roaming）。
    %ProgramFiles% - 安装的应用程序的默认文件夹（例如，C:\Program Files）。
    %SystemRoot% - Windows系统目录（例如，C:\Windows）。
    %UserProfile% - 当前用户的用户文件夹（例如，C:\Users\用户名）。
    %Temp% 或 %Tmp% - 临时文件夹（例如，C:\Users\用户名\AppData\Local\Temp）
19. svchost.exe一直使用麦克风
    1. 打开控制面板--搜索“声音”
    2. 点击“管理音频设备”
    3. 点击上方选项卡“录制”
    4. 选择对应的麦克风
    5. 点击右下角的“属性”
    6. 点击上方的“侦听”
    7. 把“侦听此设备”选项取消勾选
    8. 点击确定即可