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

		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3、通过工厂去获取SqlSession
		SqlSession session = factory.openSession();

		// 4、通过SqlSession去执行sql语句
		// 第一个参数的写法应是:namespace + "." + sql的id
		User user = session.selectOne("day1225.getUserById", 1);

		// 5、获取结果
		System.out.println(user.getUsername());

		// 6、关闭资源
		session.close();
	}

	// 查询所有的用户
	@Test
	public void testGetUsers() throws Exception {

		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3、通过工厂去获取SqlSession
		SqlSession session = factory.openSession();

		// 4、通过SqlSession去执行sql语句
		// 第一个参数的写法应是:namespace + "." + sql的id
		List<User> users = session.selectList("day1225.getUsers");

		// 5、获取结果
		for (User user : users) {
			System.out.println(user.getUsername());
		}

		// 6、关闭资源
		session.close();
	}

	// 根据id删除用户
	@Test
	public void testDeleteUserById() throws Exception {

		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3、通过工厂去获取SqlSession
		SqlSession session = factory.openSession();

		// 4、通过SqlSession去执行sql语句
		// 第一个参数的写法应是:namespace + "." + sql的id
		session.delete("day1225.deleteUserById", 2);

		// 在对数据库表修改操作的时候，记得要提交事务
		session.commit();

		// 5、关闭资源
		session.close();
	}

	// 根据用户名查询用户
	@Test
	public void testGetUserByUsername() throws Exception {

		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3、通过工厂去获取SqlSession
		SqlSession session = factory.openSession();

		// 4、通过SqlSession去执行sql语句
		// 第一个参数的写法应是:namespace + "." + sql的id
		List<User> users = session.selectList("day1225.getUserByUsername", "Hello");

		// 5、获取结果
		for (User user : users) {
			System.out.println(user.getUsername());
		}

		// 6、关闭资源
		session.close();
	}

	// 添加用户
	@Test
	public void testInsert() throws Exception {

		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3、通过工厂去获取SqlSession
		SqlSession session = factory.openSession();

		// 4、通过SqlSession去执行sql语句
		// 第一个参数的写法应是:namespace + "." + sql的id
		User user = new User();
		user.setAddress("linzhou");
		user.setBrithday(new Date());
		user.setSex("MAN");
		user.setUsername("JSP");
		
		session.insert("day1225.insert", user);
		
		session.commit();
		
		System.out.println("user.getId()--->" + user.getId());
		
		// 6、关闭资源
		session.close();
	}
	
	@Test
	public void testInsertGetPrimaryKey() throws Exception {

		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3、通过工厂去获取SqlSession
		SqlSession session = factory.openSession();

		// 4、通过SqlSession去执行sql语句
		// 第一个参数的写法应是:namespace + "." + sql的id
		User user = new User();
		user.setAddress("linzhou");
		user.setBrithday(new Date());
		user.setSex("MAN");
		user.setUsername("spingmvc");
		
		session.insert("day1225.insertReturnPrimaryKey", user);
		
		session.commit();
		
		System.out.println("user.getId()--->" + user.getId());
		
		// 6、关闭资源
		session.close();
	}

	@Test
	public void testUpdateById() throws Exception {

		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3、通过工厂去获取SqlSession
		SqlSession session = factory.openSession();

		// 4、通过SqlSession去执行sql语句
		// 第一个参数的写法应是:namespace + "." + sql的id
		User user = new User();
		user.setId(3);
		//user.setUsername("struts2-->");
		user.setSex("xyz");

		session.update("day1225.updateById", user);
		
		session.commit();
		// 6、关闭资源
		session.close();
	}
	
	// 根据用户名和性别查询用户
	@Test
	public void testGetUserByUsernameAndSex() throws Exception {

		// 1、加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 2、通过配置文件去创建SqlSessionFactory工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		// 3、通过工厂去获取SqlSession
		SqlSession session = factory.openSession();

		// 4、通过SqlSession去执行sql语句
		// 第一个参数的写法应是:namespace + "." + sql的id
		//User userFormBean = new User();
		//userFormBean.setUsername("Tomcat");
		//userFormBean.setSex("xyz");

		List<User> users = session.selectList("day1225.getUserByUsernameAndSex");
		
		System.out.println(users);
		
		session.commit();
		// 6、关闭资源
		session.close();
	}
}
