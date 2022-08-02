package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginChecker() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String Username =request.getParameter("txtUname");
		String password =request.getParameter("txtPassword");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd;
		if(Username.equalsIgnoreCase("java") && password.equals("romen003"))
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("Uname", Username);
			
			rd = request.getRequestDispatcher("Welcome");
			rd.forward(request, response);
		}
		else
		{
			out.println("Invalid Id or Password");
			rd = request.getRequestDispatcher("LoginForm.html");
			rd.include(request, response);
		}
	}
}
