package com.esgi.apimail.web.configs;

import com.esgi.apimail.domain.listprojects.ListProjectService;
import com.esgi.apimail.domain.listprojects.contracts.IListProjectRepository;
import com.esgi.apimail.domain.newproject.NewProjectService;
import com.esgi.apimail.domain.newproject.contracts.INewProjectRepository;
import com.esgi.apimail.domain.sendmail.MailService;
import com.esgi.apimail.domain.sendmail.contracts.IMailRepository;
import com.esgi.apimail.domain.sendmail.contracts.IMailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {
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
}
