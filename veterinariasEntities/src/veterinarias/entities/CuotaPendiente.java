package veterinarias.entities;

import java.util.Date;

public class CuotaPendiente {
	
	private Socio socio;
	private Date fechaCuota;
	private String descripcion;
	private Date fechaPago;
	
	public Socio getSocio() {
		return socio;
	}
	
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	public Date getFechaCuota() {
		return fechaCuota;
	}
	
	public void setFechaCuota(Date fechaCuota) {
		this.fechaCuota = fechaCuota;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

}