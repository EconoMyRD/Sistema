package br.com.economy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.economy.DAO.UsuarioDao;


public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UsuarioDao DAO = new UsuarioDao();
		
		Integer active = DAO.verifyUser(email, password);
		
		System.out.println(active);
		PrintWriter out = response.getWriter();
		out.write(active.toString());
		
	}

}
