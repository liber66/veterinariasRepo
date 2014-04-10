package veterinarias.consultas.actions;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import veterinarias.consultas.contracts.ContractObtSociosPorNombre;
import veterinarias.consultas.jpanels.VerSociosPorNombre;
import veterinarias.consultas.results.ResultObtSociosPorNombre;
import veterinarias.consultas.solvers.SolverObtSociosPorNombre;
import veterinarias.gui.utils.tables.models.CeldasNoEditablesModel;
import veterinarias.objects.trans.SocioTrans;

public class BotonBuscarSocioPorNombreAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    public BotonBuscarSocioPorNombreAction() {
        putValue(NAME, "Buscar");
        putValue(SHORT_DESCRIPTION, "Buscar Socio por nombre");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ContractObtSociosPorNombre contractObtSociosPorNombre = new ContractObtSociosPorNombre();
        contractObtSociosPorNombre.setPrimerNombre(VerSociosPorNombre.getTxtPrimerNombre().getText());
        contractObtSociosPorNombre.setPrimerApellido(VerSociosPorNombre.getTxtPrimerApellido().getText());
        contractObtSociosPorNombre.setSegundoNombre(VerSociosPorNombre.getTxtSegundoNombre().getText());
        contractObtSociosPorNombre.setSegundoApellido(VerSociosPorNombre.getTxtSegundoApellido().getText());
        SolverObtSociosPorNombre solverObtSociosPorNombre = new SolverObtSociosPorNombre();
        solverObtSociosPorNombre.loadContract(contractObtSociosPorNombre);
        solverObtSociosPorNombre.validate();
        ResultObtSociosPorNombre resultObtSociosPorNombre = solverObtSociosPorNombre.getResponseFromSolver();
        if (resultObtSociosPorNombre != null && resultObtSociosPorNombre.getSociosTrans() != null && !resultObtSociosPorNombre.getSociosTrans().isEmpty()) {
            JTable jTable1 = VerSociosPorNombre.getJTable1();
            String[] columnNames = { "Nro Socio", "Nombre Completo", "Tel\u00E9fono", "Celular", "Direcci\u00F3n", "Cobrador" };
            int rowCount = resultObtSociosPorNombre.getSociosTrans().size();
            CeldasNoEditablesModel miModelo = new CeldasNoEditablesModel(columnNames, rowCount);
            jTable1.setModel(miModelo);
            int[] anchos = { 10, 300, 17, 17, 300, 6 };
            for (int i = 0; i < columnNames.length; i++) {
                jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            DefaultTableCellRenderer cellCenterModel = miModelo.getCellCenterModel();
            jTable1.getColumnModel().getColumn(2).setCellRenderer(cellCenterModel);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(cellCenterModel);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(cellCenterModel);
            List<SocioTrans> listaSocios = resultObtSociosPorNombre.getSociosTrans();
            for (int i = 0; i < rowCount; i++) {
                SocioTrans SocioTrans = listaSocios.get(i);
                jTable1.setValueAt(SocioTrans.getNroSocio(), i, 0);
                String nombreCompleto = SocioTrans.getPrimerNombre() + " " + SocioTrans.getSegundoNombre() + " " + SocioTrans.getPrimerApellido() + " "
                        + SocioTrans.getSegundoApellido();
                jTable1.setValueAt(nombreCompleto, i, 1);
                jTable1.setValueAt(SocioTrans.getTelefono(), i, 2);
                jTable1.setValueAt(SocioTrans.getCelular(), i, 3);
                jTable1.setValueAt(SocioTrans.getDireccion(), i, 4);
                jTable1.setValueAt(SocioTrans.getCobrador(), i, 5);
            }
            JTableHeader tableHeader = jTable1.getTableHeader();
            tableHeader.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            VerSociosPorNombre.setJTable1(jTable1);
            JPanel panel = VerSociosPorNombre.getPanel();
            panel.setVisible(true);
        } else {
            JPanel panel = VerSociosPorNombre.getPanel();
            panel.setVisible(false);
        }
    }
}
