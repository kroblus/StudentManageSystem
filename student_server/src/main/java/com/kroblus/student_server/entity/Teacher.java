package com.kroblus.student_server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @Auther: kroblus
 * @Date: 2022/2/9 10:50
 * @Description: Teacher
 * @Version 1.0.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Teacher")
public class Teacher {
    private Integer tid;
    private String email;
    private String tname;
    private String password;
}
