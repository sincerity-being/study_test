package com.hyq.mybatisplus.service;

import com.hyq.mybatisplus.model.AccountDO;

import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 14:00
 * @describe
 */
public interface AccountService {

     void update(AccountDO entity);

    void batchUpdate(List<AccountDO> entityList);
}
