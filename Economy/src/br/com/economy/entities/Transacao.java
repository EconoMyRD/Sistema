package br.com.economy.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SqlResultSetMapping(name="getTransactions", entities ={ 
		@EntityResult(entityClass = Transacao.class,
		fields={
			@FieldResult(name = "id", column = "transacao_id"),
			@FieldResult(name = "subcategoriaId", column = "subcategoriaId"),
			@FieldResult(name = "categoria_id", column = "categoria_id"),
			@FieldResult(name = "usuarioId", column = "usuarioId"),
			@FieldResult(name = "descricao", column = "descricao"),
			@FieldResult(name = "data_transacao", column = "data_transacao"),
			@FieldResult(name = "dataRegistro", column = "data_registro"),
			@FieldResult(name = "valor", column = "valor")
		})
//	,
//	@EntityResult(entityClass = SubCategory.class,
//	fields={
//		@FieldResult(name = "id", column = "subcategoria_id"),
//		@FieldResult(name = "nome", column = "nome"),
//		@FieldResult(name = "categoria_id", column = "categoria_id")
//	}
//	)
}
)

@Entity
@Table(name="TRANSACAO")
public class Transacao implements Serializable 
{
	@Id
	@Column(name="TRANSACAO_ID")	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_id")
	@SequenceGenerator(name = "sequence_id", allocationSize = 1, sequenceName = "transacao_id_seq")
	private Integer id;


	//@Column(name="SUBCATEGORIA")
	@OneToOne(fetch = FetchType.LAZY,targetEntity = Transacao.class)
	@PrimaryKeyJoinColumn
	private int subcategoria;
	@Column(name="USUARIO")
	private Integer usuarioId;
	private String descricao;
	@Column(name="DATA_TRANSACAO")
	@Temporal(TemporalType.DATE)
	private Date data_transacao;
	private Float valor;
	@Column(name="DATA_REGISTRO")
	@Temporal(TemporalType.DATE)
	private Date dataRegistro;
	
	public Transacao() 
	{
	}
	
	
	public Integer getId() 
	{
		return id;
	}
	
	public Integer getSubcategoriaId() 
	{
		return subcategoria;
	}
	public void setSubcategoriaId(Integer subcategoriaId) 
	{
		this.subcategoria= subcategoriaId;
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
		return data_transacao;
	}
	public void setDataTransacao(Date dataTransacao) 
	{
		this.data_transacao = dataTransacao;
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
