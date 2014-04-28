package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import veterinarias.gui.utils.Util;
import veterinarias.interfaces.utils.Calendario;
import veterinarias.interfaces.utils.Fecha;
import veterinarias.mascotas.contracts.ContractValidarNuevaMascota;
import veterinarias.objects.trans.MascotaTrans;
import veterinarias.objects.trans.SocioTrans;
import veterinarias.socios.jframes.NuevasMascotas;

public class BotonModificarMascotaAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonModificarMascotaAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Modificar Mascota");
        putValue(SHORT_DESCRIPTION, "Modificar Mascota Seleccionada");
        this.nuevasMascotas = nuevasMascotas;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        /* SolverValidarNuevaMascota solverValidarNuevaMascota = new SolverValidarNuevaMascota();
         ContractValidarNuevaMascota contractValidarNuevaMascota = this.crearContractValidarNuevaMascota();
         GenericResult genericResult = solverValidarNuevaMascota.solve(contractValidarNuevaMascota);
         if (genericResult != null && genericResult.getErroresNegocio().isEmpty()) {
             GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
             MascotaTrans mascotaTrans = this.crearMascotaTrans();
             Object[] row = { mascotaTrans.getSocioTrans().getNroSocio(), mascotaTrans.getNombre(), mascotaTrans.getFechaNacimiento().toString(Calendario.DMA),
                     mascotaTrans.getPeso(), mascotaTrans.getEspecie(), mascotaTrans.getRaza(), mascotaTrans.getSexo() };
             int rowPos = tablaMascotas.addRow(row);
             nuevasMascotas.getMascotasTrans().add(rowPos, mascotaTrans);
             tablaMascotas.visualizar(true);
             //Este validate se ejecuta para mostrar la tabla.(sin esto no se visualiza la tabla)
             nuevasMascotas.validate();
         } else { //Hubo errores
             GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
             tablaMascotas.visualizar(false);
         }*/
    }

    private MascotaTrans crearMascotaTrans() {
        MascotaTrans mascotaTrans = new MascotaTrans();
        Fecha fecha = new Fecha(nuevasMascotas.getTxtFechaNacimiento().getText(), Calendario.DMA);
        mascotaTrans.setFechaNacimiento(fecha);
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