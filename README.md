# 项目介绍

本项目是本人在学习的过程中的积累的一些学习产物。

## 分类

不同的知识点单独为一个模块。

### `debug-learning`

> 新版idea的dubeg技巧。

### `calculate-modifier`

> 这个模块主要是java基础的一些东西，包括java的基础计算，以及java其他关键词的用法，
> 详见包名：cal-计算，fin-final关键字，keyword-java关键字的用法

### `concurrent-lock`

> 本模块主要研究 java 的并发和锁,锁机制示意图如下。
![](http://cdn.triumphxx.com.cn/img/lock-mechanism.png)

#### 锁状态表示

![](http://cdn.triumphxx.com.cn/img/lock-states.png)

#### Java并发根据事先线程安全

1、保证线程同时执行使用：`CountDownLatch`

2、保证线程依次执行使用：`CyclicBarrier`，或者自己定一个线程可见性的变量控制

3、保证线程有序交错执行使用：`Semaphore`

### `datastruc-algor`

> 数据结构与算法

### `design-pattern`

> 设计模式

### `io-verify`

> java IO相关

### `JUC`

> java JUC(java.util.concurrent) 包下相关的内容

### `jvm`

> java jvm 相关

### `net-model`

> java 网络模型

### `spring`

> spring相关

### `springboot`

> springboot 相关

### `ThreadPool`

> 线程池相关

### `volatile-verify`

> java volatile 关键字相关

### `dis-transaction`

> 分布式事务相关内容

#### `lcn-parent`lcn相关

> 该部分实践的是lcn的相关代码，lcn（lock【锁定事务】Confirm【确认事务】Notify【通知事务】 ）
> 该部分分为三个项目:注册中心`eureka-server`、模拟订单服务`lcn-order`、模拟支付服务`lcn-pay`,
> 订单服务调用支付服务操作整体操作，使用分布式事务
>
> 官网：https://www.codingapi.com/

- 项目架构

![](http://cdn.triumphxx.com.cn/%20dis-transaction/server-post.png)

- 原理图

![](http://cdn.triumphxx.com.cn/dis-transaction/lcn-imnage.png)

- 核心步骤：

> - 创建事务组： 是指在事务发起方开始执行业务代码之前先调用TxManager创建事务组对象，然后拿到事务标示GroupId的过程。
> - 加入事务组:
    添加事务组是指参与方在执行完业务方法以后，将该模块的事务信息通知给TxManager的操作。
> - 通知事务组:
    是指在发起方执行完业务代码以后，将发起方执行结果状态通知给TxManager,TxManager将根据事务最终状态和事务组的信息来通知相应的参与模块提交或回滚事务， 并返回结果给事务发起方。

##### lcn事务模式原理及原理图

> LCN模式是通过代理Connection的方式实现对本地事务的操作，然后在由TxManager统一协调控制事务。当本地事务提交回滚或者关闭连接时将会执行假操作，
> 该代理的连接将由LCN连接池管理。

- 模式的特点

> 1、该模式对代码的嵌入性为低。
>
> 2、该模式仅限于本地存在连接对象且可通过连接对象控制事务的模块。
>
> 3、该模式下的事务提交与回滚是由本地事务方控制，对于数据一致性上有较高的保障。
>
> 4、该模式缺陷在于代理的连接需要随事务发起方一共释放连接，增加了连接占用的时间。

##### TCC事务模式原理

> TCC事务机制相对于传统事务机制（X/Open XA Two-Phase-Commit），其特征在于它不依赖资源管理器(RM)对XA的支持，而是通过对（由业务系统提供的）
> 业务逻辑的调度来实现分布式事务。主要由三步操作，Try: 尝试执行业务、 Confirm:确认执行业务、 Cancel: 取消执行业务。

- 模式的特点

> 1、该模式对代码的嵌入性高，要求每个业务需要写三种步骤的操作。
>
> 2、该模式对有无本地事务控制都可以支持使用面广。
>
> 3、数据一致性控制几乎完全由开发者控制，对业务开发难度要求高。