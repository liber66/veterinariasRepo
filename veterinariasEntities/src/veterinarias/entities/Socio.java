package veterinarias.entities;

import java.util.List;

public class Socio {
	
	private Long nroSocio;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String telefono;
	private String celular;
	private String direccion;
	private Character cobrador;
	private List<Mascota> mascotas;
	private List<CuotaPendiente> cuotasPendientes;
	
	public Long getNroSocio() {
		return nroSocio;
	}
	
	public void setNroSocio(Long nroSocio) {
		this.nroSocio = nroSocio;
	}
	
	public String getPrimerNombre() {
		return primerNombre;
	}
	
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	
	public String getSegundoNombre() {
		return segundoNombre;
	}
	
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	
	public String getPrimerApellido() {
		return primerApellido;
	}
	
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	
	public String getSegundoApellido() {
		return segundoApellido;
	}
	
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Character getCobrador() {
		return cobrador;
	}
	
	public void setCobrador(Character cobrador) {
		this.cobrador = cobrador;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public List<CuotaPendiente> getCuotasPendientes() {
		return cuotasPendientes;
	}

	public void setCuotasPendientes(List<CuotaPendiente> cuotasPendientes) {
		this.cuotasPendientes = cuotasPendientes;
	}
	
}