package com.ricemarch.accessannotation.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.*;

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

    private static final ExecutorService pool = new ThreadPoolExecutor(2,
            4,
            1000,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5),
            runnable -> new Thread(runnable, "threadPoll" + runnable.hashCode()),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    @Around(value = "pointCut(riceLog)", argNames = "pjp,riceLog")
    public Object around(ProceedingJoinPoint pjp, RiceLog riceLog) throws Throwable {

        String value = riceLog.value();

        pool.execute(() -> {
            MethodSignature signature = (MethodSignature) pjp.getSignature();
            Method method = signature.getMethod();

            //请求的方法名
            String className = pjp.getTarget().getClass().getName();
            String methodName = signature.getName();

            log.info("rice-log:{},className:{},methodName:{}", value, className, methodName);
        });


        return pjp.proceed();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
