package com.foo.service.processor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.Ordered;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import com.foo.service.annotation.AdminLog;

/**
 * @author fooisart
 * @date 10:37 14-05-2019
 */
@Aspect
@Component
public class AdminLogAspect implements Ordered {

    private static final Logger logger = LoggerFactory.getLogger(AdminLogAspect.class);
    /**
     * 指定执行顺序
     */
    //CSOFF: MagicNumberCheck
    private int order = LOWEST_PRECEDENCE - 1000;

    public AdminLogAspect() {
        logger.info("初始化日志注解解析器...");
    }
    /**
     * 参数名解析器
     */
    private ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    @Pointcut("@annotation(com.foo.service.annotation.AdminLog)")
    public void logInsertPoint() {
    }

    @Around("logInsertPoint()")
    public Object process(ProceedingJoinPoint jp) throws Throwable {
        logger.info("进入日志切面");
        Method method = getMethod(jp);

        AdminLog log = AnnotationUtils.findAnnotation(method, AdminLog.class);

        //执行业务逻辑
        Object result = jp.proceed();

        saveLog(log, jp);

        return result;
    }
    /**
     *
     * @author fooisart
     * @date 18:40 2019/5/17
     */
    private void saveLog(AdminLog log, ProceedingJoinPoint jp) {
        try {
            // 构造SpringExpression变量
            Map<String, Object> variables = getVariables(jp.getArgs(), getMethod(jp));
            logger.info("日志记录信息,variables==>{}", variables);
            String bizKey = parseExpression(log.bizKey(), variables, String.class);
            String desc = parseExpression(log.desc(), variables, String.class);
            logger.info("日志记录信息,bizKey==>{}", bizKey);
            logger.info("日志记录信息,desc==>{}", desc);
            logger.info("日志记录信息==>{}", log);
        } catch (Exception e) {
            logger.error("日志组件报错拦截:", e);
        }
    }

    /**
     * 获取方法请求参数与值
     */
    private Map<String, Object> getVariables(Object[] args, Method method) {
        Map<String, Object> variables = new HashMap<>(args.length); // key是参数名, value是参数值
        if (args.length > 0) {
            String[] parameterNames = parameterNameDiscoverer.getParameterNames(method); // 获取参数名
            for (int i = 0; i < args.length; i++) {
                String paramName = parameterNames[i];
                Object arg = args[i];
                variables.put(paramName, arg);
            }
        }
        return variables;
    }
    /**
     * 计算SpringEL表达式的值
     */
    private static <T> T parseExpression(String expressionString, Map<String, Object> variables, Class<T> resultType) {

        if (StringUtils.isBlank(expressionString)){
            return null;
        }

        return doParseExpression(expressionString, variables, resultType);
    }
    /**
     * 计算SpringEL表达式的值
     */
    private static <T> T doParseExpression(String expressionString, Map<String, Object> variables, Class<T> resultType) {

        EvaluationContext context = new StandardEvaluationContext();
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            context.setVariable(entry.getKey(), entry.getValue());
        }
        ExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(expressionString).getValue(context, resultType);
    }
    /**
     * 根据属性值获取对象中对应的值
     *
     * @author jiangwang
     * 19:16 2018/1/11
     */
    private static Object getValueFromObject(Object obj, String filedName) {
        if (obj == null) {
            return null;
        }

        Field[] fields = obj.getClass().getDeclaredFields(); // 获取f对象对应类中的所有属性域
        for (Field field : fields) {
            if (filedName.equals(field.getName())) {
                try {
                    ReflectionUtils.makeAccessible(field);
                    return field.get(obj); //获取变量对应的值
                } catch (Exception ex) {
                    logger.error("根据属性值获取对象中对应的值-报错：", ex);
                }
            }
        }
        return null;
    }

    /**
     * 获取方法
     * @author jiangwang
     * @date 16:18 2018/8/10
     */
    private Method getMethod(ProceedingJoinPoint jp) {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        //如果是jdk proxy，上面的method是接口中的方法定义。需要下面这句话，获取真正的方法实现
        return ClassUtils.getMostSpecificMethod(method, jp.getTarget().getClass());
    }

    public int getOrder() {
        return order;
    }
}
