package com.sancheck.bank.dao.impl;

import com.sancheck.bank.dao.AccountDao;
import com.sancheck.bank.pojo.Account;
import com.sancheck.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author: fengyuxiang
 * @ClassName: AccountDaoImpl
 * @version: 1.0
 * @description:
 * @create: 2/2/2023
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String arg0) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        Account account = (Account) sqlSession.selectOne("account.selectByActno",actno);
//        sqlSession.close();
        return (Account) sqlSession.selectOne("com.sancheck.bank.dao.AccountDao.selectByActno",arg0);
    }

    @Override
    public int updateByActno(Account arg0) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        int count = sqlSession.update("account.updateByActno",act);
//        sqlSession.commit();
//        sqlSession.close();
        return sqlSession.update("com.sancheck.bank.dao.AccountDao.updateByActno",arg0);
    }
}
