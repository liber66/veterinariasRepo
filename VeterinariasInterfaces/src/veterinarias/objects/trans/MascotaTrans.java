package veterinarias.objects.trans;

import java.util.List;

import veterinarias.interfaces.utils.Fecha;

public class MascotaTrans {

    private SocioTrans socioTrans;
    private String nombre;
    private Fecha fechaNacimiento;
    private Long peso;
    private String informacion;
    private String raza;
    private String especie;
    private String sexo;
    private String muerta;
    private List<VacunaTrans> vacunasTrans;
    private List<FichaClinicaTrans> fichasClinicasTrans;

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

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
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

    public String getMuerta() {
        return muerta;
    }

    public void setMuerta(String muerta) {
        this.muerta = muerta;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public List<VacunaTrans> getVacunasTrans() {
        return vacunasTrans;
    }

    public void setVacunasTrans(List<VacunaTrans> vacunasTrans) {
        this.vacunasTrans = vacunasTrans;
    }

    public List<FichaClinicaTrans> getFichasClinicasTrans() {
        return fichasClinicasTrans;
    }

    public void setFichasClinicasTrans(List<FichaClinicaTrans> fichasClinicasTrans) {
        this.fichasClinicasTrans = fichasClinicasTrans;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
