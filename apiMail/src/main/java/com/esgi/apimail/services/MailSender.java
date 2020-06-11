package com.esgi.apimail.services;

import com.esgi.apimail.domain.models.Message;
import com.esgi.apimail.domain.sendmail.contracts.IMailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collection;

@Service
public class MailSender implements IMailSender {
    @Value("${mail.address}")
    private String senderMailAddress;

    public final JavaMailSender emailSender;

    public MailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public boolean sendMail(Message message, Collection<String> emailAddresses) {
        MimeMessage mail = emailSender.createMimeMessage();
        if(emailAddresses != null && emailAddresses.size() > 0){
            try {
                MimeMessageHelper helper = new MimeMessageHelper(mail, false);
                helper.setFrom(senderMailAddress);
                String[] addrsArray = emailAddresses.toArray(new String[0]);
                helper.setTo(addrsArray);
                helper.setSubject(message.getSubject());
                helper.setText(message.getContent());
                this.emailSender.send(mail);
            } catch (MessagingException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
