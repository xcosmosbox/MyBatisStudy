package com.sancheck.bank.exceptions;

/**
 * @author: fengyuxiang
 * @ClassName: MoneyNotEnoughException
 * @version: 1.0
 * @description:
 * @create: 2/2/2023
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){}
    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}
