package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Implementación en Hibernate de {@link UsuarioDao}
 * @author Elver Suárez Alzate - elver.suarez@udea.edu.co
 * @see UsuarioDao
 *
 */
public class UsuarioDaoHibernate implements UsuarioDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public List<Usuario> obtener() throws MyDaoException {
		Session session = null;
		List<Usuario> resultado = null;
		
		try{
			session = sessionFactory.openSession();
			
			Criteria crit = session.createCriteria(Usuario.class);
			
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
	public Usuario obtener(String login) throws MyDaoException {
		Session session = null;
		Usuario usuario = null;
		
		try{
			session = sessionFactory.openSession();
			
			usuario = (Usuario) session.get(Usuario.class, login);
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return usuario;
	}

}
