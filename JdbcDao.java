package com.sapient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sapient.vo.Emp;

public class JdbcDao implements IDao {

	
	public static final String DRIVER;
	public static final String URL;
	public static final String UNAME;
	public static final String PWD;
	
	static{
		DRIVER=DaoFactory.rb.getString("driver");
		URL=DaoFactory.rb.getString("url");
		UNAME=DaoFactory.rb.getString("uname");
		PWD=DaoFactory.rb.getString("pwd");
		try{
			Class.forName(DRIVER);
		}
		catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		
	}
	JdbcDao(){
		System.out.println("JdbcDao cons");
	}
	@Override
	public List<Emp> getEmployee() {
		List<Emp>lst=new ArrayList<Emp>();
		Emp emp=null;
		try(Connection conn=DriverManager.getConnection(URL,UNAME,PWD)){
			String sql="select * from employee";
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				emp=new Emp(rs.getInt("eid"),rs.getString("ename"),rs.getDouble("sal"));
				lst.add(emp);
			}
		}	catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return lst;
	}

}
