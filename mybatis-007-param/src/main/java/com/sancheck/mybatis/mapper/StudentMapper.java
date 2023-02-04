package com.sancheck.mybatis.mapper;

import com.sancheck.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentMapper {

    List<Student> selectByNameAndSex2(@Param("name") String name, @Param("sex") Character sex);

    List<Student> selectByNameAndSex(String name, Character sex);


    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBirth(Date birth);
    List<Student> selectBySex(Character sex);






}
