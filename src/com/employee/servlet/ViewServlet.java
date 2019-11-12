package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Emp;
import com.employee.empdao.EmpDAO;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<a href='index.html'>Add new Employee</a><br/>");
		out.println("Employee List......");
		EmpDAO dao = new EmpDAO();
		dao.connect();
		List<Emp> list = dao.getAllEmployee();
		out.print("<table border='1' width='100%'>");
		out.print("<tr><th>EmpID</th><th>EmpName</th><th>EmpPass</th><th>EmpEmail</th><th>EmpCountry</th><th>Edit</th><th>delete</th><tr>");
		
		for(Emp e : list) {
			out.print("<tr><td>"+e.getEmpID()+"</td><td>"+e.getEmpName()+"</td><td>"+e.getEmpPass()+"</td><td>"+e.getEmpEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getEmpID()+"'>Edit</a></td><td><a href='DeleteServlet?id="+e.getEmpID()+"'>Delete</a></td></tr>");
		}
		out.print("</table>");
	}


}
