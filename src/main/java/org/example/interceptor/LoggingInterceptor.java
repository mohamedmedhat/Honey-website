package org.example.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.example.annotation.Loggable;

import java.util.logging.Logger;

@Interceptor
@Loggable
public class LoggingInterceptor {
    Logger logger = Logger.getLogger(getClass().getName());
    @AroundInvoke
    public Object logMethod(InvocationContext ctx) throws Exception {
        logger.info(">> " + ctx.getMethod().getName());
        Object result = ctx.proceed();
        logger.info("<< " + ctx.getMethod().getName());
        return result;
    }
}
