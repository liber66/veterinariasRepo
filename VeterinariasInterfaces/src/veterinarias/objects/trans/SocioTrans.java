package veterinarias.objects.trans;

import java.util.List;

public class SocioTrans {

    private Long nroSocio;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String celular;
    private String direccion;
    private String cobrador;
    private List<MascotaTrans> mascotasTrans;
    private List<CuotaPendienteTrans> cuotasPendientesTrans;

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

    public String getCobrador() {
        return cobrador;
    }

    public void setCobrador(String cobrador) {
        this.cobrador = cobrador;
    }

    public List<MascotaTrans> getMascotasTrans() {
        return mascotasTrans;
    }

    public void setMascotasTrans(List<MascotaTrans> mascotasTrans) {
        this.mascotasTrans = mascotasTrans;
    }

    public List<CuotaPendienteTrans> getCuotasPendientesTrans() {
        return cuotasPendientesTrans;
    }

    public void setCuotasPendientesTrans(List<CuotaPendienteTrans> cuotasPendientesTrans) {
        this.cuotasPendientesTrans = cuotasPendientesTrans;
    }
}
