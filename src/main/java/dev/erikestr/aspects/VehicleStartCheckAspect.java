package dev.erikestr.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class VehicleStartCheckAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(public String dev.erikestr.services.VehicleService.*(..)) && args(vehicleStarted,..) || args(..,vehicleStarted) || args(vehicleStarted)")
    public void logBeforeApplyBrake(JoinPoint jp, boolean vehicleStarted) throws Throwable {
        if (!vehicleStarted) {
            logger.error("Vehicle not started to perform the operation in method: {}", jp.getSignature().getName());
        }
    }
}
