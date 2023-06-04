package com.company.aspect;

import com.company.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

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

//    @Pointcut("execution(* com.company.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdPC(){}
//
//    @Before("courseRepositoryFindByIdPC()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Argument: {}, Target: {}",
//                joinPoint.getSignature(),
//                joinPoint.getArgs(),
//                joinPoint.getTarget());
//    }

//    @Pointcut("within(com.company.controller..*)")
//    public void anyControllerOperation() {
//    }
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation() {
//    }
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Argument: {}, Target: {}",
//                joinPoint.getSignature(),
//                joinPoint.getArgs(),
//                joinPoint.getTarget());
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation() {
//    }
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Argument: {}, Target: {}",
//                joinPoint.getSignature(),
//                joinPoint.getArgs(),
//                joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(com.company.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC() {
//    }
//
//    @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Argument: {}, Target: {}",
//                joinPoint.getSignature(),
//                joinPoint.getArgs(),
//                joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation() {
//    }

//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "result")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result) {
//        logger.info("Before -> Method: {}, Result: {}",
//                joinPoint.getSignature(),
//                result.toString());
//    }

//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "results")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results) {
//        logger.info("Before -> Method: {}, Results: {}",
//                joinPoint.getSignature(),
//                results.toString());
//    }

//    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
//    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception){
//        logger.error("After Throwing -> Method: {}, Exception: {}"
//        , joinPoint.getSignature().toShortString(), exception.getMessage());
//    }

    @Pointcut("@annotation(com.company.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC() {
    }

    @Around("loggingAnnotationPC()")
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("Before -> Method: {} - Parameter {}"
                , proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        logger.info("After -> Method: {} - Result: {}",
                proceedingJoinPoint.getSignature().toShortString(), result.toString());

        return result;
    }
}
