package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Emp;
import com.employee.empdao.EmpDAO;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Emp e = new Emp();
		e.setEmpName(name);
		e.setEmpPass(pass);
		e.setEmpEmail(email);
		e.setCountry(country);
		EmpDAO dao = new EmpDAO();
		dao.connect();
		int status = dao.save(e);
		if(status > 0) {
			out.print("<p>Record save SuccesFully!!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);			
		}else {
			out.print("<p>Sorry!Unable to save record<p/>");
		}
		out.close();
	}

}
