package com.sancheck.mybatis.mapper;

import com.sancheck.mybatis.pojo.Student;

import java.util.Date;
import java.util.List;

public interface StudentMapper {

    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBirth(Date birth);
    List<Student> selectBySex(Character sex);






}
