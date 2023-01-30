package com.sancheck.mybatis.test;

import com.sancheck.mybatis.pojo.Car;
import com.sancheck.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: fengyuxiang
 * @ClassName: CarMapperTest
 * @version: 1.0
 * @description:
 * @create: 29/1/2023
 */
public class CarMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> carList =  sqlSession.selectList("jkljl.selectAll");
        carList.forEach(car -> System.out.println(car));
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car =  sqlSession.selectOne("jkljl.selectById",173L);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(173L,"9999","MCR",30.3,"1999-11-10","ryc");
        sqlSession.update("jkljl.updateById",car);
        sqlSession.commit();
        sqlSession.close();

    }



    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.delete("jkljl.deleteById",59); // number '59' only for test
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        Car car = new Car(null,"3333","BYDT",30.0,"2020-11-11","new energy");


        int count = sqlSession.insert("jkljl.insertCar",car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testInsertCar(){

        Map<String, Object> map = new HashMap<>();
        map.put("k1","1111");
        map.put("k2","BYD");
        map.put("k3",10.0);
        map.put("k4","2020-11-11");
        map.put("k5","electric car");

        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("jkljl.insertCar",map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
