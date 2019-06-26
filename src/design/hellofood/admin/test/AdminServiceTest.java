package design.hellofood.admin.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import design.hellofood.admin.entity.AdminUser;
import design.hellofood.admin.service.AdminService;
import design.hellofood.admin.util.Result;

public class AdminServiceTest {
	
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	AdminService adminService = ac.getBean("adminServiceImpl",AdminService.class);
	
	@Test
	public void testAdminLogin() {

		Result result = adminService.AdminLogin("test1", "HelloFood1");
		System.out.println("status:"+result.getStatus());
		System.out.println("msg:"+result.getMsg());
		AdminUser adminUser=(AdminUser) result.getData();
		System.out.println(adminUser);
	}
	
	@Test
	public void testAdminregist(){
		
		Result result = adminService.registAdmin("testend1", "HelloFood1");
		System.out.println(result);
	}
	
	@Test
	public void testAdmindelete(){
		
		Result result = adminService.DeleteAdmin(1);
	}
	
	@Test
	public void testfindById(){
		
		Result result = adminService.loadAdminById(3);
		System.out.println(result);
	}
	
	@Test
	public void testfindAll() {
		
		Result result = adminService.findAll(1);
		System.out.println(result);
	}
	
	@Test
	public void testupdatePwd(){
		Result result = adminService.updatePwd(3, "HelloFood1", "H1234567");
		System.out.println(result);
	}
	
	@Test
	public void testupdateById(){
		Result result = adminService.updateById(3,"798682482@qq.com","不知道","15595759260","Man");
		System.out.println(result);
	}
	
	

}
