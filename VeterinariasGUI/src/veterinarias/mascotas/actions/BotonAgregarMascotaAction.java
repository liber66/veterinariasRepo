package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.mascotas.contracts.ContractNuevaMascota;
import veterinarias.socios.jframes.NuevasMascotas;

public class BotonAgregarMascotaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonAgregarMascotaAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Agregar Mascota");
        putValue(SHORT_DESCRIPTION, "Agregar una Mascota");
        this.nuevasMascotas = nuevasMascotas;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ContractNuevaMascota contractNuevaMascota = new ContractNuevaMascota();
        contractNuevaMascota.setNroSocio(new Long(nuevasMascotas.getTxtNroSocio().getText()));
        contractNuevaMascota.setNombreMascota(nuevasMascotas.getTxtNombreMascota().getText());
        //contractNuevaMascota.setFechaNacimiento(nuevasMascotas.getTxtFechaNacimiento().getText());
        contractNuevaMascota.setPeso(new Long(nuevasMascotas.getTxtPeso().getText()));
        contractNuevaMascota.setEspecie(nuevasMascotas.getTxtEspecie().getText());
        contractNuevaMascota.setRaza(nuevasMascotas.getTxtRaza().getText());
        //int rbtnSeleccionado = nuevasMascotas.getRdbtmSexoGroup().getSelection().getMnemonic();
        //contractNuevaMascota.setSexo();
    }
}
