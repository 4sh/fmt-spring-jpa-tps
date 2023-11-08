package com.qsh.learning.springRestJpa.car.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CatalogReferenceValidator implements ConstraintValidator<ReferenceConstraint, String> {
    @Override
    public void initialize(ReferenceConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (null != s) {
            return s.contains("_");
        }
        return true;
    }
}
