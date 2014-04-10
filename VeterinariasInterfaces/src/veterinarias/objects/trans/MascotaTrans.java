package veterinarias.objects.trans;

import java.util.Date;
import java.util.List;

public class MascotaTrans {

    private SocioTrans socioTrans;
    private String nombre;
    private Date fechaNacimiento;
    private Long peso;
    private String informacion;
    private Character muerta;
    private List<VacunaTrans> vacunasTrans;

    public SocioTrans getSocioTrans() {
        return socioTrans;
    }

    public void setSocioTrans(SocioTrans socioTrans) {
        this.socioTrans = socioTrans;
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

    public List<VacunaTrans> getVacunasTrans() {
        return vacunasTrans;
    }

    public void setVacunasTrans(List<VacunaTrans> vacunasTrans) {
        this.vacunasTrans = vacunasTrans;
    }
}
