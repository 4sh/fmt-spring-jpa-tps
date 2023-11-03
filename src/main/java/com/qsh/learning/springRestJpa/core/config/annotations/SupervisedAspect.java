package com.qsh.learning.springRestJpa.core.config.annotations;

import org.aspectj.lang.ProceedingJoinPoint;

public class SupervisedAspect {

    public Object superviser(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.printf("Call to %s (%s) \n", joinPoint.toShortString(), joinPoint.getArgs());
        Object proceed = joinPoint.proceed();
        System.out.printf("Response from method %s: %s \n", joinPoint.toShortString(), proceed.toString());

        return proceed;
    }
}
