package br.com.economy.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable
{
	@Id
	@Column(name="USUARIO_ID")
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Boolean ativo;
	
	public Usuario() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getSenha() 
	{
		return senha;
	}
	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	public Boolean getAtivo() 
	{
		return ativo;
	}
	public void setAtivo(Boolean ativo) 
	{
		this.ativo = ativo;
	}
}
