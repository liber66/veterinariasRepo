package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

import veterinarias.gui.generics.GenericDialog;
import veterinarias.mascotas.modals.IngresarFichaClinica;
import veterinarias.socios.jframes.NuevasMascotas;

public class BotonAgregarFichaClinicaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonAgregarFichaClinicaAction(NuevasMascotas nuevasMascotas, String buttonName) {
        putValue(NAME, buttonName);
        putValue(SHORT_DESCRIPTION, "Agregar una Ficha Clinica a la Mascota");
        this.nuevasMascotas = nuevasMascotas;
    }

    private void cargarDialogo(IngresarFichaClinica ingresarFichaClinica, String s) {
        JDialog dialog = new GenericDialog(NuevasMascotas.getMainMenu(), true, ingresarFichaClinica, s);
        dialog.setLocationRelativeTo(NuevasMascotas.getMainMenu());
        ingresarFichaClinica.setDialog(dialog);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        cargarDialogo(new IngresarFichaClinica(nuevasMascotas), "Ingresar Ficha Clinica");
    }
}
