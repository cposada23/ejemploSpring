package com.edu.udea.iw.logicaNegocio;

import java.util.List;

import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exeption.MyDaoExeption;

/**
 * Clase para la logica del negocio con respecto a los clientes
 * @author Camilo Posada Angel -- cposadaa@gmail.com
 *
 */
public interface ClienteBL {
	
	/**
	 * 
	 * @param cliente
	 * @throws MyDaoExeption {@link NullPointerException}}
	 */ 
	public void crearCliente(Cliente cliente) throws MyDaoExeption;
	
	/**
	 * 
	 * @param cedula
	 * @param nombres
	 * @param apellidos
	 * @param email
	 * @param usuarioCrea
	 * @throws MyDaoExeption
	 */
	
	public void crearCliente2(String cedula, String nombres, String apellidos, String email, String usuarioCrea) throws MyDaoExeption;

	
	
	public List<Cliente> obtener() throws MyDaoExeption;
} 
