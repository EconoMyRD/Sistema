package br.com.economy.DAO;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.economy.entities.ModelQuery;
import br.com.economy.entities.Transacao;
import br.com.economy.util.HibernateUtil;

import com.google.gson.Gson;

public class TransactionDAO 
{
EntityManager em = HibernateUtil.getEntityManager();
	
	
	public String getDataForGraphic(Date dateStart, Date dateEnd, int category){
			
			Query query = em.createNativeQuery("select  sum(t.valor) as value, s.nome as name, "// t.data_transacao as date, "
				+ " s.subcategoria_id as subcategoria, s.categoria_id as categoria "
				+ " from transacao t "
				+ " join subcategoria s "
				+ " on t.subcategoria = s.subcategoria_id "
				+ " where s.categoria_id = ? "
				+ " and t.data_transacao between ? and ? "
				+ " group by s.nome, s.subcategoria_id, s.categoria_id");
		
		query.setParameter(1, category);
		query.setParameter(2, dateStart);
		query.setParameter(3, dateEnd);
		
		List<Object[]> list = new ArrayList<Object[]>();
		list = query.getResultList();
		//System.out.println(list.size());
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<ModelQuery> modelQuery = new ArrayList<ModelQuery>();
		
		for (int i =0 ;i< list.size(); i++) {
			float value = Float.parseFloat(list.get(i)[0].toString());
			String name = list.get(i)[1].toString();
			int categoria = Integer.parseInt(list.get(i)[3].toString());
			int subcategory = Integer.parseInt(list.get(i)[2].toString());
//			Date dateTemp = new Date();
//			String date ="";
//			try {
//				dateTemp = sdf.parse(list.get(i)[2].toString());
//				date = sdf.format(dateTemp);
//				
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
			
			ModelQuery model = new ModelQuery(value, name, subcategory, categoria);
			//System.out.println(date);
			modelQuery.add(model);
		}
		
		
		Gson gson = new  Gson();
		String json = gson.toJson(modelQuery);
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
