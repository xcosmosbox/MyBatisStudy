package com.sancheck.bank.service.impl;

import com.sancheck.bank.dao.AccountDao;
import com.sancheck.bank.dao.impl.AccountDaoImpl;
import com.sancheck.bank.exceptions.MoneyNotEnoughException;
import com.sancheck.bank.exceptions.TransferException;
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
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException{
        Account fromAct = accountDao.selectByActno(fromActno);

        if (fromAct.getBalance() < money){
            throw new MoneyNotEnoughException("Sorry! Balance not enough!");
        }

        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountDao.updateByActno(fromAct);
        count += accountDao.updateByActno(toAct);

        if (count != 2) {
            throw new TransferException("Error! Transfer failed!");
        }




    }
}
