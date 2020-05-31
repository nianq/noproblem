package com.gongj.noproblem.tasks.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gongj.noproblem.tasks.entity.Cron;
import com.gongj.noproblem.tasks.mapper.CronMapper;
import com.gongj.noproblem.tasks.service.CronService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 定时任务 服务实现类
 * </p>
 *
 * @author gongj
 * @since 2020-05-30
 */
@Service
@Slf4j
@EnableScheduling   //开启定时任务
public class CronServiceImpl extends ServiceImpl<CronMapper, Cron> implements CronService {


}
