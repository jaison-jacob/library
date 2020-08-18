package Librarymanagementadmin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class admin
 */
// @WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public admin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.html").include(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Errors> error = new ArrayList<Errors>();
		String checkphoneno = "false";
		Admindata data = new Admindata();
		String button = request.getParameter("page");
		System.out.println(button);
		Sqlprocess process = new Sqlprocess();
		ArrayList<Bookadd> booklist = new ArrayList<Bookadd>();
		ArrayList<Admindata> admindata = new ArrayList<Admindata>();
		if (button.equalsIgnoreCase("adminregister")) {

			String name = request.getParameter("register name");
			System.out.println("register name :" + name);
			String username = request.getParameter("register username");
			System.out.println("register username :" + username);
			String password = String.valueOf(request
					.getParameter("register password"));
			System.out.println("register password :" + password);
			String phoneno = String.valueOf(request
					.getParameter("register phoneno"));
			System.out.println("register phoneno :" + phoneno);
			String address = request.getParameter("register address");
			String email = request.getParameter("register email");
			System.out.println(phoneno);
			System.out.println("phoneno length " + phoneno.length());

			if (phoneno.length() != 10) {
				checkphoneno = "true";
			}
			data = new Admindata(name, username, password, phoneno, address,
					email);
			try {
				error = process.addadmindata(data, checkphoneno, error);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("check1", error);
			request.getRequestDispatcher("loginerror.jsp").include(request,
					response);

		} else if (button.equalsIgnoreCase("adminlogin")) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String passworderror = "false";
			data = new Admindata(username, password);
			try {
				passworderror = process.login(data);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			Errors datas = new Errors(passworderror);
			error.add(datas);
			if (passworderror.equalsIgnoreCase("true")) {
				request.setAttribute("checkerror", error);
				request.getRequestDispatcher("loginerror.jsp").include(request,
						response);
			} else {
				request.getRequestDispatcher("Adminpage.html").include(request,
						response);
			}

		} else if (button.equalsIgnoreCase("bookaddhtml")
				|| button.equalsIgnoreCase("bookadd")) {

			if (button.equalsIgnoreCase("bookaddhtml")) {
				request.getRequestDispatcher("booksadd.html").include(request,
						response);
			} else {

				String bookname = String.valueOf(request
						.getParameter("book name"));
				String language = String.valueOf(request
						.getParameter("language"));
				String catagory = String.valueOf(request
						.getParameter("catogory"));
				String publishdate = String.valueOf(request
						.getParameter("publish date"));
				Bookadd add = new Bookadd(bookname, language, catagory,
						publishdate);
				try {
					error = process.bookadd(add, error);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				request.setAttribute("bookerror", error);
				request.getRequestDispatcher("bookadd.jsp").include(request,
						response);
			}

		} else if (button.equalsIgnoreCase("booksview")) {

			try {
				booklist = process.viewbooks(booklist);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("booklist", booklist);
			request.getRequestDispatcher("booksview.jsp").include(request,
					response);
		} else if (button.equalsIgnoreCase("studentlist")) {

			try {
				process.studentlist(admindata);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("data", admindata);
			request.getRequestDispatcher("studentlist.jsp").include(request,
					response);
		} else if (button.equalsIgnoreCase("searchstudent")) {
			request.getRequestDispatcher("searchstudent.html").include(request,
					response);
		} else if (button.equalsIgnoreCase("backadminpage")) {

			request.getRequestDispatcher("Adminpage.html").include(request,
					response);

		} else if (button.equalsIgnoreCase("booksearch")) {

			request.getRequestDispatcher("booksearch.html").include(request,
					response);

		} else if (button.equalsIgnoreCase("search")) {

			String bookname = request.getParameter("bookname");
			String language = request.getParameter("language");
			String catagory = request.getParameter("catagory");
			String publishyear = request.getParameter("publishyear");
			String checkerror = "false";

			if (bookname.isEmpty() && language.isEmpty() && catagory.isEmpty() && publishyear.isEmpty()) {
				checkerror = "true";
				Errors errors = new Errors(checkerror, "");
				error.add(errors);

			}

			try {
				process.searchbook(booklist, admindata, bookname, language,
						checkerror, error,catagory,publishyear);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Errors errors = new Errors(checkerror, "");
			error.add(errors);
			request.setAttribute("checkerror", error);
			request.setAttribute("booklist", booklist);
			request.setAttribute("bookdata", admindata);

			request.getRequestDispatcher("booksearch.jsp").include(request,
					response);

		} else if (button.equalsIgnoreCase("studentsearch")) {

			String name = request.getParameter("studentname");
			String checkerror = "false";
			String matchingerror = "true";
			if (name.isEmpty()) {

				checkerror = "true";
				Errors errors = new Errors(checkerror, matchingerror);
				error.add(errors);

				request.setAttribute("error", error);
				request.getRequestDispatcher("searchstudent.jsp").include(
						request, response);

			} else {

				try {
					process.searchstudent(error, admindata, name, checkerror);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				request.setAttribute("error", error);
				request.setAttribute("data", admindata);

				request.getRequestDispatcher("searchstudent.jsp").include(
						request, response);

			}

		}

	}

}
