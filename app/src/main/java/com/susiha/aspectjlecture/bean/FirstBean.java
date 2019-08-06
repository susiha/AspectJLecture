package com.susiha.aspectjlecture.bean;

/**
 *
 */
public class FirstBean {
    public int getmFlag() {
        System.out.println("调用了这个getmFlag方法");
        return mFlag;
    }

    public void setmFlag(int mFlag) {
        this.mFlag = mFlag;
    }

    private int mFlag = 0;
    public FirstBean(int flag){
        this.mFlag = flag;
        System.out.println("调用了这个方法");
    }
}
