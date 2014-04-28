package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;

import veterinarias.generics.GenericResult;
import veterinarias.gui.generics.GenericTablePanel;
import veterinarias.gui.utils.Util;
import veterinarias.mascotas.contracts.ContractValidarNuevaMascota;
import veterinarias.mascotas.solvers.SolverValidarNuevaMascota;
import veterinarias.objects.trans.MascotaTrans;
import veterinarias.objects.trans.SocioTrans;
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
        SolverValidarNuevaMascota solverValidarNuevaMascota = new SolverValidarNuevaMascota();
        ContractValidarNuevaMascota contractValidarNuevaMascota = this.crearContractValidarNuevaMascota();
        GenericResult genericResult = solverValidarNuevaMascota.solve(contractValidarNuevaMascota);
        if (genericResult != null && genericResult.getErroresNegocio().isEmpty()) {
            GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
            MascotaTrans mascotaTrans = this.crearMascotaTrans();
            Object[] row = { mascotaTrans.getSocioTrans().getNroSocio(), mascotaTrans.getNombre(), mascotaTrans.getFechaNacimiento(), mascotaTrans.getPeso(),
                    mascotaTrans.getEspecie(), mascotaTrans.getRaza(), mascotaTrans.getSexo() };
            int rowPos = tablaMascotas.addRow(row);
            nuevasMascotas.getMascotasTrans().add(rowPos, mascotaTrans);
            tablaMascotas.visualizar(true);
            //Este validate se ejecuta para mostrar la tabla.(sin esto no se visualiza la tabla)
            nuevasMascotas.validate();
        } else { //Hubo errores
            GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
            tablaMascotas.visualizar(false);
        }
    }

    private MascotaTrans crearMascotaTrans() {
        MascotaTrans mascotaTrans = new MascotaTrans();
        mascotaTrans.setFechaNacimiento(new Date());
        mascotaTrans.setFichasClinicasTrans(nuevasMascotas.getFichasClinicasTrans());
        mascotaTrans.setNombre(nuevasMascotas.getTxtNombreMascota().getText());
        mascotaTrans.setPeso(new Long(nuevasMascotas.getTxtPeso().getText()));
        mascotaTrans.setRaza(nuevasMascotas.getTxtRaza().getText());
        mascotaTrans.setEspecie(nuevasMascotas.getTxtEspecie().getText());
        String rbtnSeleccionado = Util.getSelection(nuevasMascotas.getRdbtmSexoGroup()).getText();
        mascotaTrans.setSexo(rbtnSeleccionado.substring(0, 1));
        SocioTrans socioTrans = new SocioTrans();
        socioTrans.setNroSocio(new Long(nuevasMascotas.getTxtNroSocio().getText()));
        mascotaTrans.setSocioTrans(socioTrans);
        return mascotaTrans;
    }

    private ContractValidarNuevaMascota crearContractValidarNuevaMascota() {
        ContractValidarNuevaMascota contractValidarNuevaMascota = new ContractValidarNuevaMascota();
        contractValidarNuevaMascota.setNroSocio(new Long(nuevasMascotas.getTxtNroSocio().getText()));
        contractValidarNuevaMascota.setNombreMascota(nuevasMascotas.getTxtNombreMascota().getText());
        return contractValidarNuevaMascota;
    }
}
