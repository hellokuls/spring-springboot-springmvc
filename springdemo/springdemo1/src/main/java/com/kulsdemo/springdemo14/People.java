package com.kulsdemo.springdemo14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/24 1:39 下午
 */
public class People {

    @Autowired
    @Qualifier(value = "dog123")
    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }


    @Override
    public String toString() {
        return "People{" +
                "dog=" + dog +
                '}';
    }
}
