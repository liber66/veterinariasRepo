package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.consultas.jpanels.NuevoSocio;

public class BotonAgregarMascotaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevoSocio nuevoSocio;

    public BotonAgregarMascotaAction(NuevoSocio nuevoSocio) {
        putValue(NAME, "Agregar Mascota");
        putValue(SHORT_DESCRIPTION, "Agregar una Mascota");
        this.nuevoSocio = nuevoSocio;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    }
}
