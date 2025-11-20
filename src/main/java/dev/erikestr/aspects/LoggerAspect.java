package dev.erikestr.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Logs simple messages before and after the execution of methods annotated
     * with @LogAspect.
     * 
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(dev.erikestr.interfaces.annotations.LogAspect)")
    public Object logSimpleMessages(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("start {} at {} ms", pjp.getSignature().getName(), 0);
        Instant start = Instant.now();

        Object result = pjp.proceed();

        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        logger.info("cease {} at {} ms", pjp.getSignature().getName(), timeElapsed);
        return result;
    }

    @AfterThrowing(pointcut = "execution(public String dev.erikestr.services.VehicleService.*(..))", throwing = "ex")
    public void logAfterThrowingApplyBrake(Exception ex) {
        logger.error("Exception thrown in VehicleService: {}", ex.getMessage());
    }

    @AfterReturning(pointcut = "execution(public String dev.erikestr.services.VehicleService.*(..))", returning = "result")
    public void logAfterReturningApplyBrake(String result) {
        logger.info("\u001B[31mMethod returned value: {}\u001B[0m", result);
    }
}
