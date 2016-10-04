package com.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

public class UsuarioDaoImpHibernate implements UsuarioDao {

	
	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Usuario> obtener() throws MyDaoExeption {
		Session session = null;
		List<Usuario> usuarios = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return usuarios;
	}
	
	@Override
	public Usuario obtenerPorLogin(String log) throws MyDaoExeption{
		Session session = null;
		Usuario usuario = null;
		
		try {
			session = sessionFactory.openSession();
			usuario = (Usuario) session.get(Usuario.class, log); //Traer un solo registro de la bd dada su clave primaria
			//usuario = (Usuario) session.load(Usuario.class, log);  // Con el load el objeto tiene que existir si no retorna una exception
																     	// con el get si no existe retorna null
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return usuario;
	}

}
