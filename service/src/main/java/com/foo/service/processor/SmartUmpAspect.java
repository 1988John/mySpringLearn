//package com.jd.huishou.aspect;
//
//import java.lang.reflect.Method;
//
//import com.jd.huishou.common.util.JsonUtil;
//import com.jd.huishou.vo.JsonResult;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.util.Assert;
//
//import com.jd.ump.profiler.CallerInfo;
//import com.jd.ump.profiler.proxy.Profiler;
//
///**
// * <p>
// * 不知道ump是什么？见 <a href=" ">ump帮助</a >
// *
// * <p>
// * <code>com.jd.ump.annotation.JAnnotation</code> 也太不智能了..  (--!!) 用法见 <a href="http://cf.jd.com/pages/viewpage.action?pageId=73256505">监控接入注解式（java）</a >
// *
// * <p>
// * 实现ump切面，只需在类上添加<code>@Ump</code>，即可实现类中的所有方法都接入ump监控。
// *
// * <p>
// * 如果只想让某方法接入ump监控，则无需在类上添加<code>@Ump</code>，只需在方法上添加<code>@Ump</code>即可。<br>
// * 如果不想让某方法接入ump监控，只需在类上添加<code>@Ump</code>，并在方法上添加<code>@UmpIgnore</code>即可。
// *
// * <p>
// * <code>@Ump</code>可以同时加在类和方法上，方法上的注解的优先级比类上的高。
// *
// * <p>
// * <code>@Ump</code>的属性使用默认即可，默认是打开心跳、TP、报错监控的。<br>
// * 监控方法的key，可以用<code>@Ump.key()</code>方法指定，但这不是必须的。如果不填，则自动使用方法全名替代。<br>
// *
// * <p>
// * 参考配置
// * <pre>
// * &lt;dependency&gt;
// *     &lt;groupId&gt;com.jd.ump&lt;/groupId&gt;
// *     &lt;artifactId&gt;profiler&lt;/artifactId&gt;
// *     &lt;version&gt;4.0.5&lt;/version&gt;
// * &lt;/dependency&gt;
//
// * &lt;aop:aspectj-autoproxy proxy-target-class="true" /&gt;
// *
// * &lt;bean class="com.jd.huishou.aspect.SmartUmpAspect"&gt;
// *     &lt;property name="appName" value="${app}" /&gt;
// * &lt;/bean&gt;
// * </pre>
// *
// * @see com.jd.huishou.aspect.Ump
// * @see com.jd.huishou.aspect.UmpIgnore
// *
// * @author wanghui59@jd.com
// * @since 0.0.1
// */
//@Aspect
//public class SmartUmpAspect implements InitializingBean,Ordered {
//    private static final Logger logger = LoggerFactory.getLogger(SmartUmpAspect.class);
//    // 优先级较低，后执行
//    private int order = LOWEST_PRECEDENCE - 1000;
//
//    private String app;
//    private String heartbeatKey;
//    private String jvmKey;
//
//    public void setApp(String app) {
//        this.app = app;
//    }
//    public void setHeartbeatKey(String heartbeatKey) {
//        this.heartbeatKey = heartbeatKey;
//    }
//    public void setJvmKey(String jvmKey) {
//        this.jvmKey = jvmKey;
//    }
//
//    public void setOrder(int order) {
//        this.order = order;
//    }
//
//    @Override
//    public int getOrder() {
//        return order;
//    }
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        Assert.notNull(app, "app cannot be null");
//
//        this.heartbeatKey = StringUtils.defaultIfEmpty(this.heartbeatKey, app + ".heartbeat");
//        this.jvmKey = StringUtils.defaultIfEmpty(this.jvmKey, app + ".jvm");
//
//        Profiler.InitHeartBeats(this.heartbeatKey);
//        Profiler.registerJVMInfo(this.jvmKey);
//
//        logger.info("UMP切面初始化成功. app - {}, heartbeatKey - {}, jvmKey - {}", app, heartbeatKey, jvmKey);
//    }
//
//    // 添加了@Ump注解的所有类及其子类的所有方法 或 添加了@Ump注解的方法
//    @Pointcut("@within(com.jd.huishou.aspect.Ump) || @annotation(com.jd.huishou.aspect.Ump)")
//    public void pointcut() {
//    }
//    @Around("pointcut()")
//    public Object around(ProceedingJoinPoint jp) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
//        Method method = methodSignature.getMethod();
//
//        UmpIgnore annoUmpIgnore = AnnotationUtils.findAnnotation(method, UmpIgnore.class);
//        // 方法上有@UmpIgnore, 则忽略ump监控
//        if (annoUmpIgnore != null) {
//            return jp.proceed();
//        }
//        // 优先找方法上的注解
//        Ump annoUmp = AnnotationUtils.findAnnotation(method, Ump.class);
//        if (annoUmp == null) {
//            // 找不到方法上的, 找类上的
//            annoUmp = AnnotationUtils.findAnnotation(method.getDeclaringClass(), Ump.class);
//        }
//        // 获取监控方法的key
//        String key = getKey(annoUmp, method);
//        //方法频繁调用时，打印日志会很多，先注释掉
////        logger.info("方法 {} 进入UMP切面", key);
//
//        CallerInfo callerInfo = null;
//        try {
//            // ump核心代码
//            callerInfo = Profiler.registerInfo(key, app, annoUmp.heartbeat(), annoUmp.tp());
//            return jp.proceed();
//        } catch (Throwable e) {
//            logger.error("方法 {} 异常，参数: {}, 上报UMP。\n{}", key, JsonUtil.toJson(jp.getArgs()), e);
//            if (callerInfo != null && annoUmp.functionError()) {
//                // ump核心代码
//                Profiler.functionError(callerInfo);
//            }
//            // 处理异常，默认抛出
//            return handleException(jp, e);
//        } finally {
//            if (callerInfo != null) {
//                // ump核心代码
//                Profiler.registerInfoEnd(callerInfo);
//            }
//        }
//    }
//    protected String getKey(Ump annoUmp, Method method) {
//        StringBuilder key = new StringBuilder();
//        key.append(method.getDeclaringClass().getSimpleName()).append(".").append(method.getName());
//        // 注解中未指定, 则使用方法全名
//        return StringUtils.defaultIfEmpty(annoUmp.key(), key.toString());
//    }
//
//    /**
//     * 处理异常，默认抛出
//     * @param jp
//     * @param e
//     * @return
//     * @throws Throwable
//     */
//    protected Object handleException(ProceedingJoinPoint jp,Throwable e) throws Throwable {
//        throw e;
//    }
//
//}