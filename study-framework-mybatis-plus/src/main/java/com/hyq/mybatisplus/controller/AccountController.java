package com.hyq.mybatisplus.controller;

import com.hyq.mybatisplus.annotation.UpdateRequestBody;
import com.hyq.mybatisplus.model.AccountDO;
import com.hyq.mybatisplus.response.Result;
import com.hyq.mybatisplus.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 13:59
 * @describe
 */
public class AccountController {


    private AccountService accountService;

    @ResponseBody
    @PostMapping("/update")
    public Object update(@UpdateRequestBody AccountDO entity) {
        Result result = null;
        try {
            accountService.update(entity);
            result = Result.okResult();
        } catch (Exception e) {
            result = Result.errorResult();
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/batchUpdate")
    public Object batchUpdate(@UpdateRequestBody List<AccountDO> entityList) {
        Result result = null;
        try {
            accountService.batchUpdate(entityList);
            result = Result.okResult();
        } catch (Exception e) {
            result = Result.errorResult();
        }
        return result;
    }
}
