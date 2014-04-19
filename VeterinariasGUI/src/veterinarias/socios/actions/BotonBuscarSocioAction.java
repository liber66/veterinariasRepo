package veterinarias.socios.actions;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import veterinarias.consultas.contracts.ContractObtSocios;
import veterinarias.consultas.results.ResultObtSocios;
import veterinarias.consultas.solvers.SolverObtSocios;
import veterinarias.gui.utils.tables.models.CeldasNoEditablesModel;
import veterinarias.objects.trans.SocioTrans;
import veterinarias.socios.jframes.BuscarSocio;

public class BotonBuscarSocioAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    //private buscarSocio buscarSocio;
    private BuscarSocio buscarSocio;

    /*  public BotonBuscarSocioAction(buscarSocio buscarSocio) {
          putValue(NAME, "Buscar");
          putValue(SHORT_DESCRIPTION, "Buscar Socio por nombre");
          this.buscarSocio = buscarSocio;
      }*/
    public BotonBuscarSocioAction(BuscarSocio buscarSocio) {
        putValue(NAME, "Buscar");
        putValue(SHORT_DESCRIPTION, "Buscar Socio");
        this.buscarSocio = buscarSocio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ContractObtSocios contractObtSocios = new ContractObtSocios();
        String nroSocioString = buscarSocio.getTxtNroSocio().getText();
        if (nroSocioString != null && !nroSocioString.isEmpty()) {
            contractObtSocios.setNroSocio(new Long(nroSocioString));
        }
        contractObtSocios.setPrimerNombre(buscarSocio.getTxtPrimerNombre().getText());
        contractObtSocios.setPrimerApellido(buscarSocio.getTxtPrimerApellido().getText());
        contractObtSocios.setSegundoNombre(buscarSocio.getTxtSegundoNombre().getText());
        contractObtSocios.setSegundoApellido(buscarSocio.getTxtSegundoApellido().getText());
        contractObtSocios.setDireccion(buscarSocio.getTxtDireccion().getText());
        contractObtSocios.setTelefono(buscarSocio.getTxtTelefono().getText());
        contractObtSocios.setCelular(buscarSocio.getTxtCelular().getText());
        String cobrador = (String) buscarSocio.getCmbCobrador().getSelectedItem();
        if (!cobrador.isEmpty()) {
            if ("Si".equals(cobrador)) {
                contractObtSocios.setCobrador("S");
            } else {
                contractObtSocios.setCobrador("N");
            }
        }
        SolverObtSocios solverObtSocios = new SolverObtSocios();
        solverObtSocios.loadContract(contractObtSocios);
        solverObtSocios.validate();
        ResultObtSocios resultObtSocios = solverObtSocios.getResponseFromSolver();
        if (resultObtSocios != null && resultObtSocios.getSociosTrans() != null && !resultObtSocios.getSociosTrans().isEmpty()) {
            JTable jTable1 = buscarSocio.getTbleSocios();
            String[] columnNames = { "Nro Socio", "Nombre Completo", "Tel\u00E9fono", "Celular", "Direcci\u00F3n", "Cobrador" };
            int rowCount = resultObtSocios.getSociosTrans().size();
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
            List<SocioTrans> listaSocios = resultObtSocios.getSociosTrans();
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
            buscarSocio.setTbleSocios(jTable1);
            JScrollPane scrPnlSocios = buscarSocio.getScrPnlSocios();
            scrPnlSocios.setVisible(true);
        } else {
            JScrollPane scrPnlSocios = buscarSocio.getScrPnlSocios();
            scrPnlSocios.setVisible(false);
        }
    }
    /*@Override
    public void actionPerformed(ActionEvent e) {
        ContractObtSocios contractObtSocios = new ContractObtSocios();
        String nroSocioString = buscarSocio.getTxtNroSocio().getText();
        if (nroSocioString != null && !nroSocioString.isEmpty()) {
            contractObtSocios.setNroSocio(new Long(nroSocioString));
        }
        contractObtSocios.setPrimerNombre(buscarSocio.getTxtPrimerNombre().getText());
        contractObtSocios.setPrimerApellido(buscarSocio.getTxtPrimerApellido().getText());
        contractObtSocios.setSegundoNombre(buscarSocio.getTxtSegundoNombre().getText());
        contractObtSocios.setSegundoApellido(buscarSocio.getTxtSegundoApellido().getText());
        contractObtSocios.setDireccion(buscarSocio.getTxtDireccion().getText());
        contractObtSocios.setTelefono(buscarSocio.getTxtTelefono().getText());
        contractObtSocios.setCelular(buscarSocio.getTxtCelular().getText());
        String cobrador = (String) buscarSocio.getCmbCobrador().getSelectedItem();
        if (!cobrador.isEmpty()) {
            if ("Si".equals(cobrador)) {
                contractObtSocios.setCobrador("S");
            } else {
                contractObtSocios.setCobrador("N");
            }
        }
        SolverObtSocios solverObtSocios = new SolverObtSocios();
        solverObtSocios.loadContract(contractObtSocios);
        solverObtSocios.validate();
        ResultObtSocios resultObtSocios = solverObtSocios.getResponseFromSolver();
        if (resultObtSocios != null && resultObtSocios.getSociosTrans() != null && !resultObtSocios.getSociosTrans().isEmpty()) {
            JTable jTable1 = buscarSocio.getJTable1();
            String[] columnNames = { "Nro Socio", "Nombre Completo", "Tel\u00E9fono", "Celular", "Direcci\u00F3n", "Cobrador" };
            int rowCount = resultObtSocios.getSociosTrans().size();
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
            List<SocioTrans> listaSocios = resultObtSocios.getSociosTrans();
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
            buscarSocio.setJTable1(jTable1);
            JPanel panel = buscarSocio.getPanel();
            panel.setVisible(true);
        } else {
            JPanel panel = buscarSocio.getPanel();
            panel.setVisible(false);
        }
    }*/
}
