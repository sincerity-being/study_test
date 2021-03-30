package com.study.spring.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 *
 *
 *@author: HeYQ
 *@date: 2020-07-15 09:46
 *@describe:
 *@version:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
     public Docket webApiConfig(){
         return new Docket(DocumentationType.SWAGGER_2)
                 .groupName("webApi")
                 .apiInfo(webApiInfo())
                 .select()
                 .paths(Predicates.not(PathSelectors.regex("/error.*")))
                 .build();
     }

    /***
     *
     * @return
     */
    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("测试spring开发的问题")
                .description("本文档描述了spring验证的服务接口定义")
                .version("1.0")
                .contact(new Contact("hyq","http://hyq.com",
                        "55317332@qq.com"))
                .build();

    }


}
