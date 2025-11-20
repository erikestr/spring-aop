package dev.erikestr.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // ----------------------------------------------------------------------
    // ading more simplicity to the log messages
    // ----------------------------------------------------------------------

    @Around("execution(* dev.erikestr.services..*(..))")
    public Object logSimpleMessages(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("[{}] -- simplicity --", pjp.getSignature().getName());

        Object returnValue = pjp.proceed();

        logger.info("[{}] -- simplicity --", pjp.getSignature().getName());
        return returnValue;
    }

    // ------------------------------- Music --------------------------------

    @Around("execution(public String dev.erikestr.services.VehicleService.playMusic(boolean, dev.erikestr.model.Song))")
    public Object logPlayMusicAdvice(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("playMusic started: {} ms", 0);
        Instant start = Instant.now();

        Object returnValue = pjp.proceed();

        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        logger.info("playMusic finished: {} ms", timeElapsed);

        return returnValue;
    }

    // ------------------------------- Move --------------------------------

    @Pointcut("execution(public void dev.erikestr.services.VehicleService.moveVehicle(boolean)) && args(vehicleStarted)")
    public void pointcutMoveVehicle(boolean vehicleStarted) {
    };

    @Around("execution(public void dev.erikestr.services.VehicleService.moveVehicle(boolean))")
    public void logAroundMoveVehicle(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("move started: {} ms", 0);
        Instant start = Instant.now();

        pjp.proceed();

        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        logger.info("move finished: {} ms", timeElapsed);
    }

    // -------------------------------- Brake --------------------------------

    @Around("execution(public String dev.erikestr.services.VehicleService.applyBrake(boolean))")
    public Object logAftereApplyBrake(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("applyBrake started: {} ms", 0);
        Instant start = Instant.now();

        Object returnValue = pjp.proceed();

        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        logger.info("applyBrake finished: {} ms", timeElapsed);

        return returnValue;
    }
}
