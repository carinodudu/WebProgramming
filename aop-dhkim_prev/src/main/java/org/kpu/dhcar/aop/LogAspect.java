package org.kpu.dhcar.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Around(
			"execution(* org.kpu.dhcar.*Controller.*(..))"
			+ " or execution(* org.kpu.dhcar.service.*Impl.*(..))"
			+ " or execution(* org.kpu.dhcar.persistence.*Impl.*(..)) "
	)
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = pjp.proceed();
		
		String type = pjp.getSignature().getDeclaringTypeName();
		String packageName = "";
		
		if(type.contains("Controller")) {
			packageName = "Controller : ";
		}
		else if(type.contains("Service")) {
			packageName = "Service : ";
		}
		else if(type.contains("DAO")) {
			packageName = "Persistence : ";
		}
		
		long endTime = System.currentTimeMillis();
		
		logger.info(packageName + type + "." + pjp.getSignature().getName() + " 메소드 호출");
		logger.info("실행된 시간 : " + (endTime - startTime) + "ms");
		logger.info("-------------------------------------------------------------------");
		
		return result;
	}
}
