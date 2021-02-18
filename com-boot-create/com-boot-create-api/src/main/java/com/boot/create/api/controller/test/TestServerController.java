/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.boot.create.api.controller.test;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.boot.create.api.model.RespEntity;
import com.boot.create.mysql.template.entity.UserTest;
import com.boot.create.mysql.template.service.IUserTestService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@RestController
@RequestMapping("test")
public class TestServerController {


	@Autowired
	private IUserTestService userTestService; 
	
	@RequestMapping(value = "selectTest", method = RequestMethod.GET,produces="application/json")
	public RespEntity<List<UserTest>> selectTest() {
		List<UserTest> userList = userTestService.list();		
		RespEntity<List<UserTest>> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg("http ok!");
		entity.setData(userList);
		return entity;
	}
	
	
	
	@ApiOperationSupport(author = "taojin")
	@ApiOperation(value = "根据姓名获取列表")	
    @RequestMapping(value = "/queryByName/{name}", method = RequestMethod.GET)
    public RespEntity<List<UserTest>> queryByName(HttpServletRequest request, 
    		@PathVariable String name,
    		@RequestParam(required = false) Integer age) {
    	UserTest query = new UserTest();
    	query.setName("guyao");
    	query.setAge(age);
    	log.info("query:"+JSONObject.toJSONString(query));
    	
    	List<UserTest> userList = userTestService.listByEntity(query);
		RespEntity<List<UserTest>> entity = new RespEntity<>();
		entity.setStatus("1");
		entity.setMsg("http ok!");
		entity.setData(userList);
        return entity;
    }
	
}
