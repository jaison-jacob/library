package Librarymanagementstudent;

public class bookstatus {

	boolean bookstatus;
	boolean bookavailablestatus;
	
	public bookstatus(boolean bookstatus2, boolean bookavailablestatus2) {
		
		this.bookstatus = bookstatus2;
		this.bookavailablestatus = bookavailablestatus2;
		
	}
	public boolean getbookstatus(){
		return bookstatus;
		
	}
	public boolean getbookavailablestatus(){
		return bookavailablestatus;
	}
}
