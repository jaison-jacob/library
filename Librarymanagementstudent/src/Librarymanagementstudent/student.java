package Librarymanagementstudent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class student
 */
//@WebServlet("/student")
public class student extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public student() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("index.html")
		.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String switchkey = request.getParameter("page");
		System.out.println(switchkey);
		ArrayList<Errors> data = new ArrayList<Errors>();
		ArrayList<studentdetail> studentdata = new ArrayList<studentdetail>();
		Sqlprcess process = new Sqlprcess();
		ArrayList<bookdetail> bookdata = new ArrayList<bookdetail>();
		ArrayList <bookstatus> status = new ArrayList <bookstatus>();
		
		if(switchkey.equalsIgnoreCase("adminregister")){
			
			//get studentdetail from regisration form 
			String name = request .getParameter("register name");
			String password =String.valueOf(request.getParameter("register password"));
			String phoneno =String.valueOf(request.getParameter("register phoneno"));
			String address = String.valueOf(request.getParameter("register address"));
			String email = String.valueOf(request.getParameter("register email"));
			
			//add detail to database
			try {
				data = process.adddetail(data,name,password,phoneno,address,email);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
			request.setAttribute("errors",data);
			request.getRequestDispatcher("errorfile.jsp")
			.include(request, response);
		}else if(switchkey.equalsIgnoreCase("studentlogin")){
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			boolean matchingerror = false;
			boolean checkerror = false;
			
			
			if(userid.isEmpty() || password.isEmpty()){
				checkerror = true;
				Errors error = new Errors(checkerror);
				data.add(error);
				request.setAttribute("errors", data);
				request.getRequestDispatcher("errorfile.jsp")
				.include(request, response);
			}else{
				try {
					matchingerror = process.studentlogin(userid,password,checkerror,matchingerror);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(matchingerror == true){
					
				  Errors	error = new Errors(matchingerror,checkerror);
					data.add(error);
					request.setAttribute("errors", data);
					request.getRequestDispatcher("errorfile.jsp")
					.include(request, response);
					
				}else{
					studentdetail detail = new studentdetail(userid);
					studentdata.add(detail);
					request.setAttribute("studentdata", studentdata);
					request.getRequestDispatcher("studentpage.jsp")
					.include(request, response);
				}
			}
			
		}else if(switchkey.equalsIgnoreCase("booksearch")){
			
			request.getRequestDispatcher("Booksearch.html")
			.include(request, response);
		}else if(switchkey.equalsIgnoreCase("search")){
			String bookname = request.getParameter("bookname");
			String language = request.getParameter("language");
			String catagory = request.getParameter("catagory");
			String publishyear = request.getParameter("publishyear");
			boolean bookstatus = false;
			boolean bookavailablestatus = false;
			
			
			boolean checkerror = false;
			if(bookname.isEmpty() && language.isEmpty() && catagory.isEmpty() && publishyear.isEmpty()){
				checkerror = true;
				Errors error = new Errors(checkerror);
				data.add(error);
				request.setAttribute("errors", data);
				request.getRequestDispatcher("Booksearch.jsp")
				.include(request, response);
			}else{
				
				try {
					status = process.bookstatus(status,bookname,bookdata,language,catagory,publishyear);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
				Errors error = new Errors(checkerror);
				data.add(error);
				request.setAttribute("bookdata",bookdata);
				request.setAttribute("errors", data);
				request.setAttribute("booksearch", status);
				request.getRequestDispatcher("Booksearch.jsp")
				.include(request, response);
			}
			
		}else if(switchkey.equalsIgnoreCase("backpage")){
			
			request.getRequestDispatcher("studentpage.jsp")
			.include(request, response);
			
		}else if(switchkey.equalsIgnoreCase("booklist")){
			
			try {
				process.booklist(bookdata);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bookdetail", bookdata);
			request.getRequestDispatcher("booklist.jsp")
			.include(request, response);
		}else if(switchkey.equalsIgnoreCase("buy")){
			
			String store = request.getParameter("bookid");
		  
		  
		  
			  
			  try {
				process.bookbuy(store);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  
			 
		  
		  request.getRequestDispatcher("bookbuy.jsp")
			.include(request, response);
			
		}else if(switchkey.equalsIgnoreCase("viewstatus")){
			
			 try {
				process.viewstatus(bookdata);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("view", bookdata);
			
			request.getRequestDispatcher("view.jsp")
			.include(request, response);
		}else if(switchkey.equalsIgnoreCase("bookreturn")){
			
			request.getRequestDispatcher("bookreturn.html")
			.include(request, response);
			
		}else if(switchkey.equalsIgnoreCase("return")){
			
			String bookname = request.getParameter("bookname");
			String language = request.getParameter("language");
			boolean checkerror = false;
			
			if(bookname.isEmpty() || language.isEmpty()){
				
				 checkerror = true;
				  Errors error = new Errors(checkerror);
				  data.add(error);
				  request.setAttribute("errors", data);
					
				
			}
				
				try {
					process.bookreturn(data,bookname,language,checkerror);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Errors error = new Errors(checkerror);
				  data.add(error);
				  request.setAttribute("errors", data);
				request.setAttribute("error",data);
				request.getRequestDispatcher("bookreturn.jsp")
				.include(request, response);
				
			
		}
		
		
		
		
		
		
	}

}
