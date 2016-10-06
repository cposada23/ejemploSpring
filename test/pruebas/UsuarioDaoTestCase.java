package pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;




@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class UsuarioDaoTestCase {

	@Autowired  
	UsuarioDao dao;
	
	@Test
	public void testObtener() {
		List<Usuario> usuarios = null;
		try{
			
			usuarios = dao.obtener();
			assertTrue(usuarios.size()> 0);
			
		}catch (MyDaoExeption e) {
			
			fail(e.getMessage());
			
		}
	}

	@Test
	
	public void testObtenerPorLogin() {
		
		Usuario usuario = null;
		try {
			usuario = dao.obtenerPorLogin("elver");
			assertTrue(usuario.getNombres().equals("Elver"));
		} catch (MyDaoExeption e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
