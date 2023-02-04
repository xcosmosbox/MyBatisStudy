package com.sancheck.mybatis.test;

import com.sancheck.mybatis.mapper.StudentMapper;
import com.sancheck.mybatis.pojo.Student;
import com.sancheck.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author: fengyuxiang
 * @ClassName: StudentMapperTest
 * @version: 1.0
 * @description:
 * @create: 4/2/2023
 */
public class StudentMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }







}
