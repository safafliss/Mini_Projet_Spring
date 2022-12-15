package tn.esprit.springproject2.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@Aspect
public class LoggingAspect {
    @After("execution(* tn.esprit.springproject2.services.*.add*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info(name+" effectué avec succès");
    }
    @Around("execution(* tn.esprit.springproject2.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + "milliseconds.");
        return obj;
    }
    @Before("execution(* tn.esprit.springproject2.services.*.update*(..))")
    public void logupdate(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("update method " + name + " : ");
    }
}
