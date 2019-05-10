package com.study.provider.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 简单实体Bean
 */
public class Users implements Serializable {

	private static final long serialVersionUID = -4624530072621682424L;

	private Integer id;
	private String userName;
	private String password;
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Users(Integer id, String userName, String password, Date createDate) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.createDate = createDate;
	}

	public Users() {
		super();
	}
}
