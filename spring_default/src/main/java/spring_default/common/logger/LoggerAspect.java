package spring_default.common.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spring_default.common.exception.AnnotationExceptionHandler;

public class LoggerAspect {
	protected static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object thisObj = joinPoint.getTarget();
		String className = thisObj.getClass().getName();
		
		long currentTime = System.currentTimeMillis();
		
		if(logger.isDebugEnabled()) {
			logger.debug("===================================================");
			logger.debug("================== LOGGING START ==================");
			logger.debug("[class] : " + className);
			logger.debug("[method] : " + joinPoint.getSignature().getName() + "()");
		}
		
		Object returnObj = joinPoint.proceed();
		
		if(logger.isDebugEnabled()) {
			logger.debug("[class] : " + className);
			logger.debug("[method] : " + joinPoint.getSignature().getName() + "()");
			logger.debug("[소요시간] : {}ms", new Object[]{(System.currentTimeMillis()-currentTime)});
			logger.debug("=================== LOGGING END ===================");
			logger.debug("===================================================");
		}
		
		return returnObj;
	}
}
