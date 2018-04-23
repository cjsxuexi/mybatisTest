package com.zrgj.vo;

import java.util.List;

import com.zrgj.bean.User;

// 代表的是一个查询实体
public class UserQueryVo {

	// 维护了一个实体
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// 其他的查询条件
	// ...........
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
