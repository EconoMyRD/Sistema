package br.com.economy.DAO;


import javax.persistence.EntityManager;

import br.com.economy.entities.Usuario;
import br.com.economy.util.HibernateUtil;



public class UsuarioDao 
{
EntityManager em = HibernateUtil.getEntityManager();
	
	public UsuarioDao() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void Insert(Usuario usuario)
	{
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	public void Update(Usuario usuario)
	{
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}

	public Usuario GetById(Integer idUsuario)
	{
		Usuario usuario = em.find(Usuario.class, idUsuario);
		return usuario;
	}

}
