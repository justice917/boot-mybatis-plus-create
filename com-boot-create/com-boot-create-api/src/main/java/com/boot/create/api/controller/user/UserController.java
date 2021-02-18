/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.boot.create.api.controller.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.create.api.model.RespEntity;
import com.boot.create.mysql.template.entity.UserTest;
import com.boot.create.mysql.template.service.IUserTestService;

import lombok.extern.slf4j.Slf4j;




@Slf4j
@RestController
@RequestMapping("user")
public class UserController {


	@Autowired
	private IUserTestService userTestService; 
	
	@RequestMapping(value = "selectTest", method = RequestMethod.GET,produces="application/json")
	public RespEntity<List<UserTest>> selectTest(Long userId) {
		UserTest query = new UserTest();
		query.setId(userId);
		List<UserTest> userList = userTestService.listByEntity(query);
		RespEntity<List<UserTest>> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg("http ok!");
		entity.setData(userList);
		return entity;
	}
		
	
}
