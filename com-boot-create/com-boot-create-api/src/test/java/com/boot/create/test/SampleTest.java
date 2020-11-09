package com.boot.create.test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.create.MyBootApplication;
import com.boot.create.mysql.template.entity.UserTest;
import com.boot.create.mysql.template.service.IUserTestService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {

    @Resource
    private IUserTestService userTestService;
    
    @Test
    public void testGetAll() {
        System.out.println(("----- testGetAll method test ------"));
        List<UserTest> userList = userTestService.list(null);
        //Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    
    
    @Test
    public void testSelectByEntity() {
        System.out.println(("----- testGetAll method test ------"));
        UserTest one = new UserTest();
        one.setAge(26);
        one.setName("guyao");
                
        List<UserTest> userList = userTestService.listByEntity(one);
        //Assert.assertEquals(5, userList.size());
        userList.forEach(x->System.out.println(JSONObject.toJSONString(x)));            
        
    }
    
    @Test
    public void testSelectSomeField() {
        System.out.println(("----- testSelectSomeField method test ------"));
        List<UserTest> userList = userTestService.list(Wrappers.<UserTest>lambdaQuery()
        		.select(UserTest::getName,UserTest::getAge));
        userList.forEach(System.out::println);
        
        System.out.println(("----- testSelectSomeField method test ------"));
        userTestService.list(new QueryWrapper<UserTest>().select("id", "name")).forEach(System.out::println);
    }    
    
    @Test
    public void testSelectByWhere() {
        System.out.println(("----- testSelectByWhere method test ------"));
        List<UserTest> userList = userTestService.list(Wrappers.<UserTest>lambdaQuery()
        		.eq(UserTest::getName, "陶金").eq(UserTest::getAge, 18));
        userList.forEach(System.out::println);
        
      
    }  
    
    @Test
    public void testUpdate() {
        System.out.println(("----- testUpdate method test ------"));
        UserTest one = new UserTest();
        one.setId(1L);
        one.setName("陶金2");
        System.out.println("更新结果:"+userTestService.updateById(one));
        
        
        System.out.println("aa"+File.separator);
    }
   
    
    @Test
    public void testInsert() {
        System.out.println(("----- testInsert method test ------"));
        UserTest one = new UserTest();
        one.setName("guyao");
        one.setEmail("");
        one.setAge(26);
        one.setActAge(11);
        System.out.println("插入结果:"+userTestService.save(one));        
        System.out.println("插入的id:"+one.getId());
    }
    
    @Test
    public void testSelectPage() {
        System.out.println(("----- testSelectPage method test ------"));
        //current 从1开始
        IPage<UserTest> result = userTestService.page(1,5, Wrappers.<UserTest>lambdaQuery().orderByAsc(UserTest::getAge));

        System.out.println("数量数:"+result.getSize());
        System.out.println("总数:"+result.getTotal());
        result.getRecords().forEach(System.out::println);
    }    
    
    @Test
    public void testRedis() {
        System.out.println(("----- testSelectPage method test ------"));
        
        RedisTemplate<String,String> one = new RedisTemplate<>();
        one.opsForValue().setIfPresent("a", "a", 1, TimeUnit.SECONDS);
        
    }          
}
