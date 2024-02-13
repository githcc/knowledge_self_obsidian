1. 调整磁盘空间处理问题
```
mkfs.xfs /dev/mapper/centos-home -f
xfs_growfs /dev/mapper/centos-root
```