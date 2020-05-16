/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.boot.create.api.controller.test;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.create.api.model.RespEntity;
import com.boot.create.mysql.template.entity.UserTest;
import com.boot.create.mysql.template.service.IUserTestService;





@RestController
@RequestMapping("test")
public class TestServerController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestServerController.class);

	@Autowired
	private IUserTestService userTestService; 
	
	@RequestMapping(value = "selectTest", method = RequestMethod.GET,produces="application/json")
	public RespEntity<Object> checkServer() {
		List<UserTest> userList = userTestService.list();		
		RespEntity<Object> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg("http ok!");
		entity.setData(userList);
		return entity;
	}
	
}
