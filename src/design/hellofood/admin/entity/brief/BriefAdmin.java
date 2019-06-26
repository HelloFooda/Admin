package design.hellofood.admin.entity.brief;

import java.io.Serializable;
import java.sql.Timestamp;

public class BriefAdmin implements Serializable{
	private Integer Cid;
	private	String Cname;
	private String Cdescription;
	private Timestamp Changetime;
	private Timestamp Creationtime;
	
	public Integer getCid() {
		return Cid;
	}
	public void setCid(Integer cid) {
		Cid = cid;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCdescription() {
		return Cdescription;
	}
	public void setCdescription(String cdescription) {
		Cdescription = cdescription;
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
	@Override
	public String toString() {
		return "BriefAdmin [Cid=" + Cid + ", Cname=" + Cname + ", Cdescription=" + Cdescription + ", Changetime="
				+ Changetime + ", Creationtime=" + Creationtime + "]";
	}

	
}
