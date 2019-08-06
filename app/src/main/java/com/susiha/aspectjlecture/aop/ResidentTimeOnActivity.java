package com.susiha.aspectjlecture.aop;

import android.os.SystemClock;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 在Activity上的驻留时间
 */
@Aspect
public class ResidentTimeOnActivity {
    //定义当前时间
    long currentTime;

    //执行所有本包内Activity子类的onStart方法
    private final String onStart_PointCut ="execution(void *..Activity+.onStart(..))&&within(com.susiha.aspectjlecture..*)";

    //执行所有本包内Activity子类的onStop方法
    private final String onStop_PointCur ="execution(void *..Activity+.onStop(..))&&within(com.susiha.aspectjlecture..*)";
    //定义onStart的pointCut
    @Pointcut(onStart_PointCut)
    public void onStart(){ }

    //定义onStop的pointCut
    @Pointcut(onStop_PointCur)
    public void onStop(){ }

    //排除掉onStart内部的函数
    private final String onStart_excludeInner ="onStart()&&!cflowbelow(onStart())";
    private final String onStop_excludeInner ="onStop()&&!cflowbelow(onStop())";

    @Pointcut(onStart_excludeInner)
    public void execOnStart(){}
    @Pointcut(onStop_excludeInner)
    public void execOnStop(){}







    @Around("execOnStart()")
    public void startOnActivity(ProceedingJoinPoint joinPoint) throws Throwable {
        currentTime = SystemClock.currentThreadTimeMillis();
        joinPoint.proceed();

        String currentActivity = joinPoint.getTarget().getClass().getSimpleName();

        Log.i("AspectJS:"+currentActivity,"start");
    }


    @Around("execOnStop()")
    public void stopOnActivity(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
        String currentActivity = joinPoint.getTarget().getClass().getSimpleName();
        long residentTime = SystemClock.currentThreadTimeMillis()-currentTime;
        Log.i("AspectJS:"+currentActivity,"stop");
        Log.i("AspectJS:"+currentActivity,"residentTime ="+residentTime);




    }



}
