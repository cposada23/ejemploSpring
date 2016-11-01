package com.edu.udea.iw.logicaNegocio;

import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

/**
 * Clase para validar la logica del negocio con respecto a los usuarios
 * @author cposa
 *
 */

public interface UsuarioBL {
	
	/**
	 * Valida el usuario y la contraseña en la base de datos
	 * @param usuario
	 * @param pws
	 * @return
	 */
	public boolean validarUP(String usuario, String pws) throws MyDaoExeption;
	
	
	/**
	 * Valida el login y la contraseña 
	 * @param login
	 * @param pws
	 * @return el usuario completo en caso de ser correctas
	 * @throws MyDaoExeption
	 */
	public Usuario validar(String login, String pws) throws MyDaoExeption;
}
