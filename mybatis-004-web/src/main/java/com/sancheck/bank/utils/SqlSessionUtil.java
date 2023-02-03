package com.sancheck.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis util class
 * @author: fengyuxiang
 * @ClassName: sqlSessionUtil
 * @version: 1.0
 * @description:
 * @create: 29/1/2023
 */
public class SqlSessionUtil {

    private SqlSessionUtil(){

    }

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {

            //Getting SqlSessionFactoryBuilder object
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder =  new SqlSessionFactoryBuilder();
            //Getting SqlSessionFactory object
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    // one server one ThreadLocal
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        //Getting SqlSession object
        return sqlSession;
    }

    /**
     * Close the SqlSession object from current thread
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if (sqlSession == null) {
            sqlSession.close();
            local.remove();
        }
    }

}
