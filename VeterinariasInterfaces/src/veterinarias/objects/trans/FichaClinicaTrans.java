package veterinarias.objects.trans;

import java.util.Date;

public class FichaClinicaTrans {

    private MascotaTrans mascota;
    private Date fecha;
    private String informacion;

    public MascotaTrans getMascota() {
        return mascota;
    }

    public void setMascota(MascotaTrans mascota) {
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
