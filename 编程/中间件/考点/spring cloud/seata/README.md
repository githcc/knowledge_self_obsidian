## 概念
1. 事务协调者TC transaction Coordinator
2. 事务管理器TM transaction Manager
3. 资源管理器RM Resource Manager

## seata模式
1. xa模式 两阶段提交 强一致
    1. 全局事务开启->分支事务注册并报告状态->全局事务结束->此时的分支事务处于悬挂状态
    2. TC根据报告状态决定提交还是回滚
    3. 特点：强一致，简单
    4. yml @GlobalTransaction
2. at模式（默认） 三阶段提交 最终一致
    1. 全局事务开启->执行sql并提交，记录快照，报告状态
    2. 检查报告，若通过删除快照
    3. 特殊情况，根据快照进行回滚
    4. 会多一张undo_log表，每一个服务都要有

## 其它
1. 命名空间-分组-集群，起到数据隔离
