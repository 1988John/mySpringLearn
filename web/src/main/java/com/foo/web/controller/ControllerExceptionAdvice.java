package com.foo.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.foo.domain.user.User;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author jiangwang
 * 10:48 2018/5/14
 */
//@ControllerAdvice
public class ControllerExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Throwable.class)
    public @ResponseBody String handControllerException(Throwable ex){
        logger.error("访问控制器发生异常==>异常信息: " , ex);
        if (ex instanceof MissingServletRequestParameterException) {
            //请求参数为空
            return "";
        }else if(ex instanceof BindException){
            return processBindException((BindException) ex);
        }
        else if(ex instanceof ConstraintViolationException){
            return processConstraintViolationException((ConstraintViolationException) ex);
        }
        else if(ex instanceof MethodConstraintViolationException){
            return processMethodConstraintViolationException((MethodConstraintViolationException) ex);
        }else{
            return "";
        }

    }

    /**
     * 处理参数绑定错误
     * @author jiangwang
     * 10:46 2018/5/14
     */
    private String processBindException(BindException bindException){
        List<ObjectError> errors = bindException.getAllErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : errors) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(error.getDefaultMessage());
        }
        return stringBuilder.toString();
    }

    /**
     * 处理异常
     *
     * @author jiangwang
     * @date 15:10 2018/6/16
     */
    private String processConstraintViolationException(ConstraintViolationException cvException){
        Set<ConstraintViolation<?>> cvSet =  cvException.getConstraintViolations();
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<?>cv : cvSet) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(cv.getMessageTemplate());
        }
        return stringBuilder.toString();
    }

    /**
     * 处理异常
     *
     * @author jiangwang
     * @date 15:10 2018/6/16
     */
    private String processMethodConstraintViolationException(MethodConstraintViolationException msvException){
        Set<MethodConstraintViolation<?>> mcvSet = msvException.getConstraintViolations();
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<?>cv : mcvSet) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(cv.getMessageTemplate());
        }
        return stringBuilder.toString();
    }

    public List<String> getUserNames11(List<User> users) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) != null) {
                names.add(users.get(i).getName() + " " + users.get(i).getSurname());
            }
        }
        return names;
    }

}
