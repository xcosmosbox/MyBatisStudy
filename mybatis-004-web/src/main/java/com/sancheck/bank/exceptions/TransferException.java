package com.sancheck.bank.exceptions;

/**
 * @author: fengyuxiang
 * @ClassName: TransferException
 * @version: 1.0
 * @description:
 * @create: 2/2/2023
 */
public class TransferException extends Exception{
    public TransferException(){}
    public TransferException(String msg){
        super(msg);
    }
}
