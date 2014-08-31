package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.gui.generics.GenericTablePanel;
import veterinarias.socios.jframes.NuevasMascotas;

public class BotonLimpiarAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonLimpiarAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Limpiar");
        putValue(SHORT_DESCRIPTION, "Limpia todos los campos ingresados");
        this.nuevasMascotas = nuevasMascotas;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
        if (!tablaMascotas.isEmpty()) {
            tablaMascotas.clearSelection();
            nuevasMascotas.habilitarBotonAgregar(true);
            nuevasMascotas.habilitarBotones(false);
        }
        nuevasMascotas.limpiarCampos();
    }
}