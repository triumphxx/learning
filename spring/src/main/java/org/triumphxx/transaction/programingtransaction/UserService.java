package org.triumphxx.transaction.programingtransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author:triumphxx
 * @Date:2021/10/31
 * @Time:10:54 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: Spring  编程式事务
 **/
@Component
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    TransactionTemplate transactionTemplate;

    // 用transactionManager 实现编程式事务
    public void transfer() {
        // 定义事务默认属性
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        // 获取TransactionStatus
        TransactionStatus transaction = transactionManager.getTransaction(definition);
        try {
            jdbcTemplate.update("update user set money = ? where username =? ", 6, "zhangsan");
            int i = 1 / 0;
            // 提交事务
            transactionManager.commit(transaction);
        } catch (DataAccessException e) {
            e.printStackTrace();
            // 回滚事务
            transactionManager.rollback(transaction);
        }
    }

    // transactionTemplate 实现编程式事务
    public void transfer2() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transaction) {
                try {
                    jdbcTemplate.update("update user set money = ? where username =? ", 6, "zhangsan");
                    //int i = 1/0;
                    // 提交事务
                    transactionManager.commit(transaction);
                } catch (DataAccessException e) {
                    e.printStackTrace();
                    // 回滚事务
                    transaction.setRollbackOnly();
                }
            }
        });
    }
}
