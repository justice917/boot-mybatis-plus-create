package com.boot.create.mysql.template.service.impl;

import com.boot.create.mysql.template.entity.UserTest;
import com.boot.create.mysql.template.mapper.UserTestMapper;
import com.boot.create.mysql.template.service.IUserTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户测试 服务实现类
 * </p>
 *
 * @author taojin
 * @since 2021-03-25
 */
@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements IUserTestService {

}
