## 主流程
1. 入库
    1. 委托方
    2. 商品
2. 出库
    1. 收货方
    2. 送货方式
3. 送达
    1. 生成《客戶對賬單.xlsx》

## 拆单
1. 将库存商品单独生成一个新订单
2. 新订单的产生要扣除库存数量
3. 新订单的销毁恢复库存数量

## 客户信息管理
1. 内容
    1. 委托方
    2. 供应商
    3. 收货方
2. 作用
    1. 能够在订单页面可以自动带出数据

## 区域管理
1. 维护派送区域的费用
2. 作用
    1. 订单可以根据地点自动计算费用

## 费用
1. 维护杂类的费用
2. 作用
    1. 订单可以根据类别数量自动计算费用

## 导出订单内容
1. 导出库存信息
2. 导出标签信息

## 其它用户管理
1. 管理用户的权限
    1. 是否可以登录
    2. 是否可以删除数据
2. 管理用户查看范围

## 日志管理
1. 记录操作人员的行为
