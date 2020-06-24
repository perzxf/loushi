package com.ls.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;



@Component
public class EmailUtil {
    @Autowired
    private JavaMailSender mailSender; // 自动注入的Bean

    @Value("${spring.mail.username}")
    private String sender; // 读取配置文件中的参数


    /**
     * 发送简易邮件
     */
    public void sendMail(String toName,String project,String content) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom(sender);
            helper.setTo(toName);
            helper.setSubject(project);
            helper.setText(content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(mimeMessage);
    }


}
