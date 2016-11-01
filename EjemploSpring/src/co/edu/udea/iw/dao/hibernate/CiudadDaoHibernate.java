package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Implementación en Hibernate de {@link CiudadDao}
 * 
 * @author Elver Suárez Alzate - elver.suarez@udea.edu.co
 * @see CiudadDao
 *
 */
public class CiudadDaoHibernate implements CiudadDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Ciudad> obtener() throws MyDaoException {
		Session session = null;
		List<Ciudad> resultado = null;

		try {
			session = sessionFactory.openSession();

			Criteria crit = session.createCriteria(Ciudad.class);

			resultado = crit.list();

		} catch (HibernateException e) {
			throw new MyDaoException(e);
		}
		return resultado;
	}

	@Override
	public Ciudad obtener(Long codigo) throws MyDaoException {
		Session session = null;
		Ciudad ciudad = null;

		try {
			session = sessionFactory.openSession();

			Criteria crit = session.createCriteria(Ciudad.class).add(Restrictions.eq("codigo", codigo));

			ciudad = (Ciudad) crit.uniqueResult();

		} catch (HibernateException e) {
			throw new MyDaoException(e);
		}
		return ciudad;
	}

	@Override
	public void guardar(Ciudad ciudad) throws MyDaoException {

		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.save(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);
		}

	}

	@Override
	public void modificar(Ciudad ciudad) throws MyDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.update(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);
		}

	}

	@Override
	public void eliminar(Long codigo) throws MyDaoException {

		Session session = null;
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(codigo);

		try {
			session = sessionFactory.openSession();

			session.delete(ciudad);

		} catch (HibernateException e) {
			throw new MyDaoException(e);
		}
	}

}
