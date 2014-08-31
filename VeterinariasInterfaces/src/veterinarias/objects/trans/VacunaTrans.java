package veterinarias.objects.trans;

import veterinarias.interfaces.utils.Fecha;

public class VacunaTrans {

    private MascotaTrans mascotaTrans;
    private GenericCodeTrans codVacuna;
    private Fecha fechaDosis;

    public MascotaTrans getMascotaTrans() {
        return mascotaTrans;
    }

    public void setMascotaTrans(MascotaTrans mascotaTrans) {
        this.mascotaTrans = mascotaTrans;
    }

    public GenericCodeTrans getCodVacuna() {
        return codVacuna;
    }

    public void setCodVacuna(GenericCodeTrans codVacuna) {
        this.codVacuna = codVacuna;
    }

    public Fecha getFechaDosis() {
        return fechaDosis;
    }

    public void setFechaDosis(Fecha fechaDosis) {
        this.fechaDosis = fechaDosis;
    }
}
