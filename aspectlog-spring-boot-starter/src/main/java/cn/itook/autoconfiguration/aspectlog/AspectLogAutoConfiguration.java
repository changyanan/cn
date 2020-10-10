package cn.itook.autoconfiguration.aspectlog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;

@Aspect
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@ConditionalOnProperty(prefix = "aspectlog", name = "enable", havingValue = "true", matchIfMissing = true)
public class AspectLogAutoConfiguration implements PriorityOrdered {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Around("@annotation(cn.itook.autoconfiguration.aspectlog.annotation.AspectLog) ")
    public Object isOpen(ProceedingJoinPoint joinPoint) throws Throwable {
        String taskName = joinPoint.getSignature()
                .toString().substring(
                        joinPoint.getSignature()
                                .toString().indexOf(" "),
                        joinPoint.getSignature().toString().indexOf("("));
        taskName = taskName.trim();
        long time = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        logger.info("method:{} run :{} ms", taskName, (System.currentTimeMillis() - time));
        return result;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
