package co.edu.udea.iw.bl.impl;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.UsuarioBl;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.iw.util.encode.Cifrar;

/**
 * Implementa {@link UsuarioBl} utilizando Spring
 * @author Elver Suárez Alzate - elver.suarez@udea.edu.co
 * @see UsuarioDao
 *
 */
@Transactional
public class UsuarioBlImpl implements UsuarioBl {

	/**
	 * DAO del usuario que es inyectado por Spring
	 */
	private UsuarioDao usuarioDao;

	@Override
	public Usuario validar(String usuario, String pws) throws MyDaoException {
		Usuario user = null;
		Cifrar cifrar = null;

		if (usuario == null || "".equals(usuario)) {
			throw new MyDaoException("Debe especificar el nombre de usuario");
		}

		user = usuarioDao.obtener(usuario);

		if (user == null) {
			throw new MyDaoException(
					"Nombre de usuario o contraseña incorrecto");
		}

		cifrar = new Cifrar();

		if (!cifrar.encrypt(pws).equals(user.getContrasena())) {
			throw new MyDaoException(
					"Nombre de usuario o contraseña incorrecto");
		}

		return user;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
