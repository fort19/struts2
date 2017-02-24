package com.internousdev.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.LoginDAO;
import com.internousdev.struts2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
//import com.sun.javafx.collections.MappingChange.Map;

public class LoginAction extends ActionSupport implements SessionAware {

	private String name;
	private String password;
	private Map<String, Object> session;

	public String execute(){
		//System.out.println(name);
		//System.out.println(password);
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		dto = dao.select(name,password);

		String dtoName = dto.getName();
		String dtoPassword = dto.getPassword();
		System.out.println(dtoName);
		System.out.println(dtoPassword);

		if(name.equals(dtoName)){
			if(dtoPassword.equals(dto.getPassword())){
				ret = SUCCESS;
			}
		}

		session.put("name", dto.getName());

		System.out.println(ret);

		return ret;

	}




	public String getName() {
			return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}


	@Override
	public void setSession(java.util.Map<String, Object> session ) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;

	}

}
