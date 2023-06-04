package com.company.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.company.controller.CourseController.*(..))")
//    public void myPointcut(){
//
//    }
//
//    @Before("myPointcut()")
//    public void log(){
//        logger.info("info log..........");
//    }

//    @Before("execution(* com.company.controller.CourseController.*(..))")
//    public void log(){
//        logger.info("info log..........");
//    }

    @Pointcut("execution(* com.company.repository.CourseRepository.findById(*))")
    public void courseRepositoryFindByIdPC(){}

    @Before("courseRepositoryFindByIdPC()")
    public void beforeCourseRepositoryFindById(JoinPoint joinPoint){
        logger.info("Before -> Method: {}, Argument: {}, Target: {}",
                joinPoint.getSignature(),
                joinPoint.getArgs(),
                joinPoint.getTarget());
    }
}
