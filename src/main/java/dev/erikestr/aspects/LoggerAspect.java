package dev.erikestr.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @Before("pointcutMoveVehicle(vehicleStarted)")
    public void logBeforeMoveVehicle(boolean vehicleStarted) {
        if (!vehicleStarted) {
            logger.info("Vehicle not started to perform the operation");
        }
    }

    @Around("execution(public void dev.erikestr.services.VehicleService.moveVehicle(boolean))")
    public void logAroundMoveVehicle(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("move started: {} ms", 0);
        Instant start = Instant.now();

        pjp.proceed();

        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        logger.info("move finished: {} ms", timeElapsed);
    }

    // -------------------------------- Brake --------------------------------

    @Before("execution(public String dev.erikestr.services.VehicleService.applyBrake(boolean)) && args(vehicleStarted)")
    public void logBeforeApplyBrake(boolean vehicleStarted) {
        if (vehicleStarted) {
            logger.info("Vehicle not started to perform the operation");
        }
    }

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
