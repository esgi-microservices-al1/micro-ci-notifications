package com.esgi.apimail.domain.validators.message;

import com.esgi.apimail.domain.models.Message;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class MessageValidator implements ConstraintValidator<ValidMessage, Message> {
    @Override
    public boolean isValid(Message message, ConstraintValidatorContext constraintValidatorContext) {
        if (message == null) {
            return false;
        }
        if (message.getSubject() == null) {
            return false;
        }
        return message.getContent() != null && (message.getContent().length() != 0);
    }
}
