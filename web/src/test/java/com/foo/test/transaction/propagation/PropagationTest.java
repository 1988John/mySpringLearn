package com.foo.test.transaction.propagation;

import com.foo.service.transaction.propagation.PropagationService;
import com.foo.service.user.UserService;
import com.foo.test.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Description: 事物 隔离级别测试
 * Created by jiangwang3 on 2018/4/18.
 */
public class PropagationTest extends BaseTest{
    @Resource
    private PropagationService propagationService;

    @Resource
    private UserService userService;

    private String NOTRANSACTION = "noTransaction";

    private String REQUIRED = "required";

    private String NEVER = "never";

    private String MANDATORY = "mandatory";

    @Test
    @SuppressWarnings("all")
    public void propagationTest(){
        int outerPropagation = TransactionDefinition.PROPAGATION_REQUIRED;
        int innerPropagation = TransactionDefinition.PROPAGATION_REQUIRED;

        String outerName = "outer10";
        String innerName = "inner10";

        Boolean outerException = Boolean.FALSE;
        Boolean innerException = Boolean.FALSE;

        Boolean innerCatch = Boolean.FALSE;

        propagationService.outerTransaction(outerPropagation, innerPropagation,outerName,innerName,
                outerException,innerException,innerCatch);
    }

    @Test
    public void transactionAnnotationTest(){
        String name = "01112321b85";
        int i = propagationService.defaultExecute(name);
        logger.error("jieguo:{}",i);
    }


    @Test
    public void invokeTest() throws Exception {
        String motherName = "";
        String childName = "";
        // REQUIRED + NEVER :Existing transaction found for transaction marked with propagation 'never'
//        invoke(REQUIRED,NEVER);

        // NOTRANSACTION+MANDATORY:No existing transaction found for transaction marked with propagation 'mandatory'
        invoke(NOTRANSACTION, Boolean.FALSE,MANDATORY, Boolean.FALSE);
    }
    /**
     * 通过参数确定 方法组合
     * @author jiangwang
     * 11:05 2018/4/19
     */
    private void invoke(String motherMethodName, Boolean motherException, String childMethodName, Boolean childException)throws Exception {
        Method childMethod = getMethod(childMethodName,String.class,Boolean.class);
        Method motherMethod = getMethod(motherMethodName,Boolean.class,Method.class,Object.class,Object[].class);
        doInvoke(motherMethod,propagationService,childException,childMethod,propagationService,null);
    }

    /**
     * 方法执行
     * @author jiangwang
     * 11:06 2018/4/19
     */
    private void doInvoke(Method method, Object object, Object... args) throws Exception {
        method.invoke(object,args);
    }

    /**
     * 通过反射获取方法
     * @author jiangwang
     * 11:06 2018/4/19
     */
    private Method getMethod (String methodName, Class<?>... parameterTypes){
        try {
            Class<?> clazz = Class.forName("com.foo.service.transaction.propagation.PropagationService");
            return clazz.getMethod(methodName,parameterTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发生异常
     * @author jiangwang
     * 11:24 2018/4/19
     */
    private void doException(){
        Assert.notNull(null, "'annotationType' must not be null");
    }

    /**
     * @author jiangwang
     * 16:02 2018/4/18
     */
    private void insertEntry(String name){
        userService.insert(name);
    }

}
