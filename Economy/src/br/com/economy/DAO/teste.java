package br.com.economy.DAO;

import java.text.ParseException;

import br.com.economy.email.Email;


public class teste {
	public static void main(String[] args) throws ParseException {
		String message = "Ol� " + "ricardo" +
				"\n\nPara ativar sua conta clique no link abaixo."
				+ "\nVoc� pode entrar em sua conta utilizando seu email e sua senha: " + 
				"\n\n http://localhost:8080/Economy/servletActivateUser?email=" ;
		Email sender = new Email();
		sender.sendMail("ricardo.jonas.faria@gmail.com","ricardo.jonas.faria@gmail.com"
				, "ativa��o de sua conta Economy", message);	
	}
}