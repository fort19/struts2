/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.struts2.dto.LoginDTO;
import com.internousdev.struts2.util.DBConnector;
import com.mysql.jdbc.Connection;

/**
 * @author internousdev
 *
 */
public class LoginDAO {
	public LoginDTO select(String name,String password) {
		System.out.println(name);
		System.out.println(password);
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();

		String sql = "select * from users where user_name=? and password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2,password);
			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
			}
			} catch (SQLException e ) {
				e.printStackTrace();
			}
			try{
				con.close();
			} catch (SQLException e ) {
				e.printStackTrace();
			}
			return dto;
	}
}
