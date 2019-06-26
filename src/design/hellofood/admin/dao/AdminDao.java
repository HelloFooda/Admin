package design.hellofood.admin.dao;

import java.util.List;
import java.util.Map;

import org.omg.CORBA.INTERNAL;

import design.hellofood.admin.entity.AdminUser;
import design.hellofood.admin.util.Page;

public interface AdminDao {
	public int save(AdminUser adminUser);
	public int deleteById(int Aid);
	public AdminUser findByName(String Aname);
	public List<AdminUser>findAll(Page page);
	public int updateById(AdminUser adminUser);
	public AdminUser findById(int Aid);
	public AdminUser findUnionById(int Aid);	
}
