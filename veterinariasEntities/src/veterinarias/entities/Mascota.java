package veterinarias.entities;

import java.util.Date;
import java.util.List;

public class Mascota {
	
	private Socio socio;
	private String nombre;
	private Date fechaNacimiento;
	private Long peso;
	private String informacion;
	private Character muerta;
	private List<Vacuna> vacunas;

	public Socio getSocio() {
		return socio;
	}
	
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Long getPeso() {
		return peso;
	}
	
	public void setPeso(Long peso) {
		this.peso = peso;
	}
	
	public String getInformacion() {
		return informacion;
	}
	
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
	public Character getMuerta() {
		return muerta;
	}
	
	public void setMuerta(Character muerta) {
		this.muerta = muerta;
	}
	
	public List<Vacuna> getVacunas() {
		return vacunas;
	}
	
	public void setVacunas(List<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}

}