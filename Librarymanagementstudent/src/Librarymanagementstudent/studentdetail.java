package Librarymanagementstudent;

public class studentdetail {

	String name;
	String userid;
	String password;
	String phoneno;
	String address;
	String email;

	public studentdetail(String userid2) {

		this.userid = userid2;
	}

	public String getname() {
		return name;
	}

	public String getuserid() {
		return userid;
	}

	public String getpassword() {
		return password;
	}

	public String getphoneno() {
		return phoneno;
	}

	public String getaddress() {
		return address;
	}

	public String getemail() {
		return email;
	}

}
