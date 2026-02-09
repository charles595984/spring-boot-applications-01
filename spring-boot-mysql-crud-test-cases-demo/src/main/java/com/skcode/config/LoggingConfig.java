package com.skcode.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingConfig {

//	@Pointcut("execution(public * com.skcode..*.*(..))")
	@Pointcut("execution(public * com.skcode.controller..*.*(..))")
	public void printControllerLogs() {
	}
	
	@Around("printControllerLogs()")
	public Object logsAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		log.info("before invoking method: " + joinPoint.getSignature());
//		log.info("before invoking method: " + joinPoint.getSignature().getName());
	    Object result;
		try {
	    	result = joinPoint.proceed();
	    } finally {
	    	log.info("after invoking method: " + joinPoint.getSignature());
	    }
		long endTime = System.currentTimeMillis();
		log.info("{} Executed in {} ms", joinPoint.getSignature(), startTime - endTime);
	    return result;
	}
	
//    @AfterThrowing(value = "printControllerLogs()", throwing = "ex")
//    public void logAfterThrowing(ProceedingJoinPoint joinPoint, Exception ex) {
//        System.out.println("Exception in method: " + joinPoint.getSignature().getName());
//        System.out.println("Error: " + ex.getMessage());
//    }

}
