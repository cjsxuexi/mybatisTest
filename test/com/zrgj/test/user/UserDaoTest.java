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
		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		factory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testGetUserByUsername() throws Exception {

		// ��ȡsession
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		List<User> users = userMapper.getByUsername("JSP");

		System.out.println(users);

		session.commit();
	}

	// �����û������Ա��ѯ�û�
	@Test
	public void testGetUserByUsernameAndSex() throws Exception {

		// ��ȡsession
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		List<User> users = userMapper.getByUsernameAndSex("JSP", null);

		System.out.println(users);

		session.commit();
	}

	// �����û������Ա��ѯ�û�
	@Test
	public void testGetUserByUserBean() throws Exception {

		// ��ȡsession
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		User user = new User();
		// user.setUsername("JSP");
		user.setSex("MAN");

		List<User> users = userMapper.getUserByUserBean(user);

		System.out.println(users);

		session.commit();
	}

	// �����û������Ա��ѯ�û�
	@Test
	public void testGetUserByMap() throws Exception {

		// ��ȡsession
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		Map<String, Object> params = new HashMap<>();
		params.put("username", "JSP");
		params.put("sex", "MAN");

		List<User> users = userMapper.getUserByMap(params);

		System.out.println(users);

		session.commit();
	}

	// �����û������Ա��ѯ�û�
	@Test
	public void testGetUsersByIds() throws Exception {

		// ��ȡsession
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

	// �����û������Ա��ѯ�û�
	@Test
	public void testGetUsersByIdsForArray() throws Exception {

		// ��ȡsession
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		Integer[] arrs = new Integer[] { 3, 4, 5, 1 };

		List<User> users = userMapper.getUsersByIdsForArray(arrs);

		System.out.println(users);

		session.commit();
	}

	// �����û������Ա��ѯ�û�
	@Test
	public void testGetUsersByQueryVo() throws Exception {

		// ��ȡsession
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

	// ���ݸ��ݲ�ѯ������ѯ�ܼ�¼��
	@Test
	public void testGetUsersCount() throws Exception {

		// ��ȡsession
		SqlSession session = factory.openSession();

		UserMapper userMapper = session.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		User user = new User();
		user.setUsername("JSP");
		user.setSex("Man");
		userQueryVo.setUser(user);

		int count = userMapper.getUsersCountByQueryVo(userQueryVo);

		System.out.println("�ܼ�¼���ǣ�" + count + "��");

		session.commit();
	}

	// ���ݲ�ѯʵ��vo��ѯ�û�,Ŀ������ʾ����map resultMap
	@Test
	public void testGetUsersByQueryVoForResultMap() throws Exception {

		// ��ȡsession
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

	// ���ݸ��ݲ�ѯ������ѯ�û�,��ʾ���Ƿ���ֵ��map
	@Test
	public void testGetUsersByQueryVoForResultTypeMap() throws Exception {

		// ��ȡsession
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

	// ���ݸ��ݲ�ѯ������ѯ�û�,��ʾ���Ƿ���ֵ��map
	@Test
	public void testGetUsersByUserBeanForIf() throws Exception {

		// ��ȡsession
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

	// ���ݸ��ݲ�ѯ������ѯ�û�,��ʾ���Ƿ���ֵ��map
	@Test
	public void testGetUsersCountByUserBeanForIf() throws Exception {

		// ��ȡsession
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

		System.out.println("���ݲ�ѯ�������ܼ�¼��:" + count);
	}

	// ���ݸ��ݲ�ѯ������ѯ�û�,��ʾ���Ƿ���ֵ��map
	@Test
	public void testGetUsersByIdsForEach() throws Exception {

		// ��ȡsession
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

	// ���ݸ��ݲ�ѯ������ѯ�û�,��ʾ���Ƿ���ֵ��map
	@Test
	public void testGetUsersByIdsForEach2() throws Exception {

		// ��ȡsession
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

	// ���ݸ��ݲ�ѯ������ѯ�û�,��ʾ���Ƿ���ֵ��map
	@Test
	public void testInsertBatch() throws Exception {

		// ��ȡsession
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
		user2.setUsername("�");
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);

		userMapper.insertBatch(users);
		
		session.commit();
	}
	
	@Test
	public void testGetUsersForChoose() throws Exception {

		// ��ȡsession
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
