package br.com.economy.DAO;

import java.util.Date;

public class teste {
	public static void main(String[] args) {
		TransactionDAO dao =  new TransactionDAO();
		Date dates = new   Date("1/1/2014");
		Date datee =  new Date("1/1/2016");
		String a = dao.getDataForGraphic(dates ,datee, 2);
	}
}
