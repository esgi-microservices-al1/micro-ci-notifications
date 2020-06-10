package com.esgi.apimail.domain.validators.message;

import javax.validation.Constraint;

@Constraint(validatedBy = MessageValidator.class)
public @interface ValidMessage {
}
