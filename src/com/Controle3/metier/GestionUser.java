package com.Controle3.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Controle.entities.User;


public class GestionUser {
	public void ModifierUser(User user) {
		String url ="jdbc:mysql://localhost:3306/controle2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login="root";
		String passwd="";
		Connection cn=null;
		PreparedStatement ps=null;
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, login, passwd);
			
			ps = cn.prepareStatement("update users set login=? , pwd=? where idUser=?");
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPwd());
			ps.setInt(3, user.getIduser());
			ps.executeUpdate();
			ps.close();;
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try{
				cn.close();
				ps.close();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	public void ajouterUser(User user) {
		String url ="jdbc:mysql://localhost:3306/controle2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login="root";
		String passwd="";
		Connection cn=null;
		PreparedStatement ps=null;
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, login, passwd);
			
			ps = cn.prepareStatement("insert into users (login,pwd)values (?,?);");
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPwd());
			ps.executeUpdate();
			ps.close();;
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try{
				cn.close();
				ps.close();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	public User getuser(int idUser) {
		String url ="jdbc:mysql://localhost:3306/controle2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login="root";
		String passwd="";
		Connection cn=null;
		PreparedStatement ps=null;
		User user=null;
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, login, passwd);
			
			ps = cn.prepareStatement("select * from users where idUser=?;");
			ps.setInt(1,idUser);
			ResultSet rest =ps.executeQuery(); 
			
			while(rest.next()) {
				user= new User();
				user.setIduser(rest.getInt("idUser"));
				user.setLogin(rest.getString("login"));
				user.setPwd(rest.getString("pwd"));
			}
			ps.close();;
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try{
				cn.close();
				ps.close();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}
	public List<User> listUsers() {
		String url ="jdbc:mysql://localhost:3306/controle2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login="root";
		String passwd="";
		Connection cn=null;
		PreparedStatement ps=null;
		List<User> users=new  ArrayList<User>();
		User user=null;
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, login, passwd);
			
			ps = cn.prepareStatement("select * from users;");
			ResultSet rest =ps.executeQuery(); 
			
			while(rest.next()) {
				user= new User();
				user.setIduser(rest.getInt("idUser"));
				user.setLogin(rest.getString("login"));
				user.setPwd(rest.getString("pwd"));
				users.add(user);
			}
			ps.close();;
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try{
				cn.close();
				ps.close();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return users;
	}
	public void supprimerUser(int iduser) {
		String url ="jdbc:mysql://localhost:3306/controle2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login="root";
		String passwd="";
		Connection cn=null;
		PreparedStatement ps=null;
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, login, passwd);
			
			ps = cn.prepareStatement("delete from users where idUser=?;");
			ps.setInt(1, iduser);
			ps.executeUpdate();
			ps.close();;
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try{
				cn.close();
				ps.close();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
