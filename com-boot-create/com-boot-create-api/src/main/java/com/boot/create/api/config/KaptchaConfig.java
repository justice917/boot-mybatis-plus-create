package com.boot.create.api.config;

import java.io.IOException;
import java.util.Properties;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Configuration
public class KaptchaConfig {
		
    @Bean
    public Producer defaultKaptcha() throws IOException{
    	DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties properties = PropertiesLoaderUtils.loadAllProperties("kaptcha.properties");        
        kaptcha.setConfig(new Config(properties));
        return kaptcha;
    }	
}
