package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Metodos que garantizan la l�gica del negocio en la interacci�n con los
 * clientes
 * 
 * @author Elver Su�rez Alzate - elver.suarez@ude.edu.co
 *
 */
public interface ClienteBl {

	/**
	 * Permite la creaci�n de un cliente en el sistema
	 * 
	 * @param cedula
	 *            identificaci�n del cliente, no puede ser nulo ni una cadena de
	 *            carateres vacia
	 * @param nombres
	 *            Nombres del ciente, no puede ser nulo ni una cadena de
	 *            carateres vacia
	 * @param apellidos
	 *            Apellidos del cliente, no puede ser nulo ni una cadena de
	 *            caracteres vacia
	 * @param email
	 *            Correo electr�nico del cliente, no puede ser nulo, ni una
	 *            cadena de caracteres vacia y debe ser una cadena de caracteres
	 *            con un correo bien formado
	 * @param usuarioCrea
	 *            Login del usuario que crea el cliente. Debe ser un usuario
	 *            valido en el sistema
	 * @throws MyDaoException
	 *             ocurre cuando hay alg�n error de validaci�n de datos o hay
	 *             cuando hay problemas guardando los datos.
	 */
	public void crearCliente(String cedula, String nombres, String apellidos, String email, String usuarioCrea)
			throws MyDaoException;

	/**
	 * Entrega la lista de clientes del sistema
	 * 
	 * @return lista de clientes
	 * @throws MyDaoException
	 *             si hay un error accediendo los datos
	 */
	public List<Cliente> obtener() throws MyDaoException;
}
