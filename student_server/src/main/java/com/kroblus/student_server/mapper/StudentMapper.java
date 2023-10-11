package com.kroblus.student_server.mapper;

import com.kroblus.student_server.entity.Student;
import com.kroblus.student_server.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: kroblus
 * @Date: 2022/2/8 16:12
 * @Description: StudentMapper
 * @Version 1.0.0
 */

@Mapper
@Repository
public interface StudentMapper {

//    select
    public List<Student> findAll();

    public Student findById(@Param("sid") Integer sid);

    public Student findByEmail(@Param("email") String email);

    public List<Student> findBySearch(@Param("student") Student student, @Param("fuzzy") Integer fuzzy);

//    update
    public boolean updateById(@Param("student") Student student);

//    insert
    public boolean save(@Param("student") Student student);

//    delete
    public boolean deleteById(@Param("sid") Integer sid);

}
