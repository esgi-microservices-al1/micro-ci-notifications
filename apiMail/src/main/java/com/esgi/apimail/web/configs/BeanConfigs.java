package com.esgi.apimail.web.configs;

import com.esgi.apimail.domain.listprojects.ListProjectService;
import com.esgi.apimail.domain.listprojects.contracts.IListProjectRepository;
import com.esgi.apimail.domain.listusers.ListUsersService;
import com.esgi.apimail.domain.listusers.contracts.IListUsersRepository;
import com.esgi.apimail.domain.newproject.NewProjectService;
import com.esgi.apimail.domain.newproject.contracts.INewProjectRepository;
import com.esgi.apimail.domain.sendmail.MailService;
import com.esgi.apimail.domain.sendmail.contracts.IMailRepository;
import com.esgi.apimail.domain.sendmail.contracts.IMailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class BeanConfigs {
    @Value("${mail.address}")
    private String senderMailAddress;

    @Value("${mail.password}")
    private String mailPassword;


    @Bean
    public NewProjectService newProjectService(INewProjectRepository repository){
        return new NewProjectService(repository);
    }

    @Bean
    public ListProjectService listProjectService(IListProjectRepository listProjectRepository){
        return new ListProjectService(listProjectRepository);
    }

    @Bean
    public MailService mailService(IMailRepository mailRepository, IMailSender mailSender){
        return new MailService(mailRepository, mailSender);
    }

    @Bean
    public ListUsersService listUsersService(IListUsersRepository repository){
        return new ListUsersService(repository);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        //hotmail
        //mailSender.setHost("smtp.live.com");
        //mailSender.setPort(25);

        //gmail
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(senderMailAddress);
        mailSender.setPassword(mailPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
