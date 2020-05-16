package com.boot.create.api.model;


import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class RespEntity<T> implements Serializable {
	private static final long serialVersionUID = -720807478055084231L;
	
	private String status;
	private String code;
	private String msg;
	private T data;

	public RespEntity(){
		
	}
	
	public RespEntity(String status,String code){
		this.status = status;
		this.code = code;
	}
	public RespEntity(String status,String code, String msg){
		this.status = status;
		this.code = code;
		this.msg = msg;
	}
	public RespEntity(String status,String code, T data){
		this.status = status;
		this.code = code;
		this.data = data;
	}
	public RespEntity(String status,String code, String msg,T data){
		this.status = status;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

}
