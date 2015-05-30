package br.com.economy.DAO;


import javax.persistence.EntityManager;

import br.com.economy.entities.Categoria;
import br.com.economy.util.HibernateUtil;


public class CategoriaDao
{
	EntityManager em = HibernateUtil.getEntityManager();
	
	public CategoriaDao() 
	{
		
	}
	
	public void Insert(Categoria categoria)
	{
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
	}

	public void Update(Categoria categoria)
	{
		em.getTransaction().begin();
		em.merge(categoria);
		em.getTransaction().commit();
	}

	public Categoria GetCategoriaById(Integer idCategoria)
	{
		Categoria categoria = em.find(Categoria.class, idCategoria);
		return categoria;
	}
}
