package com.kroblus.student_server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @Auther: kroblus
 * @Date: 2022/2/8 16:11
 * @Description: Student
 * @Version 1.0.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Student")
public class Student {
    private Integer sid;
    private String email;
    private String sname;
    private String password;
}
