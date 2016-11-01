package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.ClienteBl;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:configuracion.xml"})
public class ClienteBlImplTest {
	
	@Autowired
	ClienteBl clienteBl;

	@Test
	public void testCrearCliente() {
		
		try{
			String cedula = "984727331";
			String nombres = "Elver";
			String apellidos = "Suarez";
			String email = "dafdafafsd@dad.com";
			String usuarioCrea = "elver";
			
			clienteBl.crearCliente(cedula, nombres, apellidos, email, usuarioCrea);
			
		}catch(MyDaoException | NullPointerException e){
			fail(e.getMessage());
		}
		
	}

}
