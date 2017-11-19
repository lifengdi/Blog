package com.lifengdi.blog.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * All rights Reserved, Designed By www.lifengdi.com
 * 
 * @ClassName BaseBean
 * @Description 实体基础类
 * @author 李锋镝
 * @date 2017年11月18日 下午11:10:56
 * @version v1.0.0
 * @Copyright 2017 www.lifengdi.com All rights reserved.
 */
public class BaseBean implements Serializable{

	private static final long serialVersionUID = -4844697091090188014L;
	private int id;
	private Timestamp createTime;
	private Timestamp modifyTime;
	/**
	 * 0:有效，-1:无效
	 */
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
