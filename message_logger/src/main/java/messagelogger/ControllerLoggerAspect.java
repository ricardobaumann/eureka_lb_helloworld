package messagelogger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggerAspect {

    @Around("anyPublicOperation()")
    public Object monitorServiceInvocation(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("log and do whatever you need: "+joinPoint);
        return joinPoint.proceed();
    }

}
