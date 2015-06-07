package br.com.economy.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class teste {
	public static void main(String[] args) throws ParseException {
		//TransactionDAO dao =  new TransactionDAO();
		String datee =  "1/1/2020";
		String dates = "2014/2/5";
		Date dateEnd = new Date();
		Date date =  new SimpleDateFormat("dd/MM/yyyy").parse(dates);
		Calendar dateStart = Calendar.getInstance();
		dateStart.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(dateStart);
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			dateStart = sdf.parse(dates);
//			 dateEnd = sdf.parse(datee);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(dateStart);
//		String a = dao.getDataForGraphic(dateStart ,dateEnd, 2);
	}
}
