import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// test class
public class StudentsTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		// 创建会话工厂对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 会话对象
		session = sessionFactory.openSession();
		// 开启事务
		transaction = session.beginTransaction();
	}
	
	@After
	public void destory() {
		// 提交事务
		transaction.commit();
		// 关闭会话
		session.close();
		// 关闭会话工厂
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudents() {
		Students s = new Students(1, "zhangsan", "male", new Date(), "dafgaf2w");
		session.save(s);
	}
	
	@Test
	public void testGetStudents() {
		Students s = (Students) session.get(Students.class, 1);
		System.out.println(s);
	}
	
	@Test
	public void testLoadStudents() {
		Students s = (Students) session.load(Students.class, 1);
		System.out.println(s);
	}
	
	@Test
	public void testUpdateStudents() {
		Students s = (Students) session.get(Students.class, 1);
		s.setGender("female");
		session.update(s);
	}
	
	@Test
	public void testDeleteStudents() {
		Students s = (Students) session.get(Students.class, 1);
		session.delete(s);
	}
}
