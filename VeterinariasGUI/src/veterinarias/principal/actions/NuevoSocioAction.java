package veterinarias.principal.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.socios.jframes.NuevoSocio;

public class NuevoSocioAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    public NuevoSocioAction() {
        putValue(NAME, "Nuevo Socio");
        putValue(SHORT_DESCRIPTION, "Agregar un Socio");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        NuevoSocio nuevoSocio = new NuevoSocio();
        nuevoSocio.setVisible(true);
    }
}
