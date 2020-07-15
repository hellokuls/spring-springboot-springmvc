package com.kuls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/31 1:31 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;// 0:女
    private Department department;
    private Date birth;
}
