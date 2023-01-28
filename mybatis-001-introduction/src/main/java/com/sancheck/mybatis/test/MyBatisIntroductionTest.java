package com.sancheck.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author: fengyuxiang
 * @ClassName: MyBatisIntroductionTest
 * @version: 1.0
 * @description:
 * @create: 28/1/2023
 */
public class MyBatisIntroductionTest{
    public static void main(String[] args) throws Exception{
        //Getting SqlSessionFactoryBuilder object
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =  new SqlSessionFactoryBuilder();


        //Getting SqlSessionFactory object
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);


        //Getting SqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // launch the sql statement
        int count = sqlSession.insert("insertCar"); // the return value by insert() function means that
                                                        // how many data will be effected
        System.out.println("inserted data: " + count);

        // manual commit
        sqlSession.commit();

        // close resources
        sqlSession.close();



    }


}
