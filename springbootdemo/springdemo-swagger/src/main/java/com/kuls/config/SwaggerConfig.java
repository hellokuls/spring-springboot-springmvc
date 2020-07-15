package com.kuls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/9 9:21 上午
 */

@Configuration
@EnableSwagger2   //开启swagger2
public class SwaggerConfig {




    //配置了swagger的docket实例
    @Bean
    public Docket docket(Environment environment){

        //判断生产环境
        Profiles profiles = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profiles);



        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("kuls1")
                .select()
                //RequestHandlerSelectors，配置扫描接口方式
                .apis(RequestHandlerSelectors.basePackage("com.kuls.controller"))
                //过滤
//                .paths(PathSelectors.ant("/kuls/**"))
                .build();
    }

    @Bean
    public Docket docket1(){


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("kuls2")
                .select()
                //RequestHandlerSelectors，配置扫描接口方式
                .apis(RequestHandlerSelectors.basePackage("com.kuls.controller"))
                //过滤
//                .paths(PathSelectors.ant("/kuls/**"))
                .build();
    }


    //配置swagger信息
    public ApiInfo apiInfo(){
        //根据源码来填写

        Contact DEFAULT_CONTACT = new Contact("kuls", "", "1839938674@qq.com");
        return new ApiInfo(
                "Kuls的swagger文档",
                "牛逼了我的kuls",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }








}

