package veterinarias.mascotas.contracts;

import veterinarias.generics.GenericContract;

public class ContractValidarNuevaMascota extends GenericContract {

    private static final long serialVersionUID = 1L;
    private Long nroSocio;
    private String nombreMascota;

    public Long getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(Long nroSocio) {
        this.nroSocio = nroSocio;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
}
