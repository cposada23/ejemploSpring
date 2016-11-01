package co.edu.udea.iw.bl.impl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.bl.ClienteBl;
import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Implementa {@link ClienteBl} con Spring
 * @see ClienteBl
 * @author Elver Suárez Alzate - elver.suarez@udea.edu.co
 * @see ClienteBl
 *
 */
public class ClienteBlImpl implements ClienteBl {

	/**
	 * Dao de cliente, es inyectado por Spring
	 */
	ClienteDao clienteDao;
	/**
	 * Dao de usuario, es inyectado por Spring
	 */
	UsuarioDao usuarioDao;

	public ClienteBlImpl(ClienteDao clienteDao, UsuarioDao usuarioDao) {
		this.clienteDao = clienteDao;
		this.usuarioDao = usuarioDao;
	}

	@Override
	public void crearCliente(String cedula, String nombres,
			String apellidos, String email, String usuarioCrea) throws MyDaoException {
		
		if (cedula == null || "".equals(cedula.trim())) {
			throw new MyDaoException("Debe especificar la cédula del cliente");
		}
		
		if (nombres == null || "".equals(nombres.trim())) {
			throw new MyDaoException("Debe especificar los nombres del cliente");
		}
		
		if (apellidos == null || "".equals(apellidos.trim())) {
			throw new MyDaoException("Debe especificar los apellidos del cliente");
		}
		
		if (email == null || "".equals(email.trim())) {
			throw new MyDaoException("Debe especificar correo electrónico del cliente");
		}
		
		if (usuarioCrea == null || "".equals(usuarioCrea.trim())) {
			throw new MyDaoException("Debe especificar el login del usuario que crea el cliente");
		}
		
		if(!Validaciones.isEmail(email)){
			throw new MyDaoException("El email debe ser un correo electrónico válido");
		}
		Usuario usuario = usuarioDao.obtener(usuarioCrea.toLowerCase());
		
		if(usuario == null){
			throw new MyDaoException("El usuario crea no existe");
		}
		
		Cliente cliente = clienteDao.obtener(cedula);
		
		if(cliente != null){
			throw new MyDaoException("El cliente ya existe");
		}
		
		cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setApellidos(apellidos);
		cliente.setNombres(nombres);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(false);
	
		clienteDao.guardar(cliente);

	}

	@Override
	public List<Cliente> obtener() throws MyDaoException {
		return clienteDao.obtener();
	}

}
