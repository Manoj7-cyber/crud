package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Emp;
import com.employee.empdao.EmpDAO;


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		int sid= Integer.parseInt(id);
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Emp e = new Emp();
		e.setEmpID(sid);
		e.setEmpName(name);
		e.setEmpPass(pass);
		e.setEmpEmail(email);
		e.setCountry(country);
		
		EmpDAO dao = new EmpDAO();
		dao.connect();
		int status = dao.update(e);
		if(status > 0) {
			response.sendRedirect("ViewServlet");
		}else {
			out.print("Sorry!!Unable to Update");
		}
	}

}
