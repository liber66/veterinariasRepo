package veterinarias.principal.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.mascotas.jframes.BuscarMascota;

public class BuscarMascotaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    public BuscarMascotaAction() {
        putValue(NAME, "Buscar Mascota");
        putValue(SHORT_DESCRIPTION, "Buscar Mascota");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        BuscarMascota buscarMascota = new BuscarMascota();
        buscarMascota.setVisible(true);
    }
}
