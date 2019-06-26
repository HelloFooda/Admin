package design.hellofood.admin.entity;

import java.sql.Timestamp;

import design.hellofood.admin.entity.brief.BriefAdmin;

public class AdminUser {
	private Integer Aid;
	private String Aname;
	private String Apassword;
	private String Aemal;
	private String Zname;
	private Timestamp Changetime;
	private Timestamp Creationtime;
	private Integer Cid;
	private String phone;
	private String sex;
//	关联查询
	private BriefAdmin briefAdmin;
	
	public BriefAdmin getBriefAdmin() {
		return briefAdmin;
	}
	public void setBriefAdmin(BriefAdmin briefAdmin) {
		this.briefAdmin = briefAdmin;
	}
	
	
	public Integer getAid() {
		return Aid;
	}
	public void setAid(Integer aid) {
		Aid = aid;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public String getApassword() {
		return Apassword;
	}
	public void setApassword(String apassword) {
		Apassword = apassword;
	}
	public String getAemal() {
		return Aemal;
	}
	public void setAemal(String aemal) {
		Aemal = aemal;
	}
	public String getZname() {
		return Zname;
	}
	public void setZname(String zname) {
		Zname = zname;
	}
	public Timestamp getChangetime() {
		return Changetime;
	}
	public void setChangetime(Timestamp changetime) {
		Changetime = changetime;
	}
	public Timestamp getCreationtime() {
		return Creationtime;
	}
	public void setCreationtime(Timestamp creationtime) {
		Creationtime = creationtime;
	}
	public Integer getCid() {
		return Cid;
	}
	public void setCid(Integer cid) {
		Cid = cid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "AdminUser [Aid=" + Aid + ", Aname=" + Aname + ", Apassword=" + Apassword + ", Aemal=" + Aemal
				+ ", Zname=" + Zname + ", Changetime=" + Changetime + ", Creationtime=" + Creationtime + ", Cid=" + Cid
				+ ", phone=" + phone + ", sex=" + sex + ", briefAdmin=" + briefAdmin + "]";
	}
	
	
	
}
