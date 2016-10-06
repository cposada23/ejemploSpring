package com.edu.udea.iw.logicaNegocio.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.UsuarioBL;
import com.edu.udea.iw.utils.Hash;


public class UsuarioBLimp implements UsuarioBL {
	
	
	
	private UsuarioDao usuarioDao;
	
	
	
	public UsuarioDao getDao() {
		return usuarioDao;
	}

	public void setDao(UsuarioDao dao) {
		this.usuarioDao = dao;
	}

	
	
	
	@Override
	public boolean validarUP(String usuario, String pws) throws MyDaoExeption {
		// TODO Auto-generated method stub
		Usuario  user = usuarioDao.obtenerPorLogin(usuario);
		
		if(user.getContrasena().equals(Hash.getHash(pws, "SHA1"))){
			return true;
		}
		
		return false;
	}

}
