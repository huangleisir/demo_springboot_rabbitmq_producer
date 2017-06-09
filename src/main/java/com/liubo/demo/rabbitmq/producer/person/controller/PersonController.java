package com.liubo.demo.rabbitmq.producer.person.controller;

import com.liubo.demo.rabbitmq.person.model.PersonDO;
import com.liubo.demo.rabbitmq.person.service.PersonService;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzlbo on 2016/7/4.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean addPerson() throws Exception {
        PersonDO personDO = new PersonDO();
        Random r = new java.util.Random();
        
        for (int i = 0; i < 1000; i++) {
            personDO.setAge(r.nextInt());
            personDO.setUserId(System.currentTimeMillis()+"");
            personDO.setUserName("卢梭"+i);
                System.out.println(i+" ");
                personService.addPerson(personDO);
        }


        return personService.addPerson(personDO);
    }

    @RequestMapping(value = "/test")
    public String StringMsg(String test) throws Exception {

        return "ok";
    }
}
