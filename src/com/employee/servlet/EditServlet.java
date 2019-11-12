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


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Update Employee</h2>");
		String id = request.getParameter("id");
		int sid = Integer.parseInt(id);
		
		EmpDAO dao = new EmpDAO();
		dao.connect();
		Emp e = dao.getEmployeeByID(sid);
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getEmpID()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='uname' value='"+e.getEmpName()+"'></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='pass' value='"+e.getEmpPass()+"'></td></tr>");
		out.print("<tr><td>Email-id:</td><td><input type='email' name='email' value='"+e.getEmpEmail()+"'></td></tr>");
		out.print("<tr><td>Country:</td>");
		out.print("<td><select name='country'>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>UK</option>");
		out.print("<option>Srilanka</option>");
		out.print("<option>Pakistan</option>");
		out.print("<option>Other</option>");
		out.print("</select></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'></td></tr>");
		out.print("</table>");
		out.print("</form>");
	}


}
