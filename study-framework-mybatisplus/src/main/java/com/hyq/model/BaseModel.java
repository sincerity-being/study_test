package com.hyq.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.List;

/**
 * https://www.cnblogs.com/yanpeng19940119/p/12541852.html
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 13:52
 * @describe
 */
public class BaseModel {

    @TableField(exist = false)
    @JSONField(serialize = false)
    private List<String> updateFieldList;

    public List<String> getUpdateFieldList() {
        return updateFieldList;
    }

    public void setUpdateFieldList(List<String> updateFieldList) {
        this.updateFieldList = updateFieldList;
    }


}
