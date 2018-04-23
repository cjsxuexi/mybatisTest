package com.zrgj.test.user;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zrgj.bean.User;

public class UserTest1 {

	@Test
	public void testGetUserById() throws Exception {

		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3��ͨ������ȥ��ȡSqlSession
		SqlSession session = factory.openSession();

		// 4��ͨ��SqlSessionȥִ��sql���
		// ��һ��������д��Ӧ��:namespace + "." + sql��id
		User user = session.selectOne("day1225.getUserById", 1);

		// 5����ȡ���
		System.out.println(user.getUsername());

		// 6���ر���Դ
		session.close();
	}

	// ��ѯ���е��û�
	@Test
	public void testGetUsers() throws Exception {

		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3��ͨ������ȥ��ȡSqlSession
		SqlSession session = factory.openSession();

		// 4��ͨ��SqlSessionȥִ��sql���
		// ��һ��������д��Ӧ��:namespace + "." + sql��id
		List<User> users = session.selectList("day1225.getUsers");

		// 5����ȡ���
		for (User user : users) {
			System.out.println(user.getUsername());
		}

		// 6���ر���Դ
		session.close();
	}

	// ����idɾ���û�
	@Test
	public void testDeleteUserById() throws Exception {

		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3��ͨ������ȥ��ȡSqlSession
		SqlSession session = factory.openSession();

		// 4��ͨ��SqlSessionȥִ��sql���
		// ��һ��������д��Ӧ��:namespace + "." + sql��id
		session.delete("day1225.deleteUserById", 2);

		// �ڶ����ݿ���޸Ĳ�����ʱ�򣬼ǵ�Ҫ�ύ����
		session.commit();

		// 5���ر���Դ
		session.close();
	}

	// �����û�����ѯ�û�
	@Test
	public void testGetUserByUsername() throws Exception {

		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3��ͨ������ȥ��ȡSqlSession
		SqlSession session = factory.openSession();

		// 4��ͨ��SqlSessionȥִ��sql���
		// ��һ��������д��Ӧ��:namespace + "." + sql��id
		List<User> users = session.selectList("day1225.getUserByUsername", "Hello");

		// 5����ȡ���
		for (User user : users) {
			System.out.println(user.getUsername());
		}

		// 6���ر���Դ
		session.close();
	}

	// ����û�
	@Test
	public void testInsert() throws Exception {

		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3��ͨ������ȥ��ȡSqlSession
		SqlSession session = factory.openSession();

		// 4��ͨ��SqlSessionȥִ��sql���
		// ��һ��������д��Ӧ��:namespace + "." + sql��id
		User user = new User();
		user.setAddress("linzhou");
		user.setBrithday(new Date());
		user.setSex("MAN");
		user.setUsername("JSP");
		
		session.insert("day1225.insert", user);
		
		session.commit();
		
		System.out.println("user.getId()--->" + user.getId());
		
		// 6���ر���Դ
		session.close();
	}
	
	@Test
	public void testInsertGetPrimaryKey() throws Exception {

		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3��ͨ������ȥ��ȡSqlSession
		SqlSession session = factory.openSession();

		// 4��ͨ��SqlSessionȥִ��sql���
		// ��һ��������д��Ӧ��:namespace + "." + sql��id
		User user = new User();
		user.setAddress("linzhou");
		user.setBrithday(new Date());
		user.setSex("MAN");
		user.setUsername("spingmvc");
		
		session.insert("day1225.insertReturnPrimaryKey", user);
		
		session.commit();
		
		System.out.println("user.getId()--->" + user.getId());
		
		// 6���ر���Դ
		session.close();
	}

	@Test
	public void testUpdateById() throws Exception {

		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3��ͨ������ȥ��ȡSqlSession
		SqlSession session = factory.openSession();

		// 4��ͨ��SqlSessionȥִ��sql���
		// ��һ��������д��Ӧ��:namespace + "." + sql��id
		User user = new User();
		user.setId(3);
		//user.setUsername("struts2-->");
		user.setSex("xyz");

		session.update("day1225.updateById", user);
		
		session.commit();
		// 6���ر���Դ
		session.close();
	}
	
	// �����û������Ա��ѯ�û�
	@Test
	public void testGetUserByUsernameAndSex() throws Exception {

		// 1�����������ļ�
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2��ͨ�������ļ�ȥ����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3��ͨ������ȥ��ȡSqlSession
		SqlSession session = factory.openSession();

		// 4��ͨ��SqlSessionȥִ��sql���
		// ��һ��������д��Ӧ��:namespace + "." + sql��id
		//User userFormBean = new User();
		//userFormBean.setUsername("Tomcat");
		//userFormBean.setSex("xyz");

		List<User> users = session.selectList("day1225.getUserByUsernameAndSex");
		
		System.out.println(users);
		
		session.commit();
		// 6���ر���Դ
		session.close();
	}
}
