package com.edu.udea.iw.logicaNegocio.imp;




import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.UsuarioBL;
import com.edu.udea.iw.utils.Hash;
import com.edu.udea.iw.utils.Base64Coder;
import com.edu.udea.iw.utils.Cifrar;

/**
 * implementacion de la interfaz UsuarioBL
 * @author cposa
 *
 */
public class UsuarioBLimp implements UsuarioBL {
	
	
	
	private UsuarioDao usuarioDao;
	
	private Cifrar  cifrar = new Cifrar();
	
	public UsuarioDao getDao() {
		return usuarioDao;
	}

	public void setDao(UsuarioDao dao) {
		this.usuarioDao = dao;
	}

	
	
	
	@Override
	public boolean validarUP(String usuario, String pws) throws MyDaoExeption {
		// TODO Auto-generated method stub
		System.out.println(cifrar.encrypt(pws));
		
		Usuario  user = usuarioDao.obtenerPorLogin(usuario);
		
		if(user.getContrasena().equals(cifrar.encrypt(pws))){
			return true;
		}
		
		return false;
	}

}
