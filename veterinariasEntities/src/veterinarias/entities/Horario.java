package veterinarias.entities;

import java.util.Date;

import veterinarias.generics.GenericEntity;

public class Horario extends GenericEntity {
	
	private CodHorario codHorario;
	private Date fechaInicio;
	private Date fechaFin;
	private String descripcion;
	private Long nroSocio;

	public CodHorario getCodHorario() {
		return codHorario;
	}
	
	public void setCodHorario(CodHorario codHorario) {
		this.codHorario = codHorario;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Long getNroSocio() {
		return nroSocio;
	}
	
	public void setNroSocio(Long nroSocio) {
		this.nroSocio = nroSocio;
	}

}