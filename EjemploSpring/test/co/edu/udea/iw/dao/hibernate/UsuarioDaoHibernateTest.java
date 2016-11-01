package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

public class UsuarioDaoHibernateTest {

	@Test
	public void testObtener() {
		UsuarioDao dao = new UsuarioDaoHibernate();
		List<Usuario> usuarios;
		try{
			usuarios = dao.obtener();
			
			for(Usuario usuario : usuarios){
				System.out.println("Login: " + usuario.getLogin());
				System.out.println("Rol: " + usuario.getRol().getNombre());
			}
			
			assertTrue(usuarios.size() > 0);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
