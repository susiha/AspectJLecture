package com.susiha.aspectjlecture.aop;


import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 通过AspectJ打印日志
 */

@Aspect
public class LoggByAspectJ {

    //MainActivity 执行方法使用execution(包括生命周期方法)
    private final String MainActivity_Execu_PointCuts ="execution(* com.susiha.aspectjlecture.MainActivity.*(..))";
    //MainActivity 所有方法调用 生命周期方法用execution,其他方法用call
    private final String MainActivity_AllMethod_PointCuts ="execution(* com.susiha.aspectjlecture.MainActivity.*(..))||call(* com.susiha.aspectjlecture.MainActivity.*(..))";
    //所有Activity 所有的执行方法
    private final String AllActivity_execu_PointCuts ="execution(* *.*(..))";

    //within 表示找到 某个包或者类中的所有切入点
    private final String withIn_PointCuts ="within(com.susiha.aspectjlecture.*)";

    private final String withInCode_PointCuts ="withincode(* com.susiha.aspectjlecture.*.*(..))";
    private final String withInCode_newPointCuts ="withincode(* com.susiha.aspectjlecture.*.*(..))||withincode(com.susiha.aspectjlecture.bean.*.new(..))";

    private final String call_MainActivityOnCreate ="execution(* com.susiha.aspectjlecture.MainActivity.onCreate(..))";
    private final String cflow_PointCuts ="cflow(callOnCreate())&&!within(com.susiha.aspectjlecture.aop.*)";
    private final String cflowbelow_PointCuts ="cflowbelow(callOnCreate())&&!within(com.susiha.aspectjlecture.aop.*)";


    @Pointcut(call_MainActivityOnCreate)
    public void callOnCreate(){}

    /**
     * 根据匹配 找到对应的切入点
     */
    @Pointcut(cflowbelow_PointCuts)
    protected void celLogPoinCut(){
    }
    @Around("celLogPoinCut()")
    public void executionLog(ProceedingJoinPoint jPoint) throws Throwable {
        String name = jPoint.getSignature().getName();
//        Object type = jPoint.getThis();
//        String JopintType;
//        if(type ==null){
//            JopintType ="此处Type为null";
//        }else{
//            JopintType = type.toString();
//        }
        jPoint.proceed();
        Log.i("AspectJS",name +" = "+jPoint.toShortString());
    }





}
