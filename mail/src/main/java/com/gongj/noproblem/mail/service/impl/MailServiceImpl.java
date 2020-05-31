package com.gongj.noproblem.mail.service.impl;

import com.gongj.noproblem.commonsutils.ApiException;
import com.gongj.noproblem.commonsutils.utils.MailUtil;
import com.gongj.noproblem.mail.entity.Mail;
import com.gongj.noproblem.mail.mapper.MailMapper;
import com.gongj.noproblem.mail.service.MailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gongj
 * @since 2020-05-30
 */
@Service
@Slf4j
public class MailServiceImpl extends ServiceImpl<MailMapper, Mail> implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public boolean sendMail(Mail mail) {
        checkMail(mail);
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //发送人
            helper.setFrom(mail.getSendFrom());
            //收信人
            helper.setTo(mail.getSendTo().split(","));
            //抄送人
            if(StringUtils.isNotBlank(mail.getSendCc())) {
                helper.setCc(mail.getSendCc().split(","));
            }
            //密送人
            if(StringUtils.isNotBlank(mail.getSendBcc())) {
                helper.setBcc(mail.getSendBcc().split(","));
            }
            //标题
            helper.setSubject(mail.getSendSubject());
            //true代表支持html
            helper.setText(mail.getSendContent(), true);
            //发送时间
            helper.setSentDate(new Date());
            javaMailSender.send(message);
            log.info("发送HTML邮件成功");
            mail.setCreateTime(new Date());
            mail.setIshtml("1");
            mail.setSendState("1");
            baseMapper.insert(mail);
            return true;
        } catch (MessagingException e) {
            mail.setCreateTime(new Date());
            mail.setIshtml("1");
            mail.setSendState("0");
            baseMapper.insert(mail);
            throw new ApiException(1001,"邮箱发送失败");
        }
    }


    private void checkMail(Mail mailInfo) {
        String sendTo = mailInfo.getSendTo();
        String bcc = mailInfo.getSendBcc();
        String cc = mailInfo.getSendCc();
        //收信人 必须有
        String[] sendToSplit = sendTo.split(",");
        for (String str : sendToSplit) {
            if(!MailUtil.checkMail(str)) {
                throw new ApiException(1002,"收信人邮箱格式错误");
            }
        }
        //密送人
        if(StringUtils.isNotBlank(bcc)) {
            String[] split = bcc.split(",");
            for (String str : split) {
                if(!MailUtil.checkMail(str)) {
                    throw new ApiException(1002,"密送人邮箱格式错误");
                }
            }
        }
        //抄送人
        if(StringUtils.isNotBlank(cc)) {
            String[] split = cc.split(",");
            for (String str : split) {
                if(!MailUtil.checkMail(str)) {
                    throw new ApiException(1002,"抄送人邮箱格式错误");
                }
            }
        }
    }

}
