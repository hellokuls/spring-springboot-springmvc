package com.kuls.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/11 2:40 下午
 */
@Service
public class AsyncService {


    @Async //异步
    public void Hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("延迟3秒");
    }
}
