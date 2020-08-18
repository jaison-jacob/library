package Librarymanagementadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class Sqlprocess{
	
	public ArrayList<Errors> addadmindata(Admindata data, String checkphoneno, ArrayList<Errors> error2) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		 
	     String checkerror = "false";
	     String usernameerror = "false";
	     String emailerror = "false";
		
		
	     //get connection
	     Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
		
		
		//make query
		
		String query1 = "select * from admin where username="+"'"+data.getusername()+"'";
		String query2 = "select * from admin where email="+"'"+data.getemail()+"'";
		
		System.out.println(query1);
		System.out.println(query2);
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query1);
		
		if(rs.next() == true ){
			usernameerror = "true";
		}
	   
		
		stmt = (Statement) con.createStatement();
	    rs = stmt.executeQuery(query2);
		if(rs.next() == true || data.getemail().contains("@")==false){
			emailerror = "true";
		}
	
			
		if(usernameerror.equalsIgnoreCase("false") && emailerror.equalsIgnoreCase("false") ){
			
		String query = "insert into admin value('"+data.getname()+"'"+","+"'"+data.getusername()+"'"+","+"'"+data.getpassword()+"'"+","+"'"+data.getphoneno()+"'"+","+"'"+data.getaddress()+"'"+","+"'"+data.getemail()+"')";
		System.out.println(query);
		
		 if(data.getname().isEmpty() || data.getusername().isEmpty() || data.getpassword().isEmpty() || data.getphoneno().isEmpty() || data.getaddress().isEmpty() || data.getemail().isEmpty()){
		
		checkerror = "true";
		
			}else{
				 stmt = (Statement) con.createStatement();
				 stmt.execute(query);
			}
		}
		
		Errors error = new Errors(checkphoneno,usernameerror,emailerror,checkerror);
		System.out.println("check error :"+ error.checkerror);
		System.out.println("check phoneno :"+ error.phonenoerror);
		System.out.println("check username"+ error.usernameerror);
		System.out.println("check email"+ error.emailerror);
		error2.add(error);
		
		con.close();
		return error2;
	}

	public String login(Admindata data) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		String passworderror = "false";
		
Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
		
		String query1 = "select * from admin where username="+"'"+data.getusername()+"'"+"and"+" "+"password="+"'"+data.getpassword()+"'";
		
		
		
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query1);
		if(rs.next() == false){
			passworderror = "true";
		}
		
		
		con.close();
		return passworderror;
	}

	public ArrayList<Errors> bookadd(Bookadd add, ArrayList<Errors> error) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String booknameerror = "false";
	    String dateformateerror = "false";
	    String checkerror = "false";
	    int bookidcount = 0;
	    String bookid = null;
	    boolean languagecheck = false;
	    if(!add.bookname.isEmpty() && !add.language.isEmpty() && !add.catogory.isEmpty() && !add.publishdate.isEmpty()){
	    	int year = Calendar.getInstance().get(Calendar.YEAR);
		    if(Integer.parseInt(add.publishdate) <= year){
		    	dateformateerror="false";
		    }else{
		    	dateformateerror = "true";
		    }
		    
		    //get connection
		    
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
			
			
 //generate book id
			String query2 = "select * from books";
		    Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query2);
			
			while(rs.next()){
				bookidcount++;
			}
		    
			 bookid = add.bookname+bookidcount+"";
			
			
			
			
		    
		    //check booname error
		    
		    String query = "select * from books where bookname="+"'"+add.bookname+"'";
		    String query1 = "insert into books (bookname,bookid,language,catogory,publishyear) value('"+add.bookname+"'"+","+"'"+bookid+"',"+"'"+add.language+"'"+","+"'"+add.catogory+"'"+","+"'"+add.publishdate+"')";
		    
		    System.out.println(query1);
		    
		 
		     stmt = (Statement) con.createStatement();
			 rs = stmt.executeQuery(query);
			while(rs.next()){
				String language = rs.getString(3);
				if(language.equalsIgnoreCase(add.language)){
					languagecheck = true;
					 booknameerror = "true";
				     
					break;
				}
			}
			if(languagecheck == false && dateformateerror.equalsIgnoreCase("false") ){
				System.out.println(query1); 
				stmt = (Statement) con.createStatement();
				stmt.execute(query1);
			}
	    	
	    }else{
	    	checkerror = "true";
	    }
	    
			Errors errordata = new Errors(booknameerror,dateformateerror,checkerror);
			error.add(errordata);
		
		
		return error;
	}

	public ArrayList<Bookadd> viewbooks(ArrayList<Bookadd> booklist) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
		
		String query = "select * from books";
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			String bookname = rs.getString(1);
			String bookid = rs.getString(2);
			String language = rs.getString(3);
			String catogory = rs.getString(4);
			String publishyear = rs.getString(5);
			String available = rs.getString(6);
			Bookadd book = new Bookadd(bookname,language,catogory,publishyear,available,bookid);
			booklist.add(book);
		}
		
		return booklist;
	}

	public void searchbook(ArrayList<Bookadd> booklist,
			ArrayList<Admindata> admindata, String bookname, String language, String checkerror, ArrayList<Errors> error, String catagory, String publishyear2) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		


String booknames = null;
String languages = null;
String catogory = null;
String publishyear = null;
String bookid= null;
String status = null;

String studentname = null;
String buydate = null;
String returndate= null;

if(language.isEmpty() && catagory.isEmpty() && publishyear2.isEmpty()){
	Class.forName("com.mysql.jdbc.Driver").newInstance();

	Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
	
	
	String query = "select * from books where bookname='"+bookname+"'";
	String query1 = "select * from bookbuy where bookname='"+bookname+"'";
	System.out.println(query);
	
	Statement stmt = (Statement) con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	if(rs.next()){
		 booknames = rs.getString(1);
		 languages = rs.getString(3);
		 catogory = rs.getString(4);
		 publishyear = rs.getString(5);
		 bookid = rs.getString(2);
		 status = rs.getString(6);
		
	}
	
	 stmt = (Statement) con.createStatement();
	 rs = stmt.executeQuery(query1);
	while(rs.next()){
		 studentname = rs.getString(5);
		 buydate = rs.getString(9);
		 returndate= rs.getString(10);
		
	}
	Bookadd datas = new Bookadd(booknames,languages,catogory,publishyear,status,bookid,studentname,buydate,returndate);
	booklist.add(datas);
	con.close();
	
	
}
	else if(bookname.isEmpty() && catagory.isEmpty() && publishyear2.isEmpty()){
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
		
		
		String query = "select * from books where language='"+language+"'";
		String query1 = "select * from bookbuy where language='"+language+"'";
		System.out.println(query);
		
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){
			 booknames = rs.getString(1);
			 languages = rs.getString(3);
			 catogory = rs.getString(4);
			 publishyear = rs.getString(5);
			 bookid = rs.getString(2);
			 status = rs.getString(6);
			
		}
		
		 stmt = (Statement) con.createStatement();
		 rs = stmt.executeQuery(query1);
		while(rs.next()){
			 studentname = rs.getString(5);
			 buydate = rs.getString(9);
			 returndate= rs.getString(10);
			
		}
		Bookadd datas = new Bookadd(booknames,languages,catogory,publishyear,status,bookid,studentname,buydate,returndate);
		booklist.add(datas);
		con.close();
		
		
		
	}
		else if(language.isEmpty() && bookname.isEmpty() && publishyear2.isEmpty()){
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
			
			
			String query = "select * from books where catogory='"+catagory+"'";
			String query1 = "select * from bookbuy where catagory='"+catagory+"'";
			System.out.println(query);
			
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				 booknames = rs.getString(1);
				 languages = rs.getString(3);
				 catogory = rs.getString(4);
				 publishyear = rs.getString(5);
				 bookid = rs.getString(2);
				 status = rs.getString(6);
				
			}
			
			 stmt = (Statement) con.createStatement();
			 rs = stmt.executeQuery(query1);
			while(rs.next()){
				 studentname = rs.getString(5);
				 buydate = rs.getString(9);
				 returndate= rs.getString(10);
				
			}
			Bookadd datas = new Bookadd(booknames,languages,catogory,publishyear,status,bookid,studentname,buydate,returndate);
			booklist.add(datas);
			con.close();
			
		}
			else if(language.isEmpty() && catagory.isEmpty() && bookname.isEmpty()){
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
				
				
				String query = "select * from books where publishyear='"+publishyear2+"'";
				String query1 = "select * from bookbuy where publishyear='"+publishyear2+"'";
				System.out.println(query);
				
				Statement stmt = (Statement) con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()){
					 booknames = rs.getString(1);
					 languages = rs.getString(3);
					 catogory = rs.getString(4);
					 publishyear = rs.getString(5);
					 bookid = rs.getString(2);
					 status = rs.getString(6);
					
				}
				
				 stmt = (Statement) con.createStatement();
				 rs = stmt.executeQuery(query1);
				while(rs.next()){
					 studentname = rs.getString(5);
					 buydate = rs.getString(9);
					 returndate= rs.getString(10);
					
				}
				Bookadd datas = new Bookadd(booknames,languages,catogory,publishyear,status,bookid,studentname,buydate,returndate);
				booklist.add(datas);
				con.close();
				
			}
				else if(catagory.isEmpty() && publishyear2.isEmpty()){
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();

					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
					
					
					String query = "select * from books where bookname='"+bookname+"' and language = '"+language+"'";
					String query1 = "select * from bookbuy where bookname='"+bookname+"' and language ='"+language+"'";
					System.out.println(query);
					
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					if(rs.next()){
						 booknames = rs.getString(1);
						 languages = rs.getString(3);
						 catogory = rs.getString(4);
						 publishyear = rs.getString(5);
						 bookid = rs.getString(2);
						 status = rs.getString(6);
						
					}
					
					 stmt = (Statement) con.createStatement();
					 rs = stmt.executeQuery(query1);
					while(rs.next()){
						 studentname = rs.getString(5);
						 buydate = rs.getString(9);
						 returndate= rs.getString(10);
						
					}
					Bookadd datas = new Bookadd(booknames,languages,catogory,publishyear,status,bookid,studentname,buydate,returndate);
					booklist.add(datas);
					con.close();
					
				}
					else if(!language.isEmpty() && !catagory.isEmpty() && !bookname.isEmpty() && !publishyear2.isEmpty()){
						
						Class.forName("com.mysql.jdbc.Driver").newInstance();

						Connection con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
						
						
						String query = "select * from books where bookname='"+bookname+"' and language = '"+language+"' and catogory ='"+catagory+"' and publishyear = '"+publishyear2+"'";
						String query1 = "select * from bookbuy where bookname='"+bookname+"' and language ='"+language+"' and catagory ='"+catagory+"' and publishyear ='"+publishyear2+"'";
						System.out.println(query);
						
						Statement stmt = (Statement) con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						if(rs.next()){
							 booknames = rs.getString(1);
							 languages = rs.getString(3);
							 catogory = rs.getString(4);
							 publishyear = rs.getString(5);
							 bookid = rs.getString(2);
							 status = rs.getString(6);
							
						}
						
						 stmt = (Statement) con.createStatement();
						 rs = stmt.executeQuery(query1);
						while(rs.next()){
							 studentname = rs.getString(5);
							 buydate = rs.getString(9);
							 returndate= rs.getString(10);
							
						}
						Bookadd datas = new Bookadd(booknames,languages,catogory,publishyear,status,bookid,studentname,buydate,returndate);
						booklist.add(datas);
						con.close();
						
					}
						else if(!language.isEmpty() && !catagory.isEmpty() && !bookname.isEmpty() && publishyear2.isEmpty()){
							
							Class.forName("com.mysql.jdbc.Driver").newInstance();

							Connection con = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
							
							
							String query = "select * from books where bookname='"+bookname+"' and language = '"+language+"' and catogory ='"+catagory+"'";
							String query1 = "select * from bookbuy where bookname='"+bookname+"' and language ='"+language+"' and catagory ='"+catagory+"'";
							System.out.println(query);
							
							Statement stmt = (Statement) con.createStatement();
							ResultSet rs = stmt.executeQuery(query);
							if(rs.next()){
								 booknames = rs.getString(1);
								 languages = rs.getString(3);
								 catogory = rs.getString(4);
								 publishyear = rs.getString(5);
								 bookid = rs.getString(2);
								 status = rs.getString(6);
								
							}
							
							 stmt = (Statement) con.createStatement();
							 rs = stmt.executeQuery(query1);
							while(rs.next()){
								 studentname = rs.getString(5);
								 buydate = rs.getString(9);
								 returndate= rs.getString(10);
								
							}
							Bookadd datas = new Bookadd(booknames,languages,catogory,publishyear,status,bookid,studentname,buydate,returndate);
							booklist.add(datas);
							con.close();
							
							
						}


	}

	public void studentlist(ArrayList<Admindata> admindata) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
		
		
		String query = "select * from student";
		
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			
			String name = rs.getString(1);
			String phoneno = rs.getString(4);
			String address = rs.getString(5);
			String email = rs.getString(6);
			
			Admindata data = new Admindata(name,phoneno,address,email);
			admindata.add(data);
			
		}
		con.close();
	}

	public void searchstudent(ArrayList<Errors> error,
			ArrayList<Admindata> admindata, String name, String checkerror2) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/librarymanagement", "root", "");
		
		
		String matchingerror = "true";
		String query = "select * from student where name ='"+name+"'";
		
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){
			matchingerror = "false";
		}
		
		 stmt = (Statement) con.createStatement();
		 rs = stmt.executeQuery(query);
        while(rs.next()){
			
			
			String phoneno = rs.getString(4);
			String address = rs.getString(5);
			String email = rs.getString(6);
			
			Admindata data = new Admindata(name,phoneno,address,email);
			admindata.add(data);
			
		}
        
        Errors data = new Errors(checkerror2,matchingerror);
        error.add(data);
	}

}
