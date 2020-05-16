package com.boot.create.mysql.template;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 * 用户测试 服务类
 * </p>
 *
 * @author taojin
 * @since 2020-05-14
 */
public interface MyBaseService<T> extends IService<T> {

	default T getByUnique(T entity) {
        return getBaseMapper().selectOne(new QueryWrapper<T>(entity));
    }
	
    default List<T> listByEntity(T entity) {
        return getBaseMapper().selectList(new QueryWrapper<T>(entity));
    }
    
    
    default IPage<T> page(long current,long size,Wrapper<T> queryWrapper){
    	IPage<T> page = new Page<>(current, size);
    	return this.page(page, queryWrapper);
    }
    
    
    
}
