package com.gongj.noproblem.mail.controller;


import com.gongj.noproblem.commonsutils.ResultVo;
import com.gongj.noproblem.mail.entity.Mail;
import com.gongj.noproblem.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gongj
 * @since 2020-05-30
 */
@RestController
@RequestMapping("/mail/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping("/sendMail")
    public ResultVo sendMail(@RequestBody Mail mail){
       boolean result =  mailService.sendMail(mail);
       if (result){
           return ResultVo.ok();
       }
       return ResultVo.error();
    }
}

