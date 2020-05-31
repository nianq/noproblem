package com.gongj.noproblem.tasks.config;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gongj.noproblem.mail.entity.Mail;
import com.gongj.noproblem.mail.service.MailService;
import com.gongj.noproblem.tasks.entity.Cron;
import com.gongj.noproblem.tasks.entity.Expenditure;
import com.gongj.noproblem.tasks.entity.User;
import com.gongj.noproblem.tasks.mapper.CronMapper;
import com.gongj.noproblem.tasks.mapper.ExpenditureMapper;
import com.gongj.noproblem.tasks.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @program: noproblem
 * @description: 定时查询当天支出记录是否填写
 * @author: gongj
 * @Description: TODO
 * @create: 2020-05-30 21:41
 **/
@Slf4j
@Configuration
public class DynamicScheduleTaskConfig implements SchedulingConfigurer {

    @Autowired
    CronMapper cronMapper;

    @Autowired
    ExpenditureMapper expenditureMapper;

    @Autowired
    MailService mailService;

    @Autowired
    UserMapper userMapper;

    //@Value("${spring.mail.username}")
   // private String from;   //发送人

    /**
     * @param taskRegistrar
     * @Description 定时查询当天支出记录是否填写
     * 1、没有填写，发送邮件
     * @Author gongj
     * @Date 2020/5/30 21:25
     **/
    @Override
    //@Async
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        log.info("执行支出记录邮件定时任务");
        Date date = new Date();
        int year = DateUtil.year(date);
        int month = DateUtil.month(date) + 1;
        int day = DateUtil.dayOfMonth(date);

        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    List<User> users = userMapper.selectList(null);
                    for (User user : users) {
                        log.info("执行支出记录邮件定时任务: 【{}】", LocalDateTime.now().toLocalTime());
                        QueryWrapper<Expenditure> objectQueryWrapper = new QueryWrapper<>();
                        objectQueryWrapper.eq("eyear", year);
                        objectQueryWrapper.eq("emonth", month);
                        objectQueryWrapper.eq("eday", day);
                        objectQueryWrapper.eq("user_name", user.getUsername());
                        List<Expenditure> expenditures = expenditureMapper.selectList(objectQueryWrapper);
                        if (expenditures == null || expenditures.isEmpty()) {
                            //给当天没有填写支出的用户发送邮件
                            Mail mailDTO = new Mail();
                            mailDTO.setSendFrom("gongj@kiloseed.com");
                            mailDTO.setSendTo(user.getMailbox());
                            mailDTO.setIshtml("1");
                            mailDTO.setSendContent("测试" + new Date());
                            mailDTO.setSendSubject(year + "年" + month + "月" + day + "日支出报告未填写，请及时填写");
                            mailService.sendMail(mailDTO);
                        }
                    }

                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1从数据库获取执行周期
                    QueryWrapper<Cron> queryWrapper = new QueryWrapper<>();
                    queryWrapper.select("cron");
                    queryWrapper.eq("type", "1");
                    Cron crons = cronMapper.selectOne(queryWrapper);
                    String cron = crons.getCron();
                    //2.2 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
