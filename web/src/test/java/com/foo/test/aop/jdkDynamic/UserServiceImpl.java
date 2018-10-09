package com.foo.test.aop.jdkDynamic;

/**
 * 目标对象 
 * @author zyb 
 * @since 2012-8-9 
 * 
 */  
public class UserServiceImpl implements UserService {  
  
    /* (non-Javadoc) 
     * @see dynamic.proxy.UserServiceImpl#add()
     */  
    public void add() {  
        System.out.println("--------------------add---------------");  
    }  
}  