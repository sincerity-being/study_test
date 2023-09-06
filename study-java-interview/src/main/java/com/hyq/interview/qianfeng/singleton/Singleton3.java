package com.hyq.interview.qianfeng.singleton;

public enum Singleton3 {
    INSTANCE {
        @Override
        protected void doSomething() {
            System.out.println("doSomething");
        }
    };

    protected abstract void doSomething();
}
