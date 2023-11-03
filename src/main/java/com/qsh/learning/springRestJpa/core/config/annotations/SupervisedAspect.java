package com.qsh.learning.springRestJpa.core.config.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SupervisedAspect {

    @Around("@annotation(supervised)")
    public Object superviser(ProceedingJoinPoint joinPoint, Supervised supervised) throws Throwable {
        System.out.printf("Call to %s (%s) \n", joinPoint.toShortString(), joinPoint.getArgs());
        Object proceed = joinPoint.proceed();
        System.out.printf("Response from method %s: %s \n", joinPoint.toShortString(), proceed.toString());

        return proceed;
    }
}
