package design.hellofood.admin.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import design.hellofood.admin.dao.AdminDao;
import design.hellofood.admin.entity.AdminUser;
import design.hellofood.admin.util.MybatisUtil;
import design.hellofood.admin.util.Page;


public class AdminDaoTest {
	
	SqlSession session = MybatisUtil.getSqlSession();
	AdminDao admindao = session.getMapper(AdminDao.class);
	
	@Test
	public void testSave() {
		
		AdminUser adminUser = new AdminUser();
		adminUser.setAid(2);
		adminUser.setAname("test2");
		adminUser.setApassword("123456");
		adminUser.setZname(null);
		adminUser.setChangetime(null);
		adminUser.setCreationtime(null);
		adminUser.setCid(1);
		adminUser.setPhone(null);
		adminUser.setSex(null);
		admindao.save(adminUser);
		session.commit();
		session.close();
	}
	
	@Test
	public void testdelete() {
		
		admindao.deleteById(1);
		session.commit();
		session.close();
	}
	
//	@Test
//	public void testfindAll() {
//		
//		List<AdminUser> adminUsers = admindao.findAll(1,10);
//		for(AdminUser adminUser:adminUsers){
//			System.out.println(adminUser);
//		}
//		session.close();
//		
//	}
	
	@Test
	public void testfindByName() {
		
		AdminUser adminUsers = admindao.findByName("test");
		System.out.println(adminUsers);
		session.close();
	}
	
	@Test
	public void testfindById() {
		
		AdminUser adminUsers = admindao.findById(2);
		System.out.println(adminUsers);
		session.close();
	}
	
	@Test
	public void testupdataById() {
		
		AdminUser adminUser = new AdminUser();
		adminUser.setAid(1);
		adminUser.setAname("test3");
		adminUser.setApassword("123456");
		adminUser.setZname("test");
		adminUser.setPhone("1");
		adminUser.setSex("test");
		admindao.updateById(adminUser);
		session.commit();
		session.close();
	}
	
	@Test
	public void testfindUnionById(){
		
		AdminUser adminUsers = admindao.findUnionById(3);
		System.out.println(adminUsers);
		
		session.close();
	}
}












