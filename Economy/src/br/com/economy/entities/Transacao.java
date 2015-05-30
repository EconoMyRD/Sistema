package br.com.economy.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACAO")
public class Transacao implements Serializable 
{
	@Id
	@Column(name="TRANSACAO_ID")	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_id")
	@SequenceGenerator(name = "sequence_id", allocationSize = 1, sequenceName = "transacao_id_seq")
	private Integer id;
	@Column(name="SUBCATEGORIA")
	private Integer subcategoriaId;
	@Column(name="USUARIO")
	private Integer usuarioId;
	private String descricao;
	@Column(name="DATA_TRANSACAO")
	private Date dataTransacao;
	private Float valor;
	@Column(name="DATA_REGISTRO")
	private Date dataRegistro;
	
	public Transacao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getId() 
	{
		return id;
	}
	
	public Integer getSubcategoriaId() 
	{
		return subcategoriaId;
	}
	public void setSubcategoriaId(Integer subcategoriaId) 
	{
		this.subcategoriaId = subcategoriaId;
	}
	public Integer getUsuarioId() 
	{
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) 
	{
		this.usuarioId = usuarioId;
	}
	public String getDescricao() 
	{
		return descricao;
	}
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
	public Date getDataTransacao() 
	{
		return dataTransacao;
	}
	public void setDataTransacao(Date dataTransacao) 
	{
		this.dataTransacao = dataTransacao;
	}
	public Float getValor() 
	{
		return valor;
	}
	public void setValor(Float valor) 
	{
		this.valor = valor;
	}
	public Date getDataRegistro() 
	{
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) 
	{
		this.dataRegistro = dataRegistro;
	}
	
	
}
