package com.sancheck.mybatis.test;

import com.sancheck.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
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
    public void testInsertCar(){

        Map<String, Object> map = new HashMap<>();
        map.put("k1","1111");
        map.put("k2","BYD");
        map.put("k3",10.0);
        map.put("k4","2020-11-11");
        map.put("k5","electric car");

        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar",map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
