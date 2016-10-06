package pruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.ClienteDao;
import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exeption.MyDaoExeption;



@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class ClienteDaoeTestCase {

	
	@Autowired  
	ClienteDao dao;
	
	public void testCrear() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtener() {
		
		List<Cliente> clientes = null;
		try{
			
			clientes = dao.obtener();
			assertTrue(clientes.size()> 0);
			
		}catch (MyDaoExeption e) {
			
			fail(e.getMessage());
			
		}
	}

	
	public void testEliminar() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerPorCedula() {
		
		Cliente cliente = null;
		try {
			cliente = dao.obtenerPorCedula("10202030");
			assertTrue(cliente.getNombres().equals("Camilo"));
		} catch (MyDaoExeption e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
		
	}

}
