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
		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		// �����Ự��������
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		// �Ự����
		session = sessionFactory.openSession();
		// ��������
		transaction = session.beginTransaction();
	}
	
	@After
	public void destory() {
		// �ύ����
		transaction.commit();
		// �رջỰ
		session.close();
		// �رջỰ����
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
