package com.edu.udea.iw.logicaNegocio.imp;

import java.util.Date;
import java.util.List;

import com.edu.udea.iw.dao.ClienteDao;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.ClienteBL;
import com.edu.udea.iw.utils.Validaciones;


/**
 * @see ClienteBL
 * @author cposa
 *
 */

public class ClienteBLimp implements ClienteBL {

	private ClienteDao clienteDao;
	private UsuarioDao usuarioDao;
	
	
	public ClienteBLimp(ClienteDao clienteDao, UsuarioDao usuarioDao) {
		this.clienteDao = clienteDao;
		this.usuarioDao = usuarioDao;
	}
	
	@Override
	public void crearCliente(Cliente cliente) throws MyDaoExeption {
		// TODO Auto-generated method stub
		if(cliente == null){
			throw new NullPointerException("Cliente no puede ser null");
		}
		
		if(cliente != null ){
			if("".equals(cliente.getCedula())){
				throw new MyDaoExeption("Se debe especificar la cédula del cliente", null);
			}
			clienteDao.crear(cliente);
		}
	
	}

	@Override
	public void crearCliente2(String cedula, String nombres, String apellidos, String email, String usuarioCrea)
			throws MyDaoExeption {
		
		if("".equals(cedula.trim()) || cedula == null){ //Trim quita los espacion en blanco
			throw new MyDaoExeption("Se debe especificar la cédula del cliente", null);
		}
		if("".equals(nombres.trim()) || nombres == null){

			throw new MyDaoExeption("Se debe especificar el nombre", null);
		}
		if("".equals(apellidos.trim()) || apellidos == null){

			throw new MyDaoExeption("Se debe especificar los apellidos", null);
		}
		if("".equals(email.trim()) || email == null){

			throw new MyDaoExeption("Se debe especificar el email", null);
		}if("".equals(usuarioCrea.trim()) || usuarioCrea == null){

			throw new MyDaoExeption("Se debe especificar el usuario que creo el cliente", null);
		}
		if(!Validaciones.isEmail(email)){
			throw new MyDaoExeption("El email tiene que tener un formato correcto", null);
		}
		Usuario usuario = usuarioDao.obtenerPorLogin(usuarioCrea);
		
		if(usuario == null){
			throw new MyDaoExeption("El usuario que crea no existe", null);
		}
		// Debo validar que el cliente no exista if(cliente)
		
		if(clienteDao.obtenerPorCedula(cedula)!=null){
			throw new MyDaoExeption("El cliente ya existe en la bd", null);
		}
		
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(false);
		
		
		clienteDao.crear(cliente);
	}

	@Override
	public List<Cliente> obtener() throws MyDaoExeption {
		return clienteDao.obtener();
	}

}
