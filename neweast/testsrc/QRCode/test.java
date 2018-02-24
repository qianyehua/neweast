package QRCode;

import com.skyjoo.neweast.biz.common.page.Pagination;

public class test extends Pagination<test>{
   
	String name;
	Long password;
	Long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
