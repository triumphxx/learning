CREATE TABLE `t_tx_exception`
(
    `id`                bigint(20) NOT NULL AUTO_INCREMENT,
    `group_id`          varchar(32) DEFAULT NULL,
    `unit_id`           varchar(32) DEFAULT NULL,
    `mod_id`            varchar(32) DEFAULT NULL,
    `transaction_state` tinyint(4)  DEFAULT NULL,
    `registrar`         tinyint(4)  DEFAULT NULL COMMENT '-1 未知 0 Manager 通知事务失败， 1 client询问事务状态失败2 事务发起方关闭事务组失败',
    `ex_state`          tinyint(4)  DEFAULT NULL COMMENT '0 待处理 1已处理',
    `create_time`       datetime    DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC