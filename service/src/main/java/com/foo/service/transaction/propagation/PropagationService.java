package com.foo.service.transaction.propagation;

import com.foo.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Description:
 * Created by jiangwang3 on 2018/4/18.
 */
@Service
public class PropagationService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private UserService userService;

    @Resource
    private DataSourceTransactionManager transactionManager;

    /**
     * 外层事物
     * @author jiangwang
     * 15:52 2018/4/19
     */
    public void outerTransaction(int outerPropagation, final int innerPropagation,
                                 final String outerName, final String innerName,
                                 final Boolean outerException, final Boolean innerException,
                                 final Boolean innerCatch){
        TransactionTemplate transactionTemplate = getTransactionTemplate(outerPropagation);
        transactionTemplate.setName("outerTransaction");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                logger.info("outer事物执行开始。。。");
                insertEntry(outerName);
                //是否捕获
                if (innerCatch){
                    try {
                        innerTransaction(innerPropagation,innerName,innerException);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    innerTransaction(innerPropagation,innerName,innerException);
                }

                //发生异常 回滚
                occurException(outerException);
                logger.info("outer事物执行结束。。。");
            }
        });
    }

    /**
     * 内层事物
     * @author jiangwang
     * 15:52 2018/4/19
     */
    private void innerTransaction(int propagation, final String name, final Boolean exception){
        TransactionTemplate transactionTemplate = getTransactionTemplate(propagation);
        transactionTemplate.setName("innerTransaction");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                logger.info("inner事物执行开始。。。");
                insertEntry(name);
                //发生异常 回滚
                occurException(exception);
                logger.info("inner事物执行结束。。。");
            }
        });
    }

//    @Transactional
    public int defaultExecute(String name){
        insertEntry(name);
        return 110;
    }



    public void noTransaction(String name, Boolean exception, Method method, Object object, Object... args){
        doInvoke(method,object,name,exception,args);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void required(String name, Boolean exception, Method method, Object object, Object... args){
        doInvoke(method,object,name,exception,args);
        occurException(exception);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports(String name, Boolean exception){

    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatory(String name, Boolean exception){

    }

    @Transactional(propagation = Propagation.NESTED)
    public void nested(String name, Boolean exception){
        occurException(exception);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void never(String name, Boolean exception){

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew(String name, Boolean exception){

    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported(String name, Boolean exception){

    }

    private TransactionTemplate getTransactionTemplate(int propagation){
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setPropagationBehavior(propagation);
        return transactionTemplate;
    }

    private void doInvoke(Method method, Object object, String name, Boolean exception, Object... args){
        try {
            insertEntry(name);
            method.invoke(object,args);
            occurException(exception);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 发生异常
     * @author jiangwang
     * 11:24 2018/4/19
     */
    private void occurException(Boolean flag){
        if (flag){
            Assert.notNull(null, "'annotationType' must not be null");
        }
    }

    /**
     * 发生异常
     * @author jiangwang
     * 11:24 2018/4/19
     */
    private void occurExceptionWithCache(Boolean flag){
        if (flag){
            Assert.notNull(null, "'annotationType' must not be null");
        }
    }

    /**
     * @author jiangwang
     * 16:02 2018/4/18
     */
    private void insertEntry(String name){
        userService.insert(name);
    }

}
