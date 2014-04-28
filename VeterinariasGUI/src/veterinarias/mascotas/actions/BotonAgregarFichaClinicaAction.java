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
    private IngresarFichaClinica ingresarFichaClinica;

    public BotonAgregarFichaClinicaAction(NuevasMascotas nuevasMascotas, String buttonName) {
        putValue(NAME, buttonName);
        putValue(SHORT_DESCRIPTION, "Agregar una Ficha Clinica a la Mascota");
        this.nuevasMascotas = nuevasMascotas;
    }

    private void cargarDialogo(IngresarFichaClinica ingresarFichaClinica, String s) {
        JDialog dialog = new GenericDialog(NuevasMascotas.getMainMenu(), true, ingresarFichaClinica, s);
        dialog.setLocationRelativeTo(NuevasMascotas.getMainMenu());
        ingresarFichaClinica.setDialog(dialog);
        //Seteo Dimensiones minimas al modal y lo muestro.
        dialog.setMinimumSize(dialog.getSize());
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (ingresarFichaClinica == null) {
            ingresarFichaClinica = new IngresarFichaClinica(nuevasMascotas);
        }
        cargarDialogo(ingresarFichaClinica, "Ingresar Ficha Clinica");
    }
}
