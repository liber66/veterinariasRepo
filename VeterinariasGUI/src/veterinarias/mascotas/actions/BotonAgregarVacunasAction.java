package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

import veterinarias.gui.generics.GenericDialog;
import veterinarias.mascotas.modals.AgregarVacunas;
import veterinarias.objects.trans.GenericCodeTrans;
import veterinarias.objects.trans.VacunaTrans;
import veterinarias.socios.jframes.NuevasMascotas;

public class BotonAgregarVacunasAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonAgregarVacunasAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Agregar Vacunas");
        putValue(SHORT_DESCRIPTION, "Agregar Vacunas a la Mascota");
        this.nuevasMascotas = nuevasMascotas;
    }

    private void cargarDialogo(AgregarVacunas agregarVacunas, String s) {
        JDialog dialog = new GenericDialog(nuevasMascotas, true, agregarVacunas, s);
        dialog.setLocationRelativeTo(nuevasMascotas);
        agregarVacunas.setDialog(dialog);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        /*dialog.addWindowListener(new WindowAdapter() {

            public void windowClosed(WindowEvent e) {
                nuevasMascotas.setAgregarVacunas(null);
            }
        });*/
        //Seteo Dimensiones minimas al modal y lo muestro.
        dialog.setMinimumSize(dialog.getSize());
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        AgregarVacunas agregarVacunas = new AgregarVacunas();
        List<VacunaTrans> vacunasTrans = nuevasMascotas.getVacunasTrans();
        if (vacunasTrans != null) {
            for (VacunaTrans vacunaTrans : vacunasTrans) {
                GenericCodeTrans codVacuna = vacunaTrans.getCodVacuna();
                agregarVacunas.clickearCheckBox(codVacuna.getCodigo(), vacunaTrans.getFechaDosis());
            }
        }
        cargarDialogo(agregarVacunas, "Agregar Vacunas");
    }
}
