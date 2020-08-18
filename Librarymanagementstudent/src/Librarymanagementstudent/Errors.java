package Librarymanagementstudent;

public class Errors {

	boolean phonenoerror;
	boolean emailerror;
	boolean checkerror;
	String userid;
	boolean matchingerror;
	
	
	public Errors(boolean phonenoerror2, boolean emailerror2, boolean checkerror2,String userid2) {
		this.phonenoerror = phonenoerror2;
		this.emailerror = emailerror2;
		this.checkerror = checkerror2; 
		this.userid = userid2;
	}
	public Errors(boolean checkerror2) {
		// TODO Auto-generated constructor stub
		checkerror = checkerror2;
	}
	public Errors(boolean matchingerror2, boolean checkerror2) {
		this.matchingerror = matchingerror2;
		this.checkerror = checkerror2;
	}
	public boolean getphoneno(){
		return phonenoerror;
	}
	public boolean geytemailerror(){
		return emailerror;
	}
	public boolean getcheckerror(){
		return checkerror;
	}
	public String getuserid(){
		return userid;
	}
	public boolean getmatchingerror(){
		return matchingerror;
	}
	
}
