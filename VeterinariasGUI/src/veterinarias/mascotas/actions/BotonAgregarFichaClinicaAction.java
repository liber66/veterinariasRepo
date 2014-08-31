package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

import veterinarias.gui.generics.GenericDialog;
import veterinarias.mascotas.modals.IngresarFichaClinica;
import veterinarias.objects.trans.FichaClinicaTrans;
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
        JDialog dialog = new GenericDialog(nuevasMascotas, true, ingresarFichaClinica, s);
        dialog.setLocationRelativeTo(nuevasMascotas);
        ingresarFichaClinica.setDialog(dialog);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //Seteo Dimensiones minimas al modal y lo muestro.
        dialog.setMinimumSize(dialog.getSize());
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        IngresarFichaClinica ingresarFichaClinica = new IngresarFichaClinica(nuevasMascotas);
        List<FichaClinicaTrans> fichasClinicasTrans = nuevasMascotas.getFichasClinicasTrans();
        if (fichasClinicasTrans != null) {
            ingresarFichaClinica.agregarFichaClinica(fichasClinicasTrans);
        }
        cargarDialogo(ingresarFichaClinica, "Agregar Vacunas");
    }
}
