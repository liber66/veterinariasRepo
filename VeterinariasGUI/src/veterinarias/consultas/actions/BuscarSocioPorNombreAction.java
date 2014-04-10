package veterinarias.consultas.actions;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

import veterinarias.consultas.jpanels.VerSociosPorNombre;
import veterinarias.gui.generics.GenericDialog;
import veterinarias.gui.principal.PrincipalJFrame;

public class BuscarSocioPorNombreAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    public BuscarSocioPorNombreAction() {
        putValue(NAME, "Por Nombre");
        putValue(SHORT_DESCRIPTION, "Buscar Socio por nombre");
    }

    private void cargarDialogo(Container c, String s) {
        JDialog dialog = new GenericDialog(PrincipalJFrame.getMainMenu(), true, c, s);
        dialog.setLocationRelativeTo(PrincipalJFrame.getMainMenu());
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cargarDialogo(new VerSociosPorNombre(), "Ver Socios Por Nombre");
        /*ContractObtSociosPorNombre contractObtSociosPorNombre = new ContractObtSociosPorNombre();
        contractObtSociosPorNombre.setPrimerNombre("Liber");
        contractObtSociosPorNombre.setPrimerApellido("Azambuya");
        contractObtSociosPorNombre.setSegundoNombre("Marcos");
        contractObtSociosPorNombre.setSegundoApellido("Alvarez");
        SolverObtSociosPorNombre solverObtSociosPorNombre = new SolverObtSociosPorNombre();
        solverObtSociosPorNombre.loadContract(contractObtSociosPorNombre);
        solverObtSociosPorNombre.validate();
        ResultObtSociosPorNombre resultObtSociosPorNombre = solverObtSociosPorNombre.getResponseFromSolver();
        System.out.println(resultObtSociosPorNombre.getSociosTrans().get(0).getNroSocio());*/
    }
}
