package com.liubo.demo.rabbitmq.producer.cron;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.liubo.demo.rabbitmq.person.model.PersonDO;
import com.liubo.demo.rabbitmq.person.service.PersonService;

/**
 * Created by hzlbo on 2016/7/11.
 */
@Configuration
@EnableScheduling
public class SpringTaskDemo {
    @Autowired
    private PersonService personService;
    
    @Scheduled(cron = "0 */1 * * * ?") // 每30分钟执行一次
    public void scheduler() throws Exception {
        System.out.println(">>>>>>>>> 定时任务<<<<<<<<<<"+new Date());
        PersonDO personDO = new PersonDO();
        Random r = new java.util.Random();
        
        for (int i = 0; i < 1000; i++) {
            personDO.setAge(r.nextInt());
            personDO.setUserId(System.currentTimeMillis()+"");
            personDO.setUserName("卢梭"+i);
                System.out.print(i+" ");
                personService.addPerson(personDO);
        }
    }
}
