package com.qsh.learning.springRestJpa.car.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CatalogReferenceValidator.class)
public @interface ReferenceConstraint {
    String message() default "Reference should contain _ character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
