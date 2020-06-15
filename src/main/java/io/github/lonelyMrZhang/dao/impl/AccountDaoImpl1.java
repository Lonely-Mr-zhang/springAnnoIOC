package io.github.lonelyMrZhang.dao.impl;

import io.github.lonelyMrZhang.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @description: 账户的持久层实现类
 * @author: lonely.mr.zhang
 * @date: 2020/6/12 12:49 上午
 */
@Repository(value = "accountDao1")
public class AccountDaoImpl1 implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
