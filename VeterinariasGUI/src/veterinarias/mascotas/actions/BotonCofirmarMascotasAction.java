package veterinarias.mascotas.actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;

import veterinarias.generics.GenericResult;
import veterinarias.gui.generics.GenericTablePanel;
import veterinarias.interfaces.utils.Fecha;
import veterinarias.mascotas.contracts.ContractConfirmarMascotas;
import veterinarias.mascotas.modals.IngresarFichaClinica;
import veterinarias.mascotas.solvers.SolverConfirmarMascotas;
import veterinarias.objects.trans.MascotaTrans;
import veterinarias.objects.trans.SocioTrans;
import veterinarias.socios.jframes.NuevasMascotas;
import veterinarias.util.Convertidor;

public class BotonCofirmarMascotasAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevasMascotas nuevasMascotas;

    public BotonCofirmarMascotasAction(NuevasMascotas nuevasMascotas) {
        putValue(NAME, "Confirmar");
        putValue(SHORT_DESCRIPTION, "Confirmar Mascotas");
        this.nuevasMascotas = nuevasMascotas;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Convertidor convertidor = new Convertidor();
        GenericTablePanel tablaMascotas = nuevasMascotas.getTablaMascotas();
        Object[][] filas = tablaMascotas.getRows();
        List<MascotaTrans> listMascotasTrans = new ArrayList<MascotaTrans>();
        if (filas != null) {
            List<IngresarFichaClinica> listIngresarFichaCLinica = nuevasMascotas.getFichasClinicasIngresadas();
            for (int i = 0; i < filas.length; i++) {
                MascotaTrans mascotaTrans = new MascotaTrans();
                Object[] mascotaNueva = filas[i];
                SocioTrans socioTrans = new SocioTrans();
                socioTrans.setNroSocio((Long) mascotaNueva[0]);
                mascotaTrans.setSocioTrans(socioTrans);
                mascotaTrans.setNombre((String) mascotaNueva[1]);
                Fecha fechaNacimiento = convertidor.convertStringToFecha((String) mascotaNueva[2]);
                mascotaTrans.setFechaNacimiento(fechaNacimiento);
                mascotaTrans.setPeso((Long) mascotaNueva[3]);
                mascotaTrans.setEspecie((String) mascotaNueva[4]);
                mascotaTrans.setRaza((String) mascotaNueva[5]);
                mascotaTrans.setSexo((String) mascotaNueva[6]);
                IngresarFichaClinica ingresarFichaCLinica = listIngresarFichaCLinica.get(i);
                if (ingresarFichaCLinica != null) {
                    mascotaTrans.setFichasClinicasTrans(ingresarFichaCLinica.getFichasClinicasTrans());
                }
                mascotaTrans.setMuerta("N");
                listMascotasTrans.add(mascotaTrans);
            }
        }
        ContractConfirmarMascotas contractConfirmarMascotas = new ContractConfirmarMascotas();
        contractConfirmarMascotas.setListMascotasTrans(listMascotasTrans);
        SolverConfirmarMascotas solverConfirmarMascotas = new SolverConfirmarMascotas();
        GenericResult genericResult = solverConfirmarMascotas.solve(contractConfirmarMascotas);
        if (genericResult != null && genericResult.getErroresNegocio().isEmpty()) {
            nuevasMascotas.dispose();
        }
    }
}
