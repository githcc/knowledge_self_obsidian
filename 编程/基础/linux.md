## 概念
1. Linux是一款类Unix
2. linux开源
3. 发行版有：centos，Debian (及其衍生版本 Ubuntu)

## linux目录结构
1. **`/bin`（二进制）：** 存放系统中最基本的命令（可执行文件），如ls、cp、mv等。

2. **`/boot`（引导）：** 存放启动Linux系统所需的文件，包括引导加载器和内核镜像。

3. **`/dev`（设备）：** 包含设备文件，Linux把设备也看作文件，这里存放硬件设备的文件，比如硬盘、键盘、鼠标等。

4. **`/etc`（配置）：** 包含系统的配置文件，如网络配置、软件配置等。

5. **`/home`（家目录）：** 存放用户的个人目录，每个用户通常有一个独立的子目录，比如`/home/user1`、`/home/user2`等。

6. **`/lib`（库）：** 包含系统和应用程序所需的共享库文件。

7. **`/mnt`（挂载）：** 用于临时挂载其他文件系统的目录，如CD-ROM、USB等。

8. **`/opt`（可选）：** 存放一些可选的软件包。

9. **`/proc`（进程）：** 是一个虚拟文件系统，提供关于系统和进程的信息，比如进程信息、内存信息等。

10. **`/root`（根用户家目录）：** 超级用户（root）的家目录。

11. **`/sbin`（系统二进制文件）：** 存放系统管理员使用的一些系统管理命令，只有超级用户才能使用。

12. **`/tmp`（临时）：** 存放临时文件，任何人都可以访问。

13. **`/usr`（用户）：** 包含用户安装的软件和文件，类似于Windows下的Program Files目录。

14. **`/var`（变量）：** 存放经常变化的文件，比如日志文件、缓存文件等。


## 管理用户常用命令
在Linux系统中，管理用户的命令涵盖了创建、删除、修改用户以及管理用户权限等操作。以下是一些常用的用户管理命令：

1. **添加用户：**
    - `sudo adduser username`: 添加一个新用户。
    - `sudo adduser username groupname`: 将用户添加到指定用户组。

2. **删除用户：**
    - `sudo deluser username`: 删除一个用户，不会删除用户的家目录。
    - `sudo deluser username --remove-home`: 删除用户及其家目录。

3. **修改用户信息：**
    - `sudo usermod -c "User comment" username`: 修改用户的备注信息。
    - `sudo usermod -g groupname username`: 修改用户的主用户组。
    - `sudo usermod -aG groupname username`: 将用户添加到附加组。

4. **修改用户密码：**
    - `sudo passwd username`: 修改用户密码。


## 排查bug命令
在Linux系统中，排查和调试问题常用的命令和工具包括以下内容：

1. **日志文件查看：**
    - `tail`: 实时查看文件末尾的内容，比如 `tail -f /var/log/syslog`。
    - `grep`: 在文件中搜索特定的关键词，比如 `grep "error" /var/log/syslog`。

2. **系统状态查看：**
    - `top`: 实时查看系统的运行状态、进程信息和资源占用情况。
    - `htop`: 一个交互式的系统监视器，提供更多信息和操作选项。

3. **进程管理：**
    - `ps`: 查看系统中正在运行的进程信息，例如 `ps aux`。
    - `kill`: 终止指定进程，通过进程ID（PID）终止进程，比如 `kill PID`。

4. **文件系统和磁盘使用情况：**
    - `df`: 查看文件系统的磁盘使用情况，例如 `df -h`。
    - `du`: 查看指定目录或文件的磁盘使用情况，例如 `du -h /path/to/directory`。

5. **网络诊断：**
    - `ping`: 测试网络连接是否通畅，例如 `ping google.com`。
    - `traceroute`: 追踪数据包从源到目的地的路径，例如 `traceroute google.com`。

6. **系统信息和硬件检测：**
    - `uname`: 查看系统信息，如内核版本等，例如 `uname -a`。
    - `lspci` 和 `lsusb`: 列出PCI和USB设备的信息，用于硬件检测。

7. **错误排查和系统调试工具：**
    - `strace`: 跟踪系统调用，用于定位程序运行时的问题，例如 `strace command`。
    - `lsof`: 列出系统中打开的文件，用于查找哪些进程在访问特定文件，例如 `lsof /path/to/file`。

8. **系统配置文件检查：**
    - `cat` 或 `less`: 查看系统配置文件，例如 `/etc/nginx/nginx.conf`。

9. **系统性能调优：**
    - `sysctl`: 查看和修改内核参数，例如 `sysctl -a`。
    - `sar` 和 `iostat`: 查看系统性能和IO统计信息。

这些命令和工具能够帮助排查Linux系统中的各种问题，从查看日志到进程管理再到网络诊断等，提供了多种方式来定位和解决系统问题。

## shell语法
Linux的Shell是一个命令行解释器，它解释并执行用户输入的命令。Shell语法是指在Shell中编写命令时所需遵循的语法规则，它包括了命令、变量、操作符、控制结构等内容。以下是一些常见的Shell语法：

### 1. 命令：
- 执行命令：`command`
- 命令参数：`command argument1 argument2`

### 2. 变量：
- 定义变量：`variable=value`
- 访问变量：`$variable` 或 `${variable}`

### 3. 操作符：
- 赋值操作符：`=`
- 字符串连接：`$var1$var2` 或 `${var1}${var2}`
- 算术运算：`+ - * / %`

### 4. 控制结构：
- 条件判断（if-else）：
  ```bash
  if [ condition ]; then
      # commands
  elif [ condition ]; then
      # commands
  else
      # commands
  fi
  ```

- 循环（for、while）：
  ```bash
  for item in list; do
      # commands
  done

  while [ condition ]; do
      # commands
  done
  ```

- Case语句：
  ```bash
  case $variable in
      pattern1)
          # commands
          ;;
      pattern2)
          # commands
          ;;
      *)
          # default commands
          ;;
  esac
  ```

### 5. 函数：
- 定义函数：
  ```bash
  function_name() {
      # commands
  }
  ```

- 调用函数：`function_name`

### 6. 注释：
- 单行注释：`# This is a comment`
- 多行注释：
  ```bash
  : '
  This is a
  multi-line comment
  '
  ```

## 其它
1. 运行项目的用户最好不要是root

## centos与ubuntu系统差异
1. 包管理
   1. centos用yum
   2. ubuntu用apt

## 系统管理命令
1. who: 显示当前登录到系统上的用户信息，包括用户名、登录时间和终端。
2. hostname: 显示计算机的主机名。
3. uname: 显示当前系统的信息，如内核名称、版本号、系统架构等。
4. du: 显示目录或文件所占用的磁盘空间大小。常用选项包括 -h（人类可读格式）和 -s（总结信息）。
5. df: 显示文件系统的磁盘空间使用情况，包括磁盘大小、已用空间、剩余空间和文件系统类型。常用选项包括 -h（人类可读格式）和 -T（显示文件系统类型）。
6. free: 显示系统内存使用情况，包括物理内存和交换空间。常用选项包括 -h（人类可读格式）和 -m（以兆字节显示）。

## 配置
1. 设置允许远程登录
   1. /etc/ssh/sshd_config
   2. PermitRootLogin yes
2. 配置文件修改后立刻生效
   1. source filename

## 要扩展 Linux 上的逻辑卷
### 1. 检查空闲空间
使用 `lvdisplay` 命令检查逻辑卷的空闲空间。你可以输入以下命令查看可用空间：

```bash
sudo lvdisplay
```

### 2. 扩展逻辑卷
假设你要将 `/dev/VolGroup00/LogVol00` 扩展为更大的空间。首先，你需要扩展文件系统。如果你使用的是 ext 文件系统，可以使用 `resize2fs` 命令：

```bash
# 扩展逻辑卷（假设有空闲空间）
sudo lvextend -l +100%FREE /dev/VolGroup00/LogVol00

# 扩展文件系统
sudo resize2fs /dev/VolGroup00/LogVol00
```

### 3. 验证
最后，使用 `df -h` 命令验证文件系统是否已成功扩展。

```bash
df -h
```

这些步骤会扩展你的逻辑卷并在 CentOS 上使用新的空间。记得在进行这些操作之前备份重要数据，以防万一出现意外情况。

## 部署java应用
1. 直接使用dockerCompose
2. 其它
   1. 修改环境变量
      1. vim /etc/environment 修改系统环境变量
      2. vim /etc/profile 修改用户环境变量
   2. 修改mysql配置
      1. vim /etc/mysql/mysql.conf.d/mysqld.cnf
      2. bind-address = 127.0.0.1 注释掉

## 编写定时脚本
   ```
   0 9 * * * /path/to/myscript.sh
   ```

## 不同系统差异
1. 续行
   1. cmd `^`
   2. linux `\`
2. 过滤
   1. cmd `| find "str"`
   2. linux `| grep str`

## 其它
1. 当在下载的文件的时候，可以移动目录
2. 下载结束后成功移动

## 参考资料
1. openai：[chatgpt](https://chat.openai.com/)