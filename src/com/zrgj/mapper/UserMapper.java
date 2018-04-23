package com.zrgj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrgj.bean.User;
import com.zrgj.vo.UserQueryVo;

//  �û�Mapper�ӿ�
public interface UserMapper {

	// �����û�id��ѯ�û�
	public User getById(int id);
	
	// �����û�
	public void insert(User user);
	
	// �����û�����ѯ�û�
	public List<User> getByUsername(String username);
	
	// �����û������Ա��ѯ�û�
	public List<User> getByUsernameAndSex(@Param("username")String username,
										  @Param("sex")String sex);
	
	// ��ѯ�û�
	public List<User> getUserByUserBean(User user);
	
	// ��ѯ�û�
	public List<User> getUserByMap(Map<String, Object> params);
	
	// �����û�id�б��ѯ�û�
	public List<User> getUsersByIds(List<Integer> ids);
	
	// �����û�id�б��ѯ�û�
	public List<User> getUsersByIdsForArray(Integer[] ids);
	
	//  ���ݲ�ѯʵ���ѯ�û�
	public List<User> getUsersByQueryVo(UserQueryVo userQueryVo);
	
	// ���ݲ�ѯ������ѯ�ܼ�¼��
	public int getUsersCountByQueryVo(UserQueryVo userQueryVo);
	
	//  ���ݲ�ѯʵ���ѯ�û�,��ʾ���ǲ�ѯ�����Ľ����һ��map resultType
	public List<Map<String, Object>> getUsersByQueryVoForResultTypeMap(UserQueryVo userQueryVo);

	// ���ݲ�ѯʵ��vo��ѯ�û�,Ŀ������ʾ����map resultMap
	public List<User> getUsersByQueryVoForResultMap(UserQueryVo userQueryVo);
	
	//-------------------------------��̬sql-----------------------
	
	// �����û���ѯʵ���ѯ�û�
	public List<User> getUsersByUserBeanForIf(UserQueryVo userQueryVo);
	
	// �����û���ѯʵ���ѯ�û�������
	public int getUsersCountByUserBeanForIf(UserQueryVo userQueryVo);
	
	// �����û�id���б��ѯ�û�
	public List<User> getUsersByIdsForEach(UserQueryVo userQueryVo);
	
	// �����û�id���б��ѯ�û�
	public List<User> getUsersByIdsForEach2(List<Integer> ids);
	
	// ��������û�
	public void insertBatch(List<User> user);
	
	// ��ѯ�û�����map
	public List<User> getUsersForChoose(Map<String,Object> params);
}
