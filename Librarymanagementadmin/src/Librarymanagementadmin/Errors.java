package Librarymanagementadmin;

public class Errors {

	String usernameerror;
	String phonenoerror;
	String checkerror;
	String emailerror;
	String passworderror;
	String yearerror;
	String booknameerror;
	String matchingerror;
	
	
	public Errors(String checkphoneno, String usernameerror2, String emailerror, String checkerror2){
		this.usernameerror = usernameerror2;
		this.phonenoerror = checkphoneno;
		this.checkerror = checkerror2;
		this.emailerror = emailerror;
		
	}
	
	public Errors(){
		
	}
	public Errors(String passworderror) {
		this.passworderror = passworderror;
	}

	public Errors(String booknameerror2, String dateformateerror,String checkerror ) {
		this.booknameerror = booknameerror2;
		this.yearerror = dateformateerror;
		this.checkerror = checkerror;
	}

	public Errors(String checkerror2, String string) {
		// TODO Auto-generated constructor stub
		this.checkerror =checkerror2;
		this.matchingerror =string;
	}

	public String getusername(){
		return usernameerror;
	}
	public String getphoneno(){
		return phonenoerror;
	}
	public String getcheckerror(){
		return checkerror;
	}
	public String getemailerror(){
		return emailerror;
	}
	public String getpassworderror(){
		return this.passworderror;
	}
	public String getbooknameerror(){
		return this.booknameerror;
	}
	public String getyearerror(){
		return this.yearerror;
	}
	public String getmatchingerror(){
		return this.matchingerror;
	}
}
