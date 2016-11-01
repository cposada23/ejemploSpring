package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.UsuarioBl;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:configuracion.xml"})
public class UsuarioBlImplTest {

	@Autowired
	UsuarioBl usuarioBl;
	@Test
	public void testValidar() {
		
		String login = "elver";
		String pws = "elver";
		Usuario usuario = null;
		try{
			usuario = usuarioBl.validar(login, pws);
			assertNotNull(usuario);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
