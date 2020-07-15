package com.kulsdemo.springdemo3;

import java.beans.ConstructorProperties;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/11 9:41 上午
 */
public class CarModel {

    private String name;
    //描述信息
    private String desc;

    public CarModel() {
    }
    //定义参数名称
    @ConstructorProperties({"name", "desc"})
    public CarModel(String p1, String p2) {
        this.name = p1;
        this.desc = p2;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
