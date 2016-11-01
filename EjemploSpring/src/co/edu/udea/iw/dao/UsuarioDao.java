package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Define los m�todos de la capa de acceso a datos para un 
 * usuario en el sistema
 * @author Elver Su�rez Alzate - elver.suarez@udea.edu.co
 *
 */
public interface UsuarioDao {
	
	/**
	 * Entrega la lista completa de usuarios en el sistema
	 * @return lista de usuarios
	 * @throws MyDaoException si hay un error accediendo a los datos
	 */
	public List<Usuario> obtener() throws MyDaoException;
	
	/**
	 * Consulta la informaci�n de un usuario dado su login o nombre de usuario
	 * @param login login o nombre del usuario a consultar
	 * @return DTO con la informaci�n del usuario consultado, si el usuario no existe retorna null
	 * @throws MyDaoException si hay un error accediendo a los datos
	 */
	public Usuario obtener(String login) throws MyDaoException;

}
