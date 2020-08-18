package Librarymanagementadmin;

public class Bookadd extends Admindata  {

	public Bookadd(String bookname2, String language2, String catagory,
			String publishdate2, String available, String bookid2) {
		this.bookname = bookname2;
		this.language = language2;
		this.catogory = catagory;
		this.publishdate = publishdate2;
		this.bookid = bookid2;
		this.status =available;
	}
	public Bookadd(String bookname2, String language2, String catagory,
			String publishdate2) {
		
		this.bookname = bookname2;
		this.language = language2;
		this.catogory = catagory;
		this.publishdate = publishdate2;
		
		
	}
	public Bookadd() {
		// TODO Auto-generated constructor stub
	}
	public Bookadd(String booknames, String languages, String catogory2,
			String publishyear, String status2, String bookid2,
			String studentname, String buydate, String returndate) {
	
		super(studentname,buydate,returndate);
		
		this.bookname = booknames;
		this.language = languages;
		this.catogory = catogory2;
		this.publishdate = catogory2;
		this.bookid = bookid2;
		this.status =status2;
		
		
		
	}
	String bookname;
	String language;
	String catogory;
	String publishdate;
	String bookid;
	String status;
	
	
	public String getbookname(){
		return bookname;
	}
	public String getlanguage(){
		return language;
	}
	public String getcatogory(){
		return catogory;
	}
	public String getpublishdate(){
		return publishdate;
	}
	public String getbookid(){
		return bookid;
	}
	public String getstatus(){
		return status;
	}
	
}
