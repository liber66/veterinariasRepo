package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.socios.jframes.NuevasMascotas;

public class BotonEliminarMascotaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonEliminarMascotaAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Eliminar Mascota");
        putValue(SHORT_DESCRIPTION, "Eliminar Mascota Seleccionada");
        this.nuevasMascotas = nuevasMascotas;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}