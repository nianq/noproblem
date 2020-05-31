package com.gongj.noproblem.tasks.service.impl;

import com.gongj.noproblem.tasks.entity.User;
import com.gongj.noproblem.tasks.mapper.UserMapper;
import com.gongj.noproblem.tasks.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gongj
 * @since 2020-05-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
