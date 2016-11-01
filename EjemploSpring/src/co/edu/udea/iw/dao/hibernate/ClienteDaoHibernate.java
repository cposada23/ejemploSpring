package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Implementación en Hibernate de {@link ClienteDao}
 * @author Elver Suárez Alzate - elver.suarez@udea.edu.co
 * @see ClienteDao
 *
 */
public class ClienteDaoHibernate implements ClienteDao {

	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Cliente> obtener() throws MyDaoException {
		Session session = null;
		List<Cliente> resultado = null;
		
		try{
			session = sessionFactory.openSession();
			
			Criteria crit = session.createCriteria(Cliente.class);
			
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}finally{
			if(session != null)
			session.close();
		}
		return resultado;
	}
	
	@Override
	public Cliente obtener(String cedula) throws MyDaoException{
		Cliente cliente = null;
		Session session = null;
		try{
			session = sessionFactory.openSession();
			cliente = (Cliente) session.get(Cliente.class, cedula);
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		
		return cliente;
	}
	
	
	@Override
	public void guardar(Cliente cliente) throws MyDaoException {
		
		Session session = null;
		try{
			
			session = sessionFactory.openSession();
			session.save(cliente);
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		
	}

}
