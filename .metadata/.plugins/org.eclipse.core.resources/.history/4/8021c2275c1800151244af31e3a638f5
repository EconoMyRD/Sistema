package br.com.economy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.economy.DAO.TransactionDAO;
import br.com.economy.entities.Transacao;

public class ServletTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TransactionDAO transacaoDAO = new TransactionDAO();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("estou no doget");

		// get values from the parameter request
		String description = request.getParameter("description");
		String valueString = request.getParameter("value");
		String date_transactionString = request.getParameter("date_transaction");
		Date date_register = new Date();
		Date date_transaction = new Date();
		float value;
		int subcategory;
		int user = 1;
		
		System.out.println("date_transactionString" + date_transactionString);
		try {
			// conversions
			
			value = Float.parseFloat(valueString);
			subcategory = Integer.parseInt(request.getParameter("subcategory"));

//			out.println(description + " " + value + " "
//					+ date_transactionString);
			// conversion for date

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");			
			date_transaction = sdf.parse(date_transactionString);
			System.out.println("date_transacrion" + date_transaction);
			System.out.println("date_register" + date_register);
			System.out.println(subcategory);
			
			persistOnDataBase(value,date_transaction, date_register, description,subcategory,user);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void persistOnDataBase(float value,Date date_transaction,Date date_register,
			String description, int subcategory,int user) {
		
		// set the object transaction
		Transacao transaction = new Transacao();
		transaction.setValor(value);
		transaction.setDataTransacao(date_transaction);
		transaction.setDataRegistro(date_register);
		transaction.setDescricao(description);
		transaction.setSubcategoriaId(subcategory);
		//instanciar objeto subcategoria com dados do banco para setar este atributo 
		transaction.setUsuarioId(user);
		System.out.println("lets go insert");
		//persist on data base
		transacaoDAO.Insert(transaction);

	}

	public ServletTransaction() {
		super();

	}
}
