package design.hellofood.admin.service;

import design.hellofood.admin.util.Result;

public interface AdminService {
	//	注册
	public Result registAdmin(String Aname,String Apassword);
	//登陆验证
	public Result AdminLogin(String Aname,String Apassword);
	//根据ID删除
	public Result DeleteAdmin(int Aid);
	//根据Id查询管理
	public Result loadAdminById(int Aid);
	//分页查询所有管理
	public Result findAll(int current);
	//根据Id修改密码
	public Result updatePwd(int Aid,String oldPwd,String newPwd);
	//根据Id修改详细信息
	public Result updateById(int Aid,String Aemal,String Zname,String phone,String sex);
}
