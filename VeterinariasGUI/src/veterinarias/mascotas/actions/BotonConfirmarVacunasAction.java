package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.mascotas.modals.AgregarVacunas;
import veterinarias.socios.jframes.NuevasMascotas;

public class BotonConfirmarVacunasAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private AgregarVacunas agregarVacunas;

    public BotonConfirmarVacunasAction(AgregarVacunas agregarVacunas) {
        putValue(NAME, "Confirmar");
        putValue(SHORT_DESCRIPTION, "Confirmar Vacunas");
        this.agregarVacunas = agregarVacunas;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        NuevasMascotas nuevasMascotas = (NuevasMascotas) agregarVacunas.getDialog().getParent();
        nuevasMascotas.setVacunasTrans(agregarVacunas.getVacunasTrans());
        agregarVacunas.getDialog().dispose();
    }
}
