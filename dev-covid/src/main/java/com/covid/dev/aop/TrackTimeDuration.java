package com.covid.dev.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Configuration
@Slf4j
public class TrackTimeDuration {

    @Around("@annotation(com.covid.dev.annotation.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        Instant start = Instant.now();
        Object proceed = joinPoint.proceed();
        long duration = Duration.between(start, Instant.now()).toMillis();
        log.info("Time taken by {} is {} s", joinPoint.getSignature().getName(), duration/1000.0);
        return proceed;
    }
}
