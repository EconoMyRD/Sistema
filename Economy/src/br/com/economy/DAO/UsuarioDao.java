package br.com.economy.DAO;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.economy.entities.Usuario;
import br.com.economy.util.HibernateUtil;



public class UsuarioDao 
{
EntityManager em = HibernateUtil.getEntityManager();
	
//////////     VERIFY IF THE USER IS ACTIVE ON DATABASE  //////////////
	public int verifyUser(String email, String password){		

		Query q = em.createNativeQuery("select * from usuario u where u.email = ?", Usuario.class);
		q.setParameter(1, email);
		Usuario user =  new  Usuario();
		try{
			user= (Usuario)q.getSingleResult();		
			if(user.getAtivo() == false){
				return 1;				//user not active
			}		
			else if(!password.equals(user.getSenha()) ){
				
				return 2;			// wrong password				
			}
			else{
				return 3; 			//login ok
			}
			
		}catch(NoResultException e){
			return 0;
		}
	
		
	}
	
	////////	VERIFY IF THE EMAIL IS ALREADY REGISTERED 	///////
	public int verifyEmail(String email){
		Query query = em.createNativeQuery("select * from usuario where email = ?");
		query.setParameter(1, email);
		
		try{
			query.getSingleResult();
			return 1;					// email already registered
		}
		catch(NoResultException e){
			return 0;					//email not registered
		}
	
	}
		

	
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
	
	
	public void activateUser(String email){
		Query query = em.createNativeQuery("update usuario set ativo = true where email = ?");
		query.setParameter(1, email);
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
	}

}
