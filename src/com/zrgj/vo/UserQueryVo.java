package com.zrgj.vo;

import java.util.List;

import com.zrgj.bean.User;

// �������һ����ѯʵ��
public class UserQueryVo {

	// ά����һ��ʵ��
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// �����Ĳ�ѯ����
	// ...........
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
