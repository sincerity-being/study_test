package com.study.thread.example2.callable;

import java.util.concurrent.Future;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-23 09:08
 *@describe:
 *@version:
 */
public class CallableFutureResult {
    private Future<Integer> submit;

    public Future<Integer> getSubmit() {
        return submit;
    }

    public void setSubmit(Future<Integer> submit) {
        this.submit = submit;
    }
}
