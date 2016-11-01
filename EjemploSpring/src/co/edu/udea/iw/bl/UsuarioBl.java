package co.edu.udea.iw.bl;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Se cuenta con metodos que garantizan la l�gica del negocio en las operaciones 
 * transaccionales contra la base de datos
 * @author Elver Su�rez Alzate - elver.suarez@udea.edu.co
 *
 */
public interface UsuarioBl {
	
	/**
	 * Verifica si el usuario y contrase�a son v�lidos contra la base de datos
 	 * @param usuario login del usuario
	 * @param pws contrase�a del usuario
	 * @return si el usuario existe, retorna los datos del usuario, de lo contrario retorna null
	 * @throws MyDaoException ocurre cuando el usuario no existe o cuando la contrase�a es incorrecta.
	 */
	public Usuario validar(String usuario, String pws) throws MyDaoException;

}
