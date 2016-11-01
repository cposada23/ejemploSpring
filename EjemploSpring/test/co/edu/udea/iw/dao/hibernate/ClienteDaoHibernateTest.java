package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

public class ClienteDaoHibernateTest {

	@Test
	public void testObtener() {
		ClienteDao dao = new ClienteDaoHibernate();
		List<Cliente> clientes;
		try{
			clientes = dao.obtener();
			
			for(Cliente cliente : clientes){
				System.out.println("Cedula: " + cliente.getCedula());
				System.out.println("Nombre: " + cliente.getNombres());
			}
			
			assertTrue(clientes.size() > 0);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
