package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
        String informacion = ingresarFichaClinica.getTxtInformacion().getText();
        //si informacion contiene solo espacios en blanco => pasarlo a null.
        ingresarFichaClinica.getNuevasMascotas().agregarFichaClinica(informacion);
        //Cierro Dialog
        ingresarFichaClinica.getDialog().dispose();
    }
}
