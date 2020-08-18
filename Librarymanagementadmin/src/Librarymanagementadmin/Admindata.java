package Librarymanagementadmin;

public class Admindata {

	private String name;
	private String username;
	private String password;
	private String phoneno;
	private String address;
	private String email;
	private String buydate;
	private String returndate;
	public Admindata(String name2, String username2, String password2,
			String phoneno2, String address2,String email2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		this.username = username2;
		this.password = password2;
		this.phoneno = phoneno2;
		this.address = address2;
		this.email = email2;
	}
	
	public Admindata() {
		// TODO Auto-generated constructor stub
	}
	public Admindata(String username2, String password2) {
		 this.username = username2;
		 this.password = password2;
		
	}

	public Admindata(String studentname) {
		
		this.name = studentname;
	}

	public Admindata(String name2, String phoneno2, String address2,
			String email2) {
		
		this.name = name2;
		this.phoneno = phoneno2;
		this.address = address2;
		this.email = email2;
		
	}

	public Admindata(String studentname, String buydate, String returndate) {
		
		this.name = studentname;
		this.buydate = buydate;
		this.returndate = returndate;
		
	}

	public String getname(){
		return this.name;
	}
	public String getusername(){
		return this.username;
	}
	public String getpassword(){
		return this.password;
	}
	public String getaddress(){
		return this.address;
	}
	public String getphoneno(){
		return this.phoneno;
	}
	public String getemail(){
		return this.email;
	}
	public String  getbuydate(){
		return this.buydate;
	}
	public String getreturndate(){
		return this.returndate;
	}
	
	
}
