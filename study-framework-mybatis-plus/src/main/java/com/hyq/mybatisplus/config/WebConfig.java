package com.hyq.mybatisplus.config;

import com.hyq.mybatisplus.handler.BaseModelMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2020-11-11 14:25
 * @describe
 */
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new BaseModelMethodArgumentResolver());
    }
}
