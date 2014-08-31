package veterinarias.objects.trans;

import veterinarias.interfaces.utils.Fecha;

public class FichaClinicaTrans {

    private MascotaTrans mascota;
    private Fecha fecha;
    private String informacion;

    public MascotaTrans getMascota() {
        return mascota;
    }

    public void setMascota(MascotaTrans mascota) {
        this.mascota = mascota;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public boolean isEmpty() {
        return informacion == null || informacion.isEmpty();
    }
}
