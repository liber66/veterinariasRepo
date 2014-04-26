package veterinarias.entities;

import java.util.Date;

import veterinarias.generics.GenericEntity;

public class FichaClinica extends GenericEntity {

    private Mascota mascota;
    private Date fecha;
    private String informacion;

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
