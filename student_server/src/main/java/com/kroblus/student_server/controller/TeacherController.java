package com.kroblus.student_server.controller;

import com.kroblus.student_server.entity.Teacher;
import com.kroblus.student_server.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: kroblus
 * @Date: 2022/2/9 11:02
 * @Description: TeacherController
 * @Version 1.0.0
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/addTeacher")
    public boolean addTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Teacher teacher) {
        System.out.println("正在验证教师登陆 " + teacher);
        Teacher t = teacherService.findByEmail(teacher.getEmail());
        System.out.println("数据库教师信息" + t);
        return t != null && t.getPassword().equals(teacher.getPassword());
    }

    @GetMapping("/findById/{tid}")
    public Teacher findById(@PathVariable("tid") Integer tid) {
        System.out.println("正在查询学生信息 By id " + tid);
        return teacherService.findById(tid);
    }

    @GetMapping("/findByEmail/{email}")
    public Teacher findByEmail(@PathVariable("email") String email) {
        System.out.println("正在查询学生信息 By email " + email);
        return teacherService.findByEmail(email);
    }

    @PostMapping("/findBySearch")
    public List<Teacher> findBySearch(@RequestBody Map<String, String> map) {
        return teacherService.findBySearch(map);
    }

    @GetMapping("/deleteById/{tid}")
    public boolean deleteById(@PathVariable("tid") int tid) {
        System.out.println("正在删除学生 tid：" + tid);
        return teacherService.deleteById(tid);
    }

    @PostMapping("/updateTeacher")
    public boolean updateTeacher(@RequestBody Teacher teacher) {
        System.out.println("更新 " + teacher);
        return teacherService.updateById(teacher);
    }
}
