package com.softra.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut(value = "execution (* *.save*(..))")
	public void dummy() {
	}
	
	@Around(value = "dummy()")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		Object returnValue = null;
		
		try {
			String methodName = pjp.getSignature().getName();
			System.out.println("Inside pjp: " + methodName);
			returnValue = pjp.proceed();
			System.out.println("Exiting pjp: " + methodName);
		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
		return returnValue;
	}
	
//	@Before(value = "dummy()")
//	public void logBefore(JoinPoint jp) {
//		String methodName= jp.getSignature().getName();
//		//System.out.println("Inside " + methodName);
//	}
//	
//	@AfterReturning(value = "dummy()", returning = "r")
//	public void logAfter(JoinPoint jp, Object r) {
//		String methodName= jp.getSignature().getName();
//		//System.out.println("Exiting " + methodName);
//	}
}
