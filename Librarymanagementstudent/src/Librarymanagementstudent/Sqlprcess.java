package Librarymanagementstudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Sqlprcess {

	public ArrayList<Errors> adddetail(ArrayList<Errors> data,
			String name, String password, String phoneno, String address,
			String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		boolean phonenoerror = false;
		boolean emailerror = false;
		boolean checkerror = false;
		String userid = null;
		int useridcount = 0;
		//get connection
		
Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
		
		//make query
		String query1 = "select * from student";
		String query2= "select * from student where email="+"'"+email+"'";
	    
	    
	    System.out.println(query1);
	    System.out.println(query2);
	    
	    
	    //generate userid
	    Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query1);
		
		while(rs.next()){
			useridcount++;
		}
		userid = name+useridcount+"";
		System.out.println(userid);
		String query3 = "insert into student value('"+name+"'"+","+"'"+userid+"',"+"'"+password+"'"+","+"'"+phoneno+"'"+","+"'"+address+"',"+"'"+email+"')";
	    //check phoneno errors
	    if(phoneno.length() != 10){
	    	phonenoerror = true;
	    }
	    
	    //check email id error
	     stmt = (Statement) con.createStatement();
		 rs = stmt.executeQuery(query2);
	    
		if(rs.next()){
			emailerror = true;
		}
		
		//check all data is fill or not
		
		if(name.isEmpty() || password.isEmpty() || phoneno.isEmpty() || address.isEmpty() || email.isEmpty()){
			checkerror = true;
		}
		
		//insert data
		if(phonenoerror == false && emailerror == false && checkerror == false){
			
			 stmt = (Statement) con.createStatement();
			 stmt.execute(query3);
			 
		}
		
		Errors errordata = new Errors(phonenoerror,emailerror,checkerror,userid);
		data.add(errordata);
		con.close();
		return data;
	}

	public boolean studentlogin(String userid, String password,
			boolean checkerror, boolean matchingerror) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	
		//get connection
Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
		
		//make query
		String query = "select * from student where userid="+"'"+userid+"'"+" "+"and"+" "+"password="+"'"+password+"'";
		System.out.println(query);
		
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		if(rs.next() == false){
			matchingerror = true;
		}else{
			
			query = "update useridupdate set userid ='"+userid+"'"+" "+"where checks='checkpoint'";
			System.out.println(query);
			stmt = (Statement) con.createStatement();
			stmt.execute(query);
			
		}
		
		return matchingerror;
	}

	public ArrayList<Librarymanagementstudent.bookstatus> bookstatus(
			ArrayList<bookstatus> status, String bookname, ArrayList<bookdetail> bookdata, String language2, String catagory2, String publishyear2) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		boolean bookavailablestatus = false;
		boolean bookstatus = true;
		
		//get connection
		Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
				
		
		if(language2.isEmpty() && catagory2.isEmpty() && publishyear2.isEmpty()){
		//make query
		String query = "select * from books where bookname ='"+bookname+"'";
		System.out.println(query);
		
		//execute query
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			String booknames = rs.getString(1);
			String language = rs.getString(3);
			String catagory = rs.getString(4);
			String available =  rs.getString(6);
			String bookid = rs.getString(2);
			String publishyear = rs.getString(5); 
			bookstatus = false;
			
				
				bookdetail data = new bookdetail(booknames,language,catagory,publishyear,available,bookid);
				bookdata.add(data);
				bookavailablestatus = true;
			
			
			
			
					}
		
		}else if(bookname.isEmpty() && catagory2.isEmpty() && publishyear2.isEmpty()){
			
			//make query
			String query = "select * from books where language ='"+language2+"'";
			System.out.println(query);
			
			//execute query
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String booknames = rs.getString(1);
				String language = rs.getString(3);
				String catagory = rs.getString(4);
				String available =  rs.getString(6);
				String bookid = rs.getString(2);
				String publishyear = rs.getString(5); 
				bookstatus = false;
				
					
					bookdetail data = new bookdetail(booknames,language,catagory,publishyear,available,bookid);
					bookdata.add(data);
					bookavailablestatus = true;
				
				
				
				
						}
			
				
				
				
						
			
		}else if(language2.isEmpty() && bookname.isEmpty() && publishyear2.isEmpty()){
			
			
			//make query
			String query = "select * from books where catogory ='"+catagory2+"'";
			System.out.println(query);
			
			//execute query
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String booknames = rs.getString(1);
				String language = rs.getString(3);
				String catagory = rs.getString(4);
				String available =  rs.getString(6);
				String bookid = rs.getString(2);
				String publishyear = rs.getString(5); 
				bookstatus = false;
				
					
					bookdetail data = new bookdetail(booknames,language,catagory,publishyear,available,bookid);
					bookdata.add(data);
					bookavailablestatus = true;
				
				
				
				
						}
			
			
			
		}else if(language2.isEmpty() && catagory2.isEmpty() && bookname.isEmpty()){
			
			//make query
			String query = "select * from books where publishyear ='"+publishyear2+"'";
			System.out.println(query);
			
			//execute query
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String booknames = rs.getString(1);
				String language = rs.getString(3);
				String catagory = rs.getString(4);
				String available =  rs.getString(6);
				String bookid = rs.getString(2);
				String publishyear = rs.getString(5); 
				bookstatus = false;
				
					
					bookdetail data = new bookdetail(booknames,language,catagory,publishyear,available,bookid);
					bookdata.add(data);
					bookavailablestatus = true;
				
				
				
				
						}
			
			
			
		}else if(catagory2.isEmpty() && publishyear2.isEmpty()){
			
			//make query
			String query = "select * from books where bookname ='"+bookname+"'"+" and language ='"+language2+"'";
			System.out.println(query);
			
			//execute query
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String booknames = rs.getString(1);
				String language = rs.getString(3);
				String catagory = rs.getString(4);
				String available =  rs.getString(6);
				String bookid = rs.getString(2);
				String publishyear = rs.getString(5); 
				bookstatus = false;
				
					
					bookdetail data = new bookdetail(booknames,language,catagory,publishyear,available,bookid);
					bookdata.add(data);
					bookavailablestatus = true;
				
				
				
				
						}
			
			
			
		}else if(!language2.isEmpty() && !catagory2.isEmpty() && !bookname.isEmpty() && !publishyear2.isEmpty()){
			
			
			
			//make query
			String query = "select * from books where bookname ='"+bookname+"'"+" and language ='"+language2+"'"+" and catogory ='"+catagory2+"'"+" and publishyear ='"+publishyear2+"'";
			System.out.println(query);
			
			//execute query
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String booknames = rs.getString(1);
				String language = rs.getString(3);
				String catagory = rs.getString(4);
				String available =  rs.getString(6);
				String bookid = rs.getString(2);
				String publishyear = rs.getString(5); 
				bookstatus = false;
				
					
					bookdetail data = new bookdetail(booknames,language,catagory,publishyear,available,bookid);
					bookdata.add(data);
					bookavailablestatus = true;
				
				
				
				
						}
			
			
		}else if(!language2.isEmpty() && !catagory2.isEmpty() && !bookname.isEmpty() && publishyear2.isEmpty()){
			
			//make query
			String query = "select * from books where bookname ='"+bookname+"'"+" and language ='"+language2+"'"+" and catogory ='"+catagory2+"'";
			System.out.println(query);
			
			//execute query
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String booknames = rs.getString(1);
				String language = rs.getString(3);
				String catagory = rs.getString(4);
				String available =  rs.getString(6);
				String bookid = rs.getString(2);
				String publishyear = rs.getString(5); 
				bookstatus = false;
				
					
					bookdetail data = new bookdetail(booknames,language,catagory,publishyear,available,bookid);
					bookdata.add(data);
					bookavailablestatus = true;
			
		}
		}
		bookstatus object = new bookstatus(bookstatus,bookavailablestatus);
		status.add(object);
		
		con.close();
		return status;
	}

	public void booklist(ArrayList<bookdetail> bookdata) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		//get connection
				Class.forName("com.mysql.jdbc.Driver").newInstance();
						
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
						
				
				
				//make query
				String query = "select * from books";
				System.out.println(query);
				
				//execute query
				Statement stmt = (Statement) con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()){
					String booknames = rs.getString(1);
					String bookid = rs.getString(2);
					String language = rs.getString(3);
					String catagory = rs.getString(4);
					String available =  rs.getString(6);
					String publishyear = rs.getString(5);
					
						
						bookdetail data = new bookdetail(booknames,language,catagory,publishyear,available,bookid);
						bookdata.add(data);
						
					
					
				}
		
	}

	public void bookbuy(String bookid) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		//get connection
		Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
				
				//make query
				String query = "select * from books where bookid="+"'"+bookid+"'";
				System.out.println(query);
				
				Statement stmt = (Statement) con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
		
				if(rs.next()){
					
					String booknames = rs.getString(1);
					String bookid1 = rs.getString(2);
					String languages = rs.getString(3);
					String catogary = rs.getString(4);
					String publishyear = rs.getString(5);
					String available = rs.getString(6);
					
					
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
					    Date date = new Date();  
					    String dates = formatter.format(date);
					    String userid = null;
					    String query1 = "select * from useridupdate";
					    String name = null;
					    String phoneno = null;
					    String address = null;
					    String email = null;
					    
					    stmt = (Statement) con.createStatement();
						rs = stmt.executeQuery(query1);
						if(rs.next()){
							userid = rs.getString(1);
						}
						String query2 = "select * from student where userid ='"+userid+"'";
						
						stmt = (Statement) con.createStatement();
						rs = stmt.executeQuery(query2);
						if(rs.next()){
							
							name = rs.getString(1);
							phoneno = rs.getString(4);
							address = rs.getString(5);
							email = rs.getString(6);
							
						}
						String query3 = "insert into bookbuy(bookname,language,catagory,publishyear,studentname,studentphoneno,studentaddress,studentemail,buydate,bookid) values ('"+booknames+"',"+"'"+languages+"',"+
						"'"+catogary+"',"+"'"+publishyear+"',"+"'"+name+"',"+"'"+phoneno+"',"+"'"+address+"',"+"'"+email+"',"+"'"+dates+"','"+bookid+"')";
						System.out.println(query3);
						stmt = (Statement) con.createStatement();
						stmt.execute(query3);
						
						String query4 = "update books set bookstatus = 'not available'"+" "+"where bookid='"+bookid+"'";
						System.out.println(query4);
						
						stmt = (Statement) con.createStatement();
					    stmt.execute(query4);
					
					
				}
				
	}

	public void viewstatus(ArrayList<bookdetail> bookdata) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		//get connection
				Class.forName("com.mysql.jdbc.Driver").newInstance();
						
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
			
		//make query
						String query = "select * from useridupdate ";
						String userid = null;
						String name = null;
						Statement stmt = (Statement) con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						
						if(rs.next()){
							 userid = rs.getString(1);
						}
                       String query1 = "select * from student where userid ='"+userid+"'";
						
						stmt = (Statement) con.createStatement();
						rs = stmt.executeQuery(query1);
						if(rs.next()){
							
							name = rs.getString(1);
							
							
						}
						String query2 ="select * from bookbuy where studentname='"+name+"'"+" "+"and"+" "+"returndate= 'null'";
						
						stmt = (Statement) con.createStatement();
						rs = stmt.executeQuery(query2);
						
						while(rs.next()){
							
							String bookname = rs.getString(1);
							String language = rs.getString(2);
							String buydate = rs.getString(9);
							String returndate = rs.getString(10);
							if(returndate.equalsIgnoreCase("null")){
								bookdetail data = new bookdetail(bookname,language,buydate);
								bookdata.add(data);
							}
							
						}
						
						con.close();
	}

	public void bookreturn(ArrayList<Errors> data, String bookname, String language, boolean checkerror) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		//get connection
		Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
	
		
				//make query
				String query = "select * from bookbuy where bookname='"+bookname+"'"+" "+"and"+" "+"language='"+language+"'"+" "+"and returndate='null'";
				System.out.println(query);
				
				boolean matchingerror = true;
				
				Statement stmt = (Statement) con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				if(rs.next()){
					
					matchingerror = false;
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
				    Date date = new Date();  
				    String dates = formatter.format(date);
				    
				    
				    String query2 = "update bookbuy set returndate = '"+dates+"'"+" where bookname='"+bookname+"'"+" "+"and"+" "+"language='"+language+"'";
				    String query3 = "update books set bookstatus = 'available'"+" "+"where bookname='"+bookname+"'"+" "+"and"+" "+"language='"+language+"'";
					
					System.out.println(query2);
					System.out.println(query3);
					
					stmt = (Statement) con.createStatement();
				    stmt.execute(query2);
				    
				    stmt = (Statement) con.createStatement();
				    stmt.execute(query3);
					
				}
				
				Errors error = new Errors(matchingerror,checkerror);
				data.add(error);
		
	}

	

	
	
}
