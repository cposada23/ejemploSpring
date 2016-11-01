package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Clase DTO para la clave primaria de la tabla direcciones
 * @author Elver Suárez Alzate - elver.suarez@udea.edu.co
 *
 */
public class DireccionId implements Serializable{
	
	private Cliente cliente;
	private Integer codigo;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
