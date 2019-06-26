package design.hellofood.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import design.hellofood.admin.service.AdminService;
import design.hellofood.admin.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Controller层业务实现
 * @author HelloFood
 */
@Controller
@RequestMapping("/admin")
public class AdminsController {
	
	@Resource
	private AdminService adminService;
	
//	管理员注册
	@ApiOperation("管理员注册")
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	@ResponseBody
	public Result regist(@ApiParam("管理名")@RequestParam("Aname")String Aname,
			@ApiParam("密码")@RequestParam("Apassword")String Apassword){
		System.out.println("Aname:"+Aname);
		System.out.println("Apassword"+Apassword);
		Result result = adminService.registAdmin(Aname, Apassword);
		return result;
	}
	
//	管理员登陆
	@ApiOperation("管理员登陆")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Result login(@ApiParam("管理名")@RequestParam("Aname")String Aname,
			@ApiParam("密码")@RequestParam("Apassword")String Apassword){
		System.out.println("Aname:"+Aname);
		System.out.println("Apassword"+Apassword);
		Result result = adminService.AdminLogin(Aname, Apassword);
		return result;
	}
	
//	删除管理员
	@ApiOperation("删除管理员")
	@RequestMapping(value="/delete/{Aid}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result delete(@ApiParam("管理员Id")@RequestParam("Aid")int Aid){
		System.out.println("Id为："+Aid+"的管理员已被删除");
		Result result = adminService.DeleteAdmin(Aid);
		return result;
	}
	
//	修改管理员密码
	@ApiOperation("修改管理员密码")
	@RequestMapping(value="/updatePwd/{Aid}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updatePwd(@ApiParam("管理员Id")@RequestParam("Aid")int Aid,
			@ApiParam("原密码")@RequestParam("oldPwd")String oldPwd,
			@ApiParam("新密码")@RequestParam("newPwd")String newPwd){
		Result result = adminService.updatePwd(Aid, oldPwd, newPwd);
		return result;
	}
	
//	根据id更新管理员基本信息
	@ApiOperation("更新管理员基本信息")
	@RequestMapping(value="/updateAdmin/{Aid}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateAdmin(@ApiParam("管理员Id")@RequestParam("Aid")int Aid,
			@ApiParam("管理员邮箱")@RequestParam("Aemal")String Aemal,
			@ApiParam("管理员身份")@RequestParam("Zname")String Zname,
			@ApiParam("管理员电话")@RequestParam("phone")String phone,
			@ApiParam("管理员性别")@RequestParam("sex")String sex){
		Result result = adminService.updateById(Aid, Aemal, Zname, phone, sex);
		return result;
	}
	
//	查询管理员
	@ApiOperation("查询管理员")
	@RequestMapping(value="/findById/{Aid}",method=RequestMethod.GET)
	@ResponseBody
	public Result findById(@ApiParam("管理员Id")@RequestParam("Aid")int Aid){
		Result result = adminService.loadAdminById(Aid);
		return result;
	}
	
	@ApiOperation("查询所有管理员")
	@RequestMapping(value="/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	public Result findAll(@ApiParam("查询第几页")@RequestParam("pageId")@PathVariable("pageId")int pageId){
		Result result = adminService.findAll(pageId);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
