package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.gui.generics.GenericTabbedPane;
import veterinarias.mascotas.modals.IngresarFichaClinica;

public class BotonConfirmarFichaClinicaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private IngresarFichaClinica ingresarFichaClinica;

    public BotonConfirmarFichaClinicaAction(IngresarFichaClinica ingresarFichaClinica) {
        putValue(NAME, "Confirmar");
        putValue(SHORT_DESCRIPTION, "Confirmar una Ficha Clinica a la Mascota");
        this.ingresarFichaClinica = ingresarFichaClinica;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        GenericTabbedPane tabbedPane = ingresarFichaClinica.getTabbedPane();
        //si informacion contiene solo espacios en blanco => pasarlo a null.
        ingresarFichaClinica.getNuevasMascotas().agregarFichasClinicas(tabbedPane);
        //Cierro Dialog
        //ingresarFichaClinica.getDialog().dispose();
        //Escondo el dialogo
        //To do: cuando se confirma el ingreso de una mascota se debe hacer el dispose del dialogo.
        ingresarFichaClinica.getDialog().setVisible(false);
    }
}
