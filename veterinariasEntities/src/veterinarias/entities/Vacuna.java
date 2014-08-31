package veterinarias.entities;

import java.util.Date;

import veterinarias.generics.GenericEntity;

public class Vacuna extends GenericEntity {

    private Mascota mascota;
    private GenericCode codVacuna;
    private Date fechaDosis;

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public GenericCode getCodVacuna() {
        return codVacuna;
    }

    public void setCodVacuna(GenericCode codVacuna) {
        this.codVacuna = codVacuna;
    }

    public Date getFechaDosis() {
        return fechaDosis;
    }

    public void setFechaDosis(Date fechaDosis) {
        this.fechaDosis = fechaDosis;
    }
}