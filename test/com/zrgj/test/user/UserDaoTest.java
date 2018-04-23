package com.zrgj.test.user;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zrgj.bean.User;
import com.zrgj.mapper.UserMapper;
import com.zrgj.vo.UserQueryVo;

public class UserDaoTest {

	private SqlSessionFactory factory = null;

	@Before
	public void init() throws Exception {
		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		factory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testGetUserByUsername() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		List<User> users = userMapper.getByUsername("JSP");

		System.out.println(users);

		session.commit();
	}

	// 根据用户名和性别查询用户
	@Test
	public void testGetUserByUsernameAndSex() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		List<User> users = userMapper.getByUsernameAndSex("JSP", null);

		System.out.println(users);

		session.commit();
	}

	// 根据用户名和性别查询用户
	@Test
	public void testGetUserByUserBean() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		User user = new User();
		// user.setUsername("JSP");
		user.setSex("MAN");

		List<User> users = userMapper.getUserByUserBean(user);

		System.out.println(users);

		session.commit();
	}

	// 根据用户名和性别查询用户
	@Test
	public void testGetUserByMap() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		Map<String, Object> params = new HashMap<>();
		params.put("username", "JSP");
		params.put("sex", "MAN");

		List<User> users = userMapper.getUserByMap(params);

		System.out.println(users);

		session.commit();
	}

	// 根据用户名和性别查询用户
	@Test
	public void testGetUsersByIds() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);

		List<User> users = userMapper.getUsersByIds(ids);

		System.out.println(users);

		session.commit();
	}

	// 根据用户名和性别查询用户
	@Test
	public void testGetUsersByIdsForArray() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		Integer[] arrs = new Integer[] { 3, 4, 5, 1 };

		List<User> users = userMapper.getUsersByIdsForArray(arrs);

		System.out.println(users);

		session.commit();
	}

	// 根据用户名和性别查询用户
	@Test
	public void testGetUsersByQueryVo() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		User user = new User();
		user.setUsername("JSP");
		user.setSex("Man");
		userQueryVo.setUser(user);

		List<User> users = userMapper.getUsersByQueryVo(userQueryVo);

		for (User u : users) {
			System.out.println(u.getAddress());
		}

		session.commit();
	}

	// 根据根据查询条件查询总记录数
	@Test
	public void testGetUsersCount() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		User user = new User();
		user.setUsername("JSP");
		user.setSex("Man");
		userQueryVo.setUser(user);

		int count = userMapper.getUsersCountByQueryVo(userQueryVo);

		System.out.println("总记录数是：" + count + "条");

		session.commit();
	}

	// 根据查询实体vo查询用户,目的是演示的是map resultMap
	@Test
	public void testGetUsersByQueryVoForResultMap() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		User user = new User();
		user.setUsername("JSP");
		user.setSex("Man");
		userQueryVo.setUser(user);

		List<User> users = userMapper.getUsersByQueryVoForResultMap(userQueryVo);

		for (User u : users) {
			System.out.println(u.getUsername());
			System.out.println(u.getId());
		}
	}

	// 根据根据查询条件查询用户,演示的是返回值是map
	@Test
	public void testGetUsersByQueryVoForResultTypeMap() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		User user = new User();
		user.setUsername("JSP");
		user.setSex("Man");
		userQueryVo.setUser(user);

		List<Map<String, Object>> resultList = userMapper.getUsersByQueryVoForResultTypeMap(userQueryVo);

		for (Map<String, Object> map : resultList) {
			Set<String> keySet = map.keySet();
			Iterator<String> iters = keySet.iterator();
			while (iters.hasNext()) {
				String key = iters.next();
				Object value = map.get(key);

				System.out.println(key + "--->" + value);
			}

		}
	}

	// 根据根据查询条件查询用户,演示的是返回值是map
	@Test
	public void testGetUsersByUserBeanForIf() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		User user = new User();
		// user.setUsername("JSP");
		user.setSex("Man");
		userQueryVo.setUser(user);

		List<User> users = userMapper.getUsersByUserBeanForIf(userQueryVo);

		for (User u : users) {
			System.out.println(u.getUsername());
		}
	}

	// 根据根据查询条件查询用户,演示的是返回值是map
	@Test
	public void testGetUsersCountByUserBeanForIf() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		User user = new User();
		user.setUsername("JSP");
		user.setSex("Man");
		userQueryVo.setUser(user);

		List<User> users = userMapper.getUsersByUserBeanForIf(userQueryVo);
		int count = userMapper.getUsersCountByUserBeanForIf(userQueryVo);

		for (User u : users) {
			System.out.println(u.getUsername());
		}

		System.out.println("根据查询条件的总记录是:" + count);
	}

	// 根据根据查询条件查询用户,演示的是返回值是map
	@Test
	public void testGetUsersByIdsForEach() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();

		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(3);
		ids.add(5);
		ids.add(6);

		userQueryVo.setIds(ids);

		List<User> users = userMapper.getUsersByIdsForEach(userQueryVo);
		for (User u : users) {
			System.out.println(u.getUsername());
		}
	}

	// 根据根据查询条件查询用户,演示的是返回值是map
	@Test
	public void testGetUsersByIdsForEach2() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		// List<Integer> ids = new ArrayList<>();
		// ids.add(1);
		// ids.add(3);
		// ids.add(5);
		// ids.add(6);
		// ids.add(11);

		List<User> users = userMapper.getUsersByIdsForEach2(null);
		for (User u : users) {
			System.out.println(u.getUsername());
		}
	}

	// 根据根据查询条件查询用户,演示的是返回值是map
	@Test
	public void testInsertBatch() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		User user1 = new User();
		user1.setAddress("beijing");
		user1.setBrithday(new Date());
		user1.setSex("oo");
		user1.setUsername("chaoge");
		
		User user2 = new User();
		user2.setAddress("hangzhou");
		user2.setBrithday(new Date());
		user2.setSex("pp");
		user2.setUsername("李超");
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);

		userMapper.insertBatch(users);
		
		session.commit();
	}
	
	@Test
	public void testGetUsersForChoose() throws Exception {

		// 获取session
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		Map<String,Object> params = new HashMap<>();
		params.put("username", "xxxxxxxx");

		List<User> users = userMapper.getUsersForChoose(params);
		
		for (User u : users) {
			System.out.println(u.getUsername());
		}
	}

}
