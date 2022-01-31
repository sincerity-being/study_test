package com.study.basic.thread.callable;

import java.util.concurrent.FutureTask;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-23 08:52
 *@describe:
 *@version:
 */
public class CallableResult {

    private FutureTask<Integer> submit;

    public FutureTask<Integer> getSubmit() {
        return submit;
    }

    public void setSubmit(FutureTask<Integer> submit) {
        this.submit = submit;
    }
}
