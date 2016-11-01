package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Define los metodos de la capa de acceso a datos para los
 * clientes del sistema
 * @author Elver Suárez Alzate - elver.suarez@udea.edu.co
 *
 */
public interface ClienteDao {
	
	/**
	 * Entrega la lista de clientes existente en el sistema
	 * @return lista de clientes
	 * @throws MyDaoException si hay un error accediendo a los datos
	 */
	public List<Cliente> obtener() throws MyDaoException;
	
	/**
	 * Almacena los datos de un cliente en el sistema
	 * @param cliente dto de cliente con la información a almacenar
	 * @throws MyDaoException si hay un error consultando a los datos
	 */
	void guardar(Cliente cliente) throws MyDaoException;
	
	/**
	 * Entrega la información de un cliente dada su cedula
	 * @param cedula cedula del cliente a obtener
	 * @return DTO del cliente con su información, si el cliente no existe retorna null
	 * @throws MyDaoException Si hay un error accediendo a los datos
	 */
	Cliente obtener(String cedula) throws MyDaoException;

}
