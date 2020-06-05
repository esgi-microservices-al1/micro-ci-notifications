package com.esgi.apimail.web.configs;

import com.esgi.apimail.domain.listprojects.ListProjectService;
import com.esgi.apimail.domain.listprojects.contracts.IListProjectRepository;
import com.esgi.apimail.domain.newproject.NewProjectService;
import com.esgi.apimail.domain.newproject.contracts.INewProjectRepository;
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
}
