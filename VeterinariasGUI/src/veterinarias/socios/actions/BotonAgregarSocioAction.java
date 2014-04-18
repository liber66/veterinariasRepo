package veterinarias.socios.actions;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import veterinarias.consultas.jpanels.NuevoSocio;
import veterinarias.gui.utils.tables.models.CeldasNoEditablesModel;
import veterinarias.objects.trans.SocioTrans;
import veterinarias.socios.contracts.ContractNuevoSocio;
import veterinarias.socios.results.ResultNuevoSocio;
import veterinarias.socios.solvers.SolverNuevoSocio;

public class BotonAgregarSocioAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private NuevoSocio nuevoSocio;

    public BotonAgregarSocioAction(NuevoSocio nuevoSocio) {
        putValue(NAME, "Agregar Socio");
        putValue(SHORT_DESCRIPTION, "Agregar un Socio");
        this.nuevoSocio = nuevoSocio;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ContractNuevoSocio contractNuevoSocio = new ContractNuevoSocio();
        contractNuevoSocio.setNroSocio(new Long(nuevoSocio.getTxtNroSocio().getText()));
        contractNuevoSocio.setPrimerNombre(nuevoSocio.getTxtPrimerNombre().getText());
        contractNuevoSocio.setPrimerApellido(nuevoSocio.getTxtPrimerApellido().getText());
        contractNuevoSocio.setSegundoNombre(nuevoSocio.getTxtSegundoNombre().getText());
        contractNuevoSocio.setSegundoApellido(nuevoSocio.getTxtSegundoApellido().getText());
        contractNuevoSocio.setDireccion(nuevoSocio.getTxtDireccion().getText());
        contractNuevoSocio.setTelefono(nuevoSocio.getTxtTelefono().getText());
        contractNuevoSocio.setCelular(nuevoSocio.getTxtCelular().getText());
        String cobrador = (String) nuevoSocio.getCmbCobrador().getSelectedItem();
        if (!cobrador.isEmpty()) {
            if ("Si".equals(cobrador)) {
                contractNuevoSocio.setCobrador("S");
            } else {
                contractNuevoSocio.setCobrador("N");
            }
        }
        SolverNuevoSocio solverNuevoSocio = new SolverNuevoSocio();
        solverNuevoSocio.loadContract(contractNuevoSocio);
        solverNuevoSocio.registarObjetosSolver();
        ResultNuevoSocio resultNuevoSocio = solverNuevoSocio.getResponseFromSolver();
        if (resultNuevoSocio != null && (resultNuevoSocio.getErroresNegocio() == null || resultNuevoSocio.getErroresNegocio().isEmpty())) {
            JTable tbleSocio = nuevoSocio.getTbleSocios();
            String[] columnNames = { "Nro Socio", "Nombre Completo", "Tel\u00E9fono", "Celular", "Direcci\u00F3n", "Cobrador" };
            CeldasNoEditablesModel miModelo = new CeldasNoEditablesModel(columnNames, 1);
            tbleSocio.setModel(miModelo);
            int[] anchos = { 10, 300, 17, 17, 300, 6 };
            for (int i = 0; i < columnNames.length; i++) {
                tbleSocio.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            DefaultTableCellRenderer cellCenterModel = miModelo.getCellCenterModel();
            tbleSocio.getColumnModel().getColumn(2).setCellRenderer(cellCenterModel);
            tbleSocio.getColumnModel().getColumn(3).setCellRenderer(cellCenterModel);
            tbleSocio.getColumnModel().getColumn(5).setCellRenderer(cellCenterModel);
            //Armo Fila con datos del Socio nuevo
            SocioTrans SocioTrans = resultNuevoSocio.getSocioTrans();
            tbleSocio.setValueAt(SocioTrans.getNroSocio(), 0, 0);
            String nombreCompleto = SocioTrans.getPrimerNombre() + " " + SocioTrans.getSegundoNombre() + " " + SocioTrans.getPrimerApellido() + " "
                    + SocioTrans.getSegundoApellido();
            tbleSocio.setValueAt(nombreCompleto, 0, 1);
            tbleSocio.setValueAt(SocioTrans.getTelefono(), 0, 2);
            tbleSocio.setValueAt(SocioTrans.getCelular(), 0, 3);
            tbleSocio.setValueAt(SocioTrans.getDireccion(), 0, 4);
            tbleSocio.setValueAt(SocioTrans.getCobrador(), 0, 5);
            //Le asigno la tabla al JFrame NuevoSocio
            JTableHeader tableHeader = tbleSocio.getTableHeader();
            tableHeader.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            tbleSocio.setOpaque(true);
            tbleSocio.setVisible(true);
            nuevoSocio.setTbleSocios(tbleSocio);
            JScrollPane scrPnlSocios = nuevoSocio.getScrPnlSocios();
            scrPnlSocios.setVisible(true);
            nuevoSocio.mostrarBotonAgregarMascota();
        } else {
            JScrollPane scrPnlSocios = nuevoSocio.getScrPnlSocios();
            scrPnlSocios.setVisible(false);
        }
    }
}
