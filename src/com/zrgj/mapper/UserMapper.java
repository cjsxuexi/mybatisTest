package com.zrgj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrgj.bean.User;
import com.zrgj.vo.UserQueryVo;

//  用户Mapper接口
public interface UserMapper {

	// 根据用户id查询用户
	public User getById(int id);
	
	// 新增用户
	public void insert(User user);
	
	// 根据用户名查询用户
	public List<User> getByUsername(String username);
	
	// 根据用户名和性别查询用户
	public List<User> getByUsernameAndSex(@Param("username")String username,
										  @Param("sex")String sex);
	
	// 查询用户
	public List<User> getUserByUserBean(User user);
	
	// 查询用户
	public List<User> getUserByMap(Map<String, Object> params);
	
	// 根据用户id列表查询用户
	public List<User> getUsersByIds(List<Integer> ids);
	
	// 根据用户id列表查询用户
	public List<User> getUsersByIdsForArray(Integer[] ids);
	
	//  根据查询实体查询用户
	public List<User> getUsersByQueryVo(UserQueryVo userQueryVo);
	
	// 根据查询条件查询总记录数
	public int getUsersCountByQueryVo(UserQueryVo userQueryVo);
	
	//  根据查询实体查询用户,演示的是查询出来的结果是一个map resultType
	public List<Map<String, Object>> getUsersByQueryVoForResultTypeMap(UserQueryVo userQueryVo);

	// 根据查询实体vo查询用户,目的是演示的是map resultMap
	public List<User> getUsersByQueryVoForResultMap(UserQueryVo userQueryVo);
	
	//-------------------------------动态sql-----------------------
	
	// 根据用户查询实体查询用户
	public List<User> getUsersByUserBeanForIf(UserQueryVo userQueryVo);
	
	// 根据用户查询实体查询用户的总数
	public int getUsersCountByUserBeanForIf(UserQueryVo userQueryVo);
	
	// 根据用户id的列表查询用户
	public List<User> getUsersByIdsForEach(UserQueryVo userQueryVo);
	
	// 根据用户id的列表查询用户
	public List<User> getUsersByIdsForEach2(List<Integer> ids);
	
	// 批量添加用户
	public void insertBatch(List<User> user);
	
	// 查询用户依据map
	public List<User> getUsersForChoose(Map<String,Object> params);
}
