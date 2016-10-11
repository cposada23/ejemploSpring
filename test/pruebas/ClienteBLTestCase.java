package pruebas;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.ClienteBL;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class ClienteBLTestCase {

	@Autowired
	ClienteBL clienteBL;
	
	
	public void testCrearCliente() {
		try {
			Cliente cliente = new Cliente();
			cliente.setCedula("98765432");
			
			clienteBL.crearCliente(cliente);
			
		} catch (MyDaoExeption  | NullPointerException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCrearCliente2(){
		try {
			clienteBL.crearCliente2("12345678", "Camilo", "Posada", "cposadaa@gmail.com", "elver");
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}

}
