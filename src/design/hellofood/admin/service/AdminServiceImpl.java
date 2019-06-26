package design.hellofood.admin.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import design.hellofood.admin.dao.AdminDao;
import design.hellofood.admin.entity.AdminUser;
import design.hellofood.admin.util.MSUtil;
import design.hellofood.admin.util.Page;
import design.hellofood.admin.util.Result;

/**
 * 管理员模块方法实现
 * @author HelloFood
 */
//	添加事务注解
@Transactional
@Service
public class AdminServiceImpl implements AdminService{
	
	//注入adminDao
	@Resource
	private AdminDao adminDao;
	
//	注入事物
	@Resource
	private PlatformTransactionManager txManager;                                                                        
	
	Result result = new Result();
	
	//实现管理员登陆接口
	@Override
	public Result AdminLogin(String Aname, String Apassword) {
		
		//判断用户存在
		AdminUser adminUser = adminDao.findByName(Aname);
		if(adminUser==null){
			result.setStatus(1);
			result.setMsg("此用户不存在");
			return result;
		}
		//判断密码是否正确
		String md5_pwd=MSUtil.md5(Apassword);
		if(!md5_pwd.equals(adminUser.getApassword())){
			result.setStatus(1);
			result.setMsg("密码错误");
			return result;
		}
//		//更新登陆时间
//		int adminId = adminUser.getAid();
//		AdminUser updateAdmintime = new AdminUser();
//		updateAdmintime.setAid(adminId);
//		//获取当前系统时间
//		Timestamp now = new Timestamp(System.currentTimeMillis());
//		updateAdmintime.setChangetime(now);	
//		adminDao.updateById(adminId);
//		adminUser.setChangetime(adminDao.findById(adminId).getChangetime());

		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		result.setData(adminUser);
		return result;
	}
	
	//管理员注册
	@Override
	public Result registAdmin(String Aname, String Apassword) {
		
		AdminUser adminUser = adminDao.findByName(Aname);
		if (adminUser!=null) {
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;
		}
		
		AdminUser adminUser1 = new AdminUser();
		adminUser1.setAid(null);
		adminUser1.setAname(Aname);
		adminUser1.setApassword(MSUtil.md5(Apassword));
//		正则表达式验证密码
        Pattern Password_Pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(.{8,15})$");
        Matcher matcher = Password_Pattern.matcher(Apassword);
        
        if (matcher.matches()) {
        	System.out.println("密码格式正确");
        }else{
        	System.out.println("密码长度为8到20位,必须包含字母和数字，字母区分大小写");
        	return result;
        }
        adminDao.save(adminUser1);
        
//		测试制造异常
		String string = null;
		System.out.println(string.length());
		
		result.setStatus(0);
		result.setMsg("注册成功");
		result.setData(adminUser1);
		return result;
	}
	
//	删除管理员
	@Override
	public Result DeleteAdmin(int Aid) {
		int adminUser = adminDao.deleteById(Aid);
		return result;
	}

//	根据Id查询管理员
	@Override
	public Result loadAdminById(int Aid) {
		AdminUser adminUser = adminDao.findUnionById(Aid);
		if(adminUser==null){
			result.setStatus(1);
			result.setMsg("此管理员不存在");
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载此管理信息成功");
		result.setData(adminUser);
		return result;
	}

//	查询所有管理员
	@Override
	public Result findAll(int current) {
		
		Page page = new Page();
		page.setCurrent(current);
		page.setPageSize(10);
		List<AdminUser> adminUsers = adminDao.findAll(page);
		if (adminUsers.isEmpty()) {
			result.setStatus(1);
			result.setMsg("此页没有管理员");
			result.setData(adminUsers);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询管理员成功");
		result.setData(adminUsers);
		return result;
	}
	
//	修改管理员密码
	@Override
	public Result updatePwd(int Aid, String oldPwd, String newPwd) {
		
		AdminUser adminUser = adminDao.findById(Aid);
		if (adminUser==null) {
			result.setStatus(1);
			result.setMsg("不存在此管理");
			return result;
		}
		System.out.println(oldPwd);
		String md5_oldPwd=MSUtil.md5(oldPwd);
		System.out.println("原密码加密："+md5_oldPwd);
		System.out.println("数据库中原密码："+adminUser.getApassword());
		if(!md5_oldPwd.equals(adminUser.getApassword())){
			result.setStatus(1);
			result.setMsg("输入的原密码有误");
			return result;
		}
		//更新密码
		AdminUser adminUser1=new AdminUser();
		adminUser1.setAid(Aid);
		adminUser1.setApassword(MSUtil.md5(newPwd));
		
        Pattern Password_Pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(.{8,15})$");
        Matcher matcher = Password_Pattern.matcher(newPwd);
        if (matcher.matches()) {
        	System.out.println("密码格式正确");
        }else{
        	System.out.println("密码长度为8到20位,必须包含字母和数字，字母区分大小写");
        	return result;
        }
		adminDao.updateById(adminUser1);
		result.setStatus(0);
		result.setMsg("修改密码成功");
		return result;
	}

//	修改详细信息
	@Override
	public Result updateById(int Aid, String Aemal, String Zname, String phone, String sex) {
		AdminUser adminUser = adminDao.findById(Aid);
		if (adminUser==null) {
			result.setStatus(1);
			result.setMsg("不存在此管理");
			return result;
		}
		AdminUser adminUser1=new AdminUser();
		adminUser1.setAid(Aid);
		adminUser1.setAemal(Aemal);
		adminUser1.setZname(Zname);
		adminUser1.setPhone(phone);
		adminUser1.setSex(sex);
		
		Pattern regexMobile = Pattern.compile("\\d{11}");
        Matcher matcher = regexMobile.matcher(phone);
        if(matcher.matches()){
        	System.out.println("手机格式正确");
        }else{
        	System.out.println("手机必须为11位数字");
        	return result;
        }
  		adminDao.updateById(adminUser1);
  		
		result.setStatus(0);
		result.setMsg("修改信息成功");
		return result;

	}
	
	
}


















