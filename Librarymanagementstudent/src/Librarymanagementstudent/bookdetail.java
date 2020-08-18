package Librarymanagementstudent;

public class bookdetail {

	String bookname;
	String language;
	String catogory;
	String publishyear;
	String status;
	String buydate;
	String bookid;
	public bookdetail(String booknames, String language2, String catagory,
			String book) {
		
		this.bookname = booknames;
		this.language = language2;
		this.catogory = catagory;
		this.status = book;
		
	}
	public bookdetail(String booknames, String language2, String catagory,
			String publishyear2, String bookstatus, String bookid2) {
		
		this.bookname = booknames;
		this.language = language2;
		this.catogory = catagory;
		this.status = bookstatus;
		this.publishyear = publishyear2;
		this.bookid = bookid2;
	}
	public bookdetail(String bookname2, String language2, String buydate2) {

       this.bookname = bookname2;
       this.language = language2;
       this.buydate = buydate2;
		
		
	}
	public String getbookname(){
		return bookname;
	}
	public String getlanguage(){
		return language;
	}
	public String getcatogory(){
		return catogory;
	}
	public String getstatus(){
		return status;
	}
	public String getpublishyear(){
		return publishyear;
	}
	public String getbuydate(){
		return buydate;
	}
	public String getbookid(){
		return bookid;
	}
}
