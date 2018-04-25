package com.foo.web.controller;

import com.foo.service.transaction.propagation.PropagationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/19.
 */
@RestController
public class TestPropagationController {
    @Resource
    private PropagationService propagationService;
    /**
     * 不可重复读 幻读
     * @author jiangwang
     * 17:23 2018/4/18
     */
    @RequestMapping(value = "/required", method={RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"})
    public void readCommitted(String motherMethodName, String childMethodName) throws Exception {
        Method motherMethod = getMethod(motherMethodName);
        Method childMethod = getMethod(childMethodName);
        doInvoke(motherMethod,propagationService,childMethod,propagationService);
    }

    private void doInvoke(Method method, Object object, Object... args){
        try {
            method.invoke(object,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Method getMethod (String methodName)throws Exception {
        Class<?> clazz = Class.forName("com.jd.lease.gw.service.test.transaction.propagation.PropagationService");
        return clazz.getMethod(methodName);
    }
}
