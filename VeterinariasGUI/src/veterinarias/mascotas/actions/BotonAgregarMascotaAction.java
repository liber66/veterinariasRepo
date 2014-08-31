package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.generics.GenericResult;
import veterinarias.gui.generics.GenericTablePanel;
import veterinarias.gui.utils.Util;
import veterinarias.interfaces.utils.Calendario;
import veterinarias.interfaces.utils.Fecha;
import veterinarias.mascotas.contracts.ContractValidarNuevaMascota;
import veterinarias.mascotas.solvers.SolverValidarNuevaMascota;
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
        nuevasMascotas.setEstoyAgregando(true);
        SolverValidarNuevaMascota solverValidarNuevaMascota = new SolverValidarNuevaMascota();
        ContractValidarNuevaMascota contractValidarNuevaMascota = this.crearContractValidarNuevaMascota();
        GenericResult genericResult = solverValidarNuevaMascota.solve(contractValidarNuevaMascota);
        if (genericResult != null && genericResult.getErroresNegocio().isEmpty()) {
            GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
            Object[] row = this.crearFilaNueva();
            int rowPos = tablaMascotas.addRow(row);
            nuevasMascotas.agregarFichaClinica(rowPos, nuevasMascotas.getIngresarFichaClinica());
            nuevasMascotas.habilitarBotones(false);
            nuevasMascotas.habilitarBotonConfirmar(true);
            nuevasMascotas.getLblMascotasIngresadas().setVisible(true);
            tablaMascotas.clearSelection();
            tablaMascotas.visualizar(true);
            nuevasMascotas.limpiarCampos();
            //Este validate se ejecuta para mostrar la tabla.(sin esto no se visualiza la tabla)
            //nuevasMascotas.validate();
        } else { //Hubo errores
            GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
            tablaMascotas.visualizar(false);
        }
        nuevasMascotas.setEstoyAgregando(false);
    }

    private Object[] crearFilaNueva() {
        Long nroSocio = new Long(nuevasMascotas.getTxtNroSocio().getText());
        String nombre = nuevasMascotas.getTxtNombreMascota().getText();
        Fecha fechaNacimiento = new Fecha(nuevasMascotas.getTxtFechaNacimiento().getText(), Calendario.DMA);
        Long peso = new Long(nuevasMascotas.getTxtPeso().getText());
        String especie = nuevasMascotas.getTxtEspecie().getText();
        String raza = nuevasMascotas.getTxtRaza().getText();
        String rbtnSeleccionado = Util.getSelection(nuevasMascotas.getRdbtmSexoGroup()).getText();
        Object[] row = { nroSocio, nombre, fechaNacimiento.toString(Calendario.DMA), peso, especie, raza, rbtnSeleccionado.substring(0, 1) };
        return row;
    }

    private ContractValidarNuevaMascota crearContractValidarNuevaMascota() {
        ContractValidarNuevaMascota contractValidarNuevaMascota = new ContractValidarNuevaMascota();
        contractValidarNuevaMascota.setNroSocio(new Long(nuevasMascotas.getTxtNroSocio().getText()));
        contractValidarNuevaMascota.setNombreMascota(nuevasMascotas.getTxtNombreMascota().getText());
        return contractValidarNuevaMascota;
    }
}
