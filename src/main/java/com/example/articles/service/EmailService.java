package com.example.articles.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
@NoArgsConstructor
public class EmailService {

    @Setter
    @Autowired
    private JavaMailSender mailSender;
    public void sendMail(String msg, String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kicikicikici6969@gmail.com");
        message.setTo(to);
        message.setSubject("Article");
        message.setText(msg);
        mailSender.send(message);
    }
}
