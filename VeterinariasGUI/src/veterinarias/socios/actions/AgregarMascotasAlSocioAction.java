package veterinarias.socios.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.socios.jframes.AgregarMascotasAlSocio;
import veterinarias.socios.jframes.NuevoSocio;

public class AgregarMascotasAlSocioAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevoSocio nuevoSocio;

    public AgregarMascotasAlSocioAction(NuevoSocio nuevoSocio) {
        putValue(NAME, "Agregar Mascotas");
        putValue(SHORT_DESCRIPTION, "Agregar Mascotas al Socio");
        this.nuevoSocio = nuevoSocio;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        AgregarMascotasAlSocio agregarMascotasAlSocio = new AgregarMascotasAlSocio();
        agregarMascotasAlSocio.getTxtNroSocio().setText(nuevoSocio.getTxtNroSocio().getText());
        agregarMascotasAlSocio.setVisible(true);
    }
}
