package br.com.economy.DAO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;

import br.com.economy.entities.SubCategory;
import br.com.economy.entities.Transacao;
import br.com.economy.util.HibernateUtil;

public class TransactionDAO 
{
EntityManager em = HibernateUtil.getEntityManager();
	
	
	public String getDataForGraphic(Date dateStart, Date dateEnd, int category){
//		TypedQuery<Transacao> query = em.createQuery(
//				"select t.dataTransacao as date,"
//				+ " sum(t.valor) as value,"
//				+ " t.subcategoriaId.categoriaId as category, "
//				+ " t.subcategoriaId.id as subcategoriaId, "
//				+ " t.subcategoriaId.nome as name "
//				+ " from Transacao t where dataTransacao between(? ,?)"
//				+ " and  t.subcategoriaId.categoriaId = ? group by t.dataTransacao, t.subcategoriaId.categoriaId",
//				Transacao.class);
		
		
//		Query query = em.createNativeQuery(
//				"select t.transacao_id, "
//				+ "t.subcategoria, "
//				+ "t.usuario, "
//				+ "t.descricao, "
//				+ "t.data_transacao as date, "
//				+ "sum(t.valor) as value, "
//				+ "t.data_registro, "
//				+ "s.categoria_id as category, "
//				+ "s.nome, "
//				+ "s.subcategoria_id "				
//				+ "from transacao t join subcategoria s on t.subcategoria = s.subcategoria_id "
//				+ "where s.categoria_id = ? "
//				+ "and t.data_transacao between ? and ? "
//				+ "group by 1,2,3,4,5,7,8,9,10");
				
		TypedQuery<Transacao> query = em.createQuery(
				"select t.subcategoria, t.data_transacao, sum(t.valor), s.categoria_id, s.nome"
				+ " from Transacao t join SubCategory s on t.subcategoria = s.id "
				+ "where s.categoria_id = :category and t.data_transacao > :dateStart and t.data_transacao < :dateEnd", Transacao.class, SubCategory.class);
		
		query.setParameter("category", category);
		query.setParameter("dateStart", dateStart);
		query.setParameter("dateEnd", dateEnd);
		 
		List<Transacao> list = new ArrayList<Transacao>();
		list = query.getResultList();
		
		Gson gson = new  Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		return json;
	}
	
	public void Insert(Transacao transacao)
	{
		em.getTransaction().begin();
		em.persist(transacao);
		em.getTransaction().commit();
	}

	public void Update(Transacao transacao)
	{
		em.getTransaction().begin();
		em.merge(transacao);
		em.getTransaction().commit();
	}

	public Transacao GetTransacaoById(Integer idtransacao)
	{
		Transacao transacao = em.find(Transacao.class, idtransacao);
		return transacao;
	}

	
	public TransactionDAO() 
	{
	}
}
