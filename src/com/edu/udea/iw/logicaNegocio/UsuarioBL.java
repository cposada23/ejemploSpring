package com.edu.udea.iw.logicaNegocio;

import com.edu.udea.iw.exeption.MyDaoExeption;

/**
 * Clase para validar la logica del negocio 
 * @author cposa
 *
 */

public interface UsuarioBL {
	
	/**
	 * Valida el usuario y la contraseņa en la base de datos
	 * @param usuario
	 * @param pws
	 * @return
	 */
	public boolean validarUP(String usuario, String pws) throws MyDaoExeption;
}
