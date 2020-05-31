package com.gongj.noproblem.mail.service;

import com.gongj.noproblem.mail.entity.Mail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gongj
 * @since 2020-05-30
 */
public interface MailService extends IService<Mail> {

    boolean sendMail(Mail mail);
}
