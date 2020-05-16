package com.boot.create.mysql.template;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

/**
 * 
 * @author taojin
 *
 */
@Data
public class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@TableId(type = IdType.AUTO)
    protected Long id;
	
	 /**
     * 创建时间
     */
	protected Timestamp createTime;

    /**
     * 更新时间
     */
	protected Timestamp updateTime;
	
}
