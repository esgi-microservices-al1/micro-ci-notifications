package com.esgi.apimail.domain.validators.project;

import com.esgi.apimail.domain.models.Project;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProjectValidator implements ConstraintValidator<ValidProject, Project> {
    @Override
    public boolean isValid(Project project, ConstraintValidatorContext constraintValidatorContext) {
        if(project == null) {
            return false;
        }
        return project.getId() != null;
    }
}
