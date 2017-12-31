package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginDao dao=new LoginDao();

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		if (dao.checkCredentials(uname, pass)) {

			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("welcome.jsp");
		} else
			response.sendRedirect("login.jsp");
		

		//without db , static values check
		/*if (uname.equals("t") && pass.equals("l")) {

			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("welcome.jsp");
		} else
			response.sendRedirect("login.jsp");*/

	}
}