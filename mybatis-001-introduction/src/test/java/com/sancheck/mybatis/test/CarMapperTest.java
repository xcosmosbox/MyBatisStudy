package com.sancheck.mybatis.test;

import com.sancheck.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author: fengyuxiang
 * @ClassName: CarMapperTest
 * @version: 1.0
 * @description:
 * @create: 29/1/2023
 */
public class CarMapperTest {

    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertCar(){
        SqlSession sqlSession = null;
        try{
            //Getting SqlSessionFactoryBuilder object
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder =  new SqlSessionFactoryBuilder();


            //Getting SqlSessionFactory object
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);


            //Getting SqlSession object
            sqlSession = sqlSessionFactory.openSession();

            // launch the sql statement
            int count = sqlSession.insert("insertCar"); // the return value by insert() function means that
            // how many data will be effected
            System.out.println("inserted data: " + count);

            // manual commit
            sqlSession.commit();

        } catch (Exception e){
            if (sqlSession != null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
