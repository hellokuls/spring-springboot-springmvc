package com.kuls.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/11 3:09 下午
 */
@Service
public class ScheduledService {

    //秒 分  时  日  月  周几      ---cron表达式
    @Scheduled(cron = "10 17 15 * * ?")//定时
    public void Hello(){

        System.out.println("定时任务");
    }
}
