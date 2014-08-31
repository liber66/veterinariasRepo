package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.gui.generics.GenericTablePanel;
import veterinarias.socios.jframes.NuevasMascotas;

public class BotonEliminarMascotaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonEliminarMascotaAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Eliminar Mascota");
        putValue(SHORT_DESCRIPTION, "Eliminar Mascota Seleccionada");
        this.nuevasMascotas = nuevasMascotas;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        nuevasMascotas.setEstoyEliminando(true);
        GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
        int rowPosition = tablaMascotas.getSelectedRow();
        //Elimino la ficha clinica del historial y reordeno la tabla
        nuevasMascotas.eiminarFichaClinica(rowPosition);
        tablaMascotas.removeRow(rowPosition);
        nuevasMascotas.limpiarCampos();
        nuevasMascotas.habilitarBotones(false);
        nuevasMascotas.habilitarBotonAgregar(true);
        if (tablaMascotas.isEmpty()) {
            nuevasMascotas.habilitarBotonConfirmar(false);
            tablaMascotas.visualizar(false);
            nuevasMascotas.getLblMascotasIngresadas().setVisible(false);
        }
        nuevasMascotas.setEstoyEliminando(false);
    }
}