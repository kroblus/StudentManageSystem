package com.kroblus.student_server.mapper;

import com.kroblus.student_server.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: kroblus
 * @Date: 2022/2/9 10:51
 * @Description: TeacherMapper
 * @Version 1.0.0
 */

@Repository
@Mapper
public interface TeacherMapper {
    //    select
    public List<Teacher> findAll();

    public Teacher findById(@Param("tid") Integer tid);

    public Teacher findByEmail(@Param("email") String email);

    public List<Teacher> findBySearch(@Param("tid") Integer tid, @Param("tname") String tname, @Param("fuzzy") Integer fuzzy);

    //    update
    public boolean updateById(@Param("teacher") Teacher teacher);

    //    insert
    public boolean save(@Param("teacher") Teacher teacher);

    //    delete
    public boolean deleteById(@Param("tid") Integer tid);

}
