package com.sancheck.bank.service.impl;

import com.sancheck.bank.dao.AccountDao;
import com.sancheck.bank.dao.impl.AccountDaoImpl;
import com.sancheck.bank.pojo.Account;
import com.sancheck.bank.service.AccountService;

/**
 * @author: fengyuxiang
 * @ClassName: AccountServiceImpl
 * @version: 1.0
 * @description:
 * @create: 2/2/2023
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();
    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money){

        }
    }
}
