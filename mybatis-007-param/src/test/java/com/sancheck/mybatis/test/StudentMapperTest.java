package com.sancheck.mybatis.test;

import com.sancheck.mybatis.mapper.StudentMapper;
import com.sancheck.mybatis.pojo.Student;
import com.sancheck.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void testSelectByNameAndSex2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex2("张三",'男');
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByNameAndSex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张三",'男');
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectBySex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Character sex = Character.valueOf('男');
        List<Student> students = mapper.selectBySex(sex);
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByBirth() throws Exception{
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = simpleDateFormat.parse("1980-10-11");
        List<Student> students = mapper.selectByBirth(birth);
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByName(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("李四");
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }







}
