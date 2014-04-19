package veterinarias.mascotas.actions;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

import veterinarias.gui.generics.GenericDialog;
import veterinarias.mascotas.modals.IngresarFichaClinica;
import veterinarias.socios.jframes.NuevasMascotas;

public class BotonAgregarFichaClinicaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonAgregarFichaClinicaAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Agregar Ficha Clinica");
        putValue(SHORT_DESCRIPTION, "Agregar una Ficah Clinica a la Mascota");
        this.nuevasMascotas = nuevasMascotas;
    }

    private void cargarDialogo(Container c, String s) {
        JDialog dialog = new GenericDialog(NuevasMascotas.getMainMenu(), true, c, s);
        dialog.setLocationRelativeTo(NuevasMascotas.getMainMenu());
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        cargarDialogo(new IngresarFichaClinica(), "Ingresar Ficha Clinica");
    }
}
