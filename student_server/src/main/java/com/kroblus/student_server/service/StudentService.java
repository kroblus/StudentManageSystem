package com.kroblus.student_server.service;

import com.kroblus.student_server.entity.Student;
import com.kroblus.student_server.entity.Teacher;
import com.kroblus.student_server.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kroblus
 * @Date: 2022/2/9 08:27
 * @Description: StudentService
 * @Version 1.0.0
 */

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findByPage(Integer num, Integer size) {
        // num：第几页，size：一页多大
        // num：从零开始
        List<Student> studentList = studentMapper.findAll();
        ArrayList<Student> list = new ArrayList<>();

        int start = size * num;
        int end = size * (num + 1);
        int sz = studentList.size();

        for (int i = start; i < end && i < sz; i++) {
            list.add(studentList.get(i));
        }

        return list;
    }

    public List<Student> findBySearch(Integer sid, String sname, Integer fuzzy) {
        Student student = new Student();
        student.setSid(sid);
        student.setSname(sname);
        fuzzy = (fuzzy == null) ? 0 : fuzzy;

        System.out.println(fuzzy);

        return studentMapper.findBySearch(student, fuzzy);
    }

    public Integer getLength() {
        return studentMapper.findAll().size();
    }

    public Student findById(Integer sid) {
        return studentMapper.findById(sid);
    }

    public Student findByEmail(String email) {
        return studentMapper.findByEmail(email);
    }

    public boolean updateById(Student student) {
        return studentMapper.updateById(student);
    }

    public boolean save(Student student) {
        return studentMapper.save(student);
    }

    public boolean deleteById(Integer sid) {
        return studentMapper.deleteById(sid);
    }
}
