package pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.UsuarioBL;
import com.edu.udea.iw.logicaNegocio.imp.UsuarioBLimp;
import com.edu.udea.iw.utils.Hash;




@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class UsuarioDaoTestCase {

	@Autowired  
	UsuarioDao dao;
	@Autowired
	UsuarioBL usuarioBL;
	
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
	
	/**
	 * test para validar usuario y contraseña en la bd
	 */
	@Test 
	public void testUsuarioBL(){
		try {
			assertTrue(usuarioBL.validarUP("Elver", "elver"));
		} catch (MyDaoExeption e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}

	
	@Test
	public void testCrear(){
		
		
		//Contraseña
		
		try {
			Usuario usuario = new Usuario();
			Usuario usuarioTest = dao.obtenerPorLogin("elver");
			usuario.setNombres("Camilo");
			usuario.setApellidos("Posada Angel");
			usuario.setLogin("otromas");
			Rol rol = usuarioTest.getRol();
			System.out.println("codigo" + rol.getCodigo());
			//rol.setCodigo("ADM");
			usuario.setRol(rol);
			usuario.setContrasena(Hash.getHash("hola", "SHA1"));
			dao.guardar(usuario);
			
		} catch (MyDaoExeption e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		
		
	}
}
