/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.boot.create.api.controller.test;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.boot.create.api.model.RespEntity;
import com.boot.create.api.service.KaptchaService;
import com.boot.create.mysql.template.entity.UserTest;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@RestController
@RequestMapping("kaptcha")
public class KaptchaController {


	@Autowired
	private KaptchaService kaptchaService; 
	
	@ApiOperationSupport(author = "taojin")
	@ApiOperation(value = "动态图片")	
	@RequestMapping(value = "getImage", method = RequestMethod.GET,produces="application/json")
	public RespEntity<String> getImage(HttpServletRequest request) {
		String[] arr = kaptchaService.genVerifyCode();
		String imageBase64 = arr[1];
		String text = arr[0];
		RespEntity<String> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg(text);
		entity.setData(imageBase64);
		return entity;
	}
	
		
}
