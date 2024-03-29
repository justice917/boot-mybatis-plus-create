package com.boot.create.api.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Author taojin
 *
 * 访问地址：http://${host}:${port}/doc.html
 * 使用参考：https://doc.xiaominfo.com/guide/useful.html
 *
 *
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
	
	@Bean(value = "defaultApi2")
    public Docket defaultApi2() {
		
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiInfo.DEFAULT)
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.boot.create.api.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
