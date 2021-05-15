package com.Controle3.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Controle.entities.User;
import com.Controle3.metier.GestionUser;

/**
 * Servlet implementation class Controle3Controller
 */
@WebServlet(name="ws",urlPatterns={"/Ajouter","/formAjout","/Afficher","/suprimeruser","/modifieruser","/modifer",
		"/ModiferList","/SupprimerList"})
public class Controle3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GestionUser gest;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controle3Controller() {
        super();
        gest= new GestionUser();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path= request.getServletPath();
		HttpSession  session = request.getSession();
		if (path.equals("/Ajouter")){
			request.getRequestDispatcher("Ajouter.jsp").forward(request, response);
		} else if (path.equals("/formAjout")){
			String login=request.getParameter("login");
			String modpass=request.getParameter("motdepasse");
			User user=new User();
			user.setLogin(login);
			user.setPwd(modpass);
			gest.ajouterUser(user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else if (path.equals("/Afficher")){
			List<User> users=gest.listUsers();
			session.setAttribute("users", users);
			request.getRequestDispatcher("Afficher.jsp").forward(request, response);
		}else if (path.equals("/suprimeruser")){
			int iduser=Integer.parseInt(request.getParameter("iduser"));
			gest.supprimerUser(iduser);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else if (path.equals("/modifieruser")){
			int iduser=Integer.parseInt(request.getParameter("iduser"));
			User user=gest.getuser(iduser);
			session.setAttribute("user", user);
			request.getRequestDispatcher("Modifer.jsp").forward(request, response);
		}else if (path.equals("/modifer")){
			int iduser=Integer.parseInt(request.getParameter("iduser"));
			String login=request.getParameter("login");
			String modpass=request.getParameter("modpass");
			User user=new User();
			user.setIduser(iduser);
			user.setLogin(login);
			user.setPwd(modpass);
			gest.ModifierUser(user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else if (path.equals("/ModiferList")){
			List<User> users=gest.listUsers();
			session.setAttribute("users", users);
			request.getRequestDispatcher("ModiferList.jsp").forward(request, response);
		}else if (path.equals("/SupprimerList")){
			List<User> users=gest.listUsers();
			session.setAttribute("users", users);
			request.getRequestDispatcher("SupprimerList.jsp").forward(request, response);
		}
		
	}

}
