package com.hyq.mybatisplus.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 14:03
 * @describe
 */
@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {
    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应数据
     */
    private T data;


    /**
     * 响应时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time  = new Date();

    public Result() {

    }

    public Result(int code, String msg, boolean success){
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public static Result okResult() {
        return Result.builder()
                .code(200)
                .msg("成功")
                .success(true)
                .time(new Date())
                .build();

    }

    public static Result errorResult() {
        return Result.builder()
                .code(500)
                .msg("失败")
                .success(false)
                .time(new Date())
                .build();

    }
}
