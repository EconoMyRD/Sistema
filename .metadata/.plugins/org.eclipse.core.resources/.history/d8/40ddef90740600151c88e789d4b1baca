package br.com.economy.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.economy.DAO.SubCategoryDAO;

@WebServlet("/servletRelatory")
public class ServletRelatory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SubCategoryDAO DAO = new SubCategoryDAO();
    
    public ServletRelatory() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Date dateEnd = new Date();
		Date dateStart = new Date();
		int category =0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			category = Integer.parseInt(request.getParameter("category"));
			dateStart = sdf.parse(request.getParameter("category"));
			dateEnd = sdf.parse(request.getParameter("dateEnd"));
		} catch (ParseException e) {
			//impossible have wrong parameters
			e.printStackTrace();
		}
		
		DAO.getDataForGraphic(dateStart, dateEnd, category);
		
	}


	
	
	

}
