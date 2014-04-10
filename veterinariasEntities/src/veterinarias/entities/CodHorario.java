package veterinarias.entities;

import veterinarias.generics.GenericEntity;

public class CodHorario extends GenericEntity {
	
	private Long codDia;
	private String descripcion;
	
	public Long getCodDia() {
		return codDia;
	}
	
	public void setCodDia(Long codDia) {
		this.codDia = codDia;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}