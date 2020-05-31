package com.gongj.noproblem.tasks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //开启定时任务
@MapperScan(basePackages = {" com.gongj.noproblem.tasks.mapper"})
@EnableAsync        // 2.开启多线程
@ComponentScan(basePackages = {"com.gongj.noproblem.tasks","com.gongj.noproblem.mail"})
public class TasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);
    }

}
