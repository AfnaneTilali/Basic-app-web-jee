package com.Controle.entities;

public class User {
	private int iduser;
	private String Login;
	private String pwd;
	public User(String login, String pwd) {
		super();
		Login = login;
		this.pwd = pwd;
	}
	
	public User(int iduser, String login, String pwd) {
		super();
		this.iduser = iduser;
		Login = login;
		this.pwd = pwd;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public User() {
		super();
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

}