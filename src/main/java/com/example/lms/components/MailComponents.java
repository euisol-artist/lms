package com.example.lms.components;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MailComponents {
    private final JavaMailSender javaMailSender;

    public void sendMailTest(){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("owrx887@gmail.com");
        msg.setSubject("안녕하세요.");
        msg.setText("안녕하세요. 반갑습니다.");

        javaMailSender.send(msg);
    }
}
