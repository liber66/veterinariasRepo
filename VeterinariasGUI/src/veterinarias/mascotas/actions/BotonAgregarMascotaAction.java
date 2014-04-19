package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.socios.jframes.NuevasMascotas;

public class BotonAgregarMascotaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonAgregarMascotaAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Agregar Mascota");
        putValue(SHORT_DESCRIPTION, "Agregar una Mascota");
        this.nuevasMascotas = nuevasMascotas;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}
