package com.kuls.springboot02config.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/30 8:49 下午
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    @Value("旺财")
    private String name;
    @Value("3")
    private Integer age;
}
