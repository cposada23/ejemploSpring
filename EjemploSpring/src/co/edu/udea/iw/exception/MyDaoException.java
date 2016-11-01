package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

/**
 * Clase implementada para el manejo de las excepciones propias
 * @author Elver Suárez Alzate
 *
 */
public class MyDaoException extends Exception {
	
	Logger log = Logger.getLogger(this.getClass());

	public MyDaoException(String message, Throwable cause) {
		super(message, cause);
		log.error(message);
	}

	public MyDaoException(Throwable cause) {
		super(cause);
		log.error(cause.getMessage());
	}
	
	public MyDaoException(String cause) {
		super(cause);
		log.error(cause);
	}
}
