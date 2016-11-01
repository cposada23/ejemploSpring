package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Define los metodos para acceder a las Ciudades
 * @author Elver Suarez Alzate - elver.suarez@udea.edu.co
 *
 */
public interface CiudadDao {

	/**
	 * Entrega la lista de ciudades disponibles en la bd
	 * @return Lista de ciudades
	 * @throws MyDaoException cuando hay algún problema en la conexión
	 */
	public List<Ciudad> obtener() throws MyDaoException;
	
	/**
	 * Entrega los datos de una ciudad dado su código
	 * @param codigo
	 * @return
	 * @throws MyDaoException
	 */
	public Ciudad obtener(Long codigo) throws MyDaoException;
	/**
	 * Permite crear una nueva ciudad en la base de datos
	 * @param ciudad Dto con los datos de la ciudad a crear
	 * @throws MyDaoException
	 */
	public void guardar(Ciudad ciudad) throws MyDaoException;
	
	/**
	 * Actualiza la información de una ciudad en la base de datos
	 * 
	 * @param ciudad información de la ciudad a modificar
	 * @throws MyDaoException
	 */
	public void modificar(Ciudad ciudad) throws MyDaoException;
	
	/**
	 * Elimna una ciudad de la base de datos
	 * @param ciudad
	 * @throws MyDaoException
	 */
	public void eliminar(Long codigo) throws MyDaoException;
}
