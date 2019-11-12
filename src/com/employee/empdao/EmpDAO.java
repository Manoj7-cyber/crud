package com.employee.empdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.employee.Emp;

public class EmpDAO {

	 String url="jdbc:mysql://localhost:3306/employee";
	 String username = "root";
	 String password="manojmkm";
	 Connection con = null;
	public  void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  int save(Emp e) {
		int status = 0;
		
		String query = "insert into employee(name,pass,email,country) values(?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,e.getEmpName());
			st.setString(2, e.getEmpPass());
			st.setString(3,e.getEmpEmail());
			st.setString(4, e.getCountry());
			
			status = st.executeUpdate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public int update(Emp e) {
		int status = 0;
		String query="update employee set name=?,pass=?,email=?,country=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,e.getEmpName());
			st.setString(2, e.getEmpPass());
			st.setString(3, e.getEmpEmail());
			st.setString(4, e.getCountry());
			st.setInt(5, e.getEmpID());
			
			status = st.executeUpdate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public int delete(int id) {
		int status = 0;
		String query = "delete from employee where id=?";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,id);
			status = st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public Emp getEmployeeByID(int id) {
		Emp e = new Emp();
		String query = "select * from employee where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				e.setEmpID(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setEmpPass(rs.getString(3));
				e.setEmpEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	
	public List<Emp> getAllEmployee(){
		
		List<Emp> list = new ArrayList<Emp>();
		String query = "select * from employee";
		try {
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Emp e = new Emp();
				e.setEmpID(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setEmpPass(rs.getString(3));
				e.setEmpEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
