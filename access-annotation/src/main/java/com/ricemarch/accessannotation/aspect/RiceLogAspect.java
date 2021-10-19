package com.ricemarch.accessannotation.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author tanwentao
 * @since 2021/10/19
 */

@Aspect
@Component
@Slf4j
public class RiceLogAspect implements Ordered {

    @Pointcut("@annotation(riceLog)")
    public void pointCut(RiceLog riceLog) {
    }

    @Around("pointCut(riceLog)")
    public Object around(ProceedingJoinPoint pjp, RiceLog riceLog) throws Throwable {

        String value = riceLog.value();
        log.info("rice-log:{}", value);

        Thread t = Thread.currentThread();
        System.out.println(t.getName());

        return pjp.proceed();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
