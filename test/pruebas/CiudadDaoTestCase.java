package pruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.CiudadDao;
import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exeption.MyDaoExeption;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml")) //Para que coja mi archivo de configuracion
public class CiudadDaoTestCase {

	
	@Autowired  
	CiudadDao dao;
	
	
	@Test
	public void testObtener() {
		
		List<Ciudad> ciudades;
		try{
			ciudades = dao.obtener();
			assertTrue(ciudades.size()> 0);
		}catch (MyDaoExeption e) {
			
			fail(e.getMessage());
			
		}
		
	}
	
	

	public void testCrear(){
		Ciudad ciudad;
		ciudad = new Ciudad();
		ciudad.setCodigo(433L);
		ciudad.setNombre("Lima");
		ciudad.setCodigoArea("435");
		try {
			dao.guardar(ciudad);
			
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

}
