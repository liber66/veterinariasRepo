package veterinarias.principal.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.socios.jframes.NuevasMascotas;

public class NuevasMascotasAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    public NuevasMascotasAction() {
        putValue(NAME, "Agregar Mascotas");
        putValue(SHORT_DESCRIPTION, "Agregar Mascotas al Socio");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        NuevasMascotas nuevasMascotas = new NuevasMascotas();
        nuevasMascotas.setVisible(true);
    }
}
