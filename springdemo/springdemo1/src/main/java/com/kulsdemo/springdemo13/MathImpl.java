package com.kulsdemo.springdemo13;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/16 7:20 下午
 */
public class MathImpl implements MathI {
    @Override
    public int add(int i, int j) {
        System.out.println("我是add方法");
        return i+j;
    }
}
