package com.sancheck.bank.service;

import com.sancheck.bank.exceptions.MoneyNotEnoughException;
import com.sancheck.bank.exceptions.TransferException;

public interface AccountService {
    void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException;
}
