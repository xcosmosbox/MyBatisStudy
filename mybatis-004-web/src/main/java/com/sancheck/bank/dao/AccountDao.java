package com.sancheck.bank.dao;

import com.sancheck.bank.pojo.Account;

public interface AccountDao {
    Account selectByActno(String actno);

    int updateByActno(Account act);
}
