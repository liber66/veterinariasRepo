package veterinarias.mascotas.modals;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import veterinarias.interfaces.utils.Constants;
import veterinarias.interfaces.utils.Fecha;
import veterinarias.mascotas.actions.BotonConfirmarVacunasAction;
import veterinarias.objects.trans.GenericCodeTrans;
import veterinarias.objects.trans.VacunaTrans;
import veterinarias.pruebas.ImagePanel;
import veterinarias.util.Convertidor;

public class AgregarVacunas extends ImagePanel {

    private static final long serialVersionUID = 1L;
    private GroupLayout gl_contentPane;
    //Atributos
    private JDialog dialog;
    //Campos
    private JCheckBox chbxPrimeraDosis;
    private JCheckBox chbxSegundaDosis;
    private JCheckBox chbxTercerDosis;
    private JCheckBox chbxRabia;
    private JCheckBox chbxAnual;
    private JLabel lblPrimeraDosis;
    private JLabel lblSegundaDosis;
    private JLabel lblTercerDosis;
    private JLabel lblRabia;
    private JLabel lblAnual;
    private JTextField txtPrimeraDosis;
    private JTextField txtSegundaDosis;
    private JTextField txtTercerDosis;
    private JTextField txtRabia;
    private JTextField txtAnual;
    //Botones
    private JButton btnConfirmar;
    //Acciones
    private BotonConfirmarVacunasAction btnConfirmarVacunasAction = new BotonConfirmarVacunasAction(this);

    public AgregarVacunas() {
        this.initComponents();
        this.setImagen("vacuna1.jpg");
        //
    }

    private void initComponents() {
        //Inicializo componentes
        chbxPrimeraDosis = new JCheckBox("1\u00AA Dosis");
        chbxPrimeraDosis.setName("1");
        chbxPrimeraDosis.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        chbxSegundaDosis = new JCheckBox("2\u00AA Dosis");
        chbxSegundaDosis.setName("2");
        chbxSegundaDosis.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        chbxTercerDosis = new JCheckBox("3\u00AA Dosis");
        chbxTercerDosis.setName("3");
        chbxTercerDosis.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        chbxRabia = new JCheckBox("Rabia");
        chbxRabia.setName("4");
        chbxRabia.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        chbxAnual = new JCheckBox("Anual");
        chbxAnual.setName("5");
        chbxAnual.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblPrimeraDosis = new JLabel("Fecha:");
        lblPrimeraDosis.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblSegundaDosis = new JLabel("Fecha:");
        lblSegundaDosis.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblTercerDosis = new JLabel("Fecha:");
        lblTercerDosis.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblRabia = new JLabel("Fecha:");
        lblRabia.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblAnual = new JLabel("Fecha:");
        lblAnual.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        txtPrimeraDosis = new JTextField();
        txtPrimeraDosis.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtPrimeraDosis.setEnabled(false);
        txtSegundaDosis = new JTextField();
        txtSegundaDosis.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtSegundaDosis.setEnabled(false);
        txtTercerDosis = new JTextField();
        txtTercerDosis.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtTercerDosis.setEnabled(false);
        txtRabia = new JTextField();
        txtRabia.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtRabia.setEnabled(false);
        txtAnual = new JTextField();
        txtAnual.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtAnual.setEnabled(false);
        //Agregar Acciones a os Checkbox
        chbxPrimeraDosis.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                txtPrimeraDosis.setEnabled(!txtPrimeraDosis.isEnabled());
            }
        });
        chbxSegundaDosis.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                txtSegundaDosis.setEnabled(!txtSegundaDosis.isEnabled());
            }
        });
        chbxTercerDosis.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                txtTercerDosis.setEnabled(!txtTercerDosis.isEnabled());
            }
        });
        chbxRabia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                txtRabia.setEnabled(!txtRabia.isEnabled());
            }
        });
        chbxAnual.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                txtAnual.setEnabled(!txtAnual.isEnabled());
            }
        });
        //Agrego boton confirmacion
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setAction(btnConfirmarVacunasAction);
        //GoupLayout
        gl_contentPane = new GroupLayout(this);
        gl_contentPane.setHorizontalGroup(horizontalGroupPanel());
        gl_contentPane.setVerticalGroup(verticalGroupPanel());
        this.setLayout(gl_contentPane);
    }

    private ParallelGroup horizontalGroupPanel() {
        ParallelGroup result = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        //SequentialGroup Primer Fila
        SequentialGroup sGroupPrimerFila = gl_contentPane.createSequentialGroup();
        sGroupPrimerFila.addGap(15);
        sGroupPrimerFila.addComponent(chbxPrimeraDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerFila.addGap(50);
        sGroupPrimerFila.addComponent(lblPrimeraDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerFila.addGap(10);
        sGroupPrimerFila.addComponent(txtPrimeraDosis, GroupLayout.DEFAULT_SIZE, 100, 100);
        //SequentialGroup Segunda Fila
        SequentialGroup sGroupSegundaFila = gl_contentPane.createSequentialGroup();
        sGroupSegundaFila.addGap(15);
        sGroupSegundaFila.addComponent(chbxSegundaDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundaFila.addGap(50);
        sGroupSegundaFila.addComponent(lblSegundaDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundaFila.addGap(10);
        sGroupSegundaFila.addComponent(txtSegundaDosis, GroupLayout.DEFAULT_SIZE, 100, 100);
        //SequentialGroup Tercer Fila
        SequentialGroup sGroupTercerFila = gl_contentPane.createSequentialGroup();
        sGroupTercerFila.addGap(15);
        sGroupTercerFila.addComponent(chbxTercerDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupTercerFila.addGap(50);
        sGroupTercerFila.addComponent(lblTercerDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupTercerFila.addGap(10);
        sGroupTercerFila.addComponent(txtTercerDosis, GroupLayout.DEFAULT_SIZE, 100, 100);
        //SequentialGroup Cuarta Fila
        SequentialGroup sGroupCuartaFila = gl_contentPane.createSequentialGroup();
        sGroupCuartaFila.addGap(15);
        sGroupCuartaFila.addComponent(chbxRabia, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupCuartaFila.addGap(72);
        sGroupCuartaFila.addComponent(lblRabia, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupCuartaFila.addGap(10);
        sGroupCuartaFila.addComponent(txtRabia, GroupLayout.DEFAULT_SIZE, 100, 100);
        //SequentialGroup Quinta Fila
        SequentialGroup sGroupQuintaFila = gl_contentPane.createSequentialGroup();
        sGroupQuintaFila.addGap(15);
        sGroupQuintaFila.addComponent(chbxAnual, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupQuintaFila.addGap(72);
        sGroupQuintaFila.addComponent(lblAnual, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupQuintaFila.addGap(10);
        sGroupQuintaFila.addComponent(txtAnual, GroupLayout.DEFAULT_SIZE, 100, 100);
        sGroupQuintaFila.addGap(100);
        //Result
        result.addGroup(sGroupPrimerFila);
        result.addGroup(sGroupSegundaFila);
        result.addGroup(sGroupTercerFila);
        result.addGroup(sGroupCuartaFila);
        result.addGroup(sGroupQuintaFila);
        result.addComponent(btnConfirmar, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 100, 100);
        return result;
    }

    private ParallelGroup verticalGroupPanel() {
        ParallelGroup result = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        //SequentialGroup Primer Columna
        SequentialGroup sGroupPrimerColumna = gl_contentPane.createSequentialGroup();
        sGroupPrimerColumna.addGap(30);
        sGroupPrimerColumna.addComponent(chbxPrimeraDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerColumna.addGap(15);
        sGroupPrimerColumna.addComponent(chbxSegundaDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerColumna.addGap(15);
        sGroupPrimerColumna.addComponent(chbxTercerDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerColumna.addGap(15);
        sGroupPrimerColumna.addComponent(chbxRabia, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerColumna.addGap(15);
        sGroupPrimerColumna.addComponent(chbxAnual, GroupLayout.DEFAULT_SIZE, 10, 10);
        //SequentialGroup Segunda Columna
        SequentialGroup sGroupSegundaColumna = gl_contentPane.createSequentialGroup();
        sGroupSegundaColumna.addGap(30);
        sGroupSegundaColumna.addComponent(lblPrimeraDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundaColumna.addGap(15);
        sGroupSegundaColumna.addComponent(lblSegundaDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundaColumna.addGap(15);
        sGroupSegundaColumna.addComponent(lblTercerDosis, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundaColumna.addGap(15);
        sGroupSegundaColumna.addComponent(lblRabia, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundaColumna.addGap(15);
        sGroupSegundaColumna.addComponent(lblAnual, GroupLayout.DEFAULT_SIZE, 10, 10);
        //SequentialGroup Tercer Columna
        SequentialGroup sGroupTercerColumna = gl_contentPane.createSequentialGroup();
        sGroupTercerColumna.addGap(30);
        sGroupTercerColumna.addComponent(txtPrimeraDosis, GroupLayout.DEFAULT_SIZE, 5, 5);
        sGroupTercerColumna.addGap(8);
        sGroupTercerColumna.addComponent(txtSegundaDosis, GroupLayout.DEFAULT_SIZE, 5, 5);
        sGroupTercerColumna.addGap(8);
        sGroupTercerColumna.addComponent(txtTercerDosis, GroupLayout.DEFAULT_SIZE, 5, 5);
        sGroupTercerColumna.addGap(8);
        sGroupTercerColumna.addComponent(txtRabia, GroupLayout.DEFAULT_SIZE, 5, 5);
        sGroupTercerColumna.addGap(8);
        sGroupTercerColumna.addComponent(txtAnual, GroupLayout.DEFAULT_SIZE, 5, 5);
        //ParallelGroup Vacunas
        ParallelGroup pGroupVacunas = gl_contentPane.createParallelGroup();
        pGroupVacunas.addGroup(sGroupPrimerColumna);
        pGroupVacunas.addGroup(sGroupSegundaColumna);
        pGroupVacunas.addGroup(sGroupTercerColumna);
        //
        SequentialGroup sGroupBotonConfirmar = gl_contentPane.createSequentialGroup();
        sGroupBotonConfirmar.addGroup(pGroupVacunas);
        sGroupBotonConfirmar.addGap(60);
        sGroupBotonConfirmar.addGap(40);
        sGroupBotonConfirmar.addComponent(btnConfirmar, GroupLayout.DEFAULT_SIZE, 10, 10);
        //Result
        result.addGroup(sGroupBotonConfirmar);
        return result;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    public void clickearCheckBox(Long codVacuna, Fecha fecha) {
        Convertidor convertidor = new Convertidor();
        switch (codVacuna.intValue()) {
            case 1:
                chbxPrimeraDosis.doClick();
                txtPrimeraDosis.setText(convertidor.convertFechaToString(fecha));
                break;
            case 2:
                chbxSegundaDosis.doClick();
                txtSegundaDosis.setText(convertidor.convertFechaToString(fecha));
                break;
            case 3:
                chbxTercerDosis.doClick();
                txtTercerDosis.setText(convertidor.convertFechaToString(fecha));
                break;
            case 4:
                chbxRabia.doClick();
                txtRabia.setText(convertidor.convertFechaToString(fecha));
                break;
            case 5:
                chbxAnual.doClick();
                txtAnual.setText(convertidor.convertFechaToString(fecha));
                break;
            default:
                break;
        }
    }

    public List<VacunaTrans> getVacunasTrans() {
        List<VacunaTrans> listVacunaTrans = new ArrayList<VacunaTrans>();
        Convertidor convertidor = new Convertidor();
        if (chbxPrimeraDosis.isSelected()) {
            VacunaTrans vacunaTrans = this.createVacunaTrans(Constants.COD_VACUNA_1ER_DOSIS, convertidor.convertStringToFecha(txtPrimeraDosis.getText()));
            listVacunaTrans.add(vacunaTrans);
        }
        if (chbxSegundaDosis.isSelected()) {
            VacunaTrans vacunaTrans = this.createVacunaTrans(Constants.COD_VACUNA_2DA_DOSIS, convertidor.convertStringToFecha(txtSegundaDosis.getText()));
            listVacunaTrans.add(vacunaTrans);
        }
        if (chbxTercerDosis.isSelected()) {
            VacunaTrans vacunaTrans = this.createVacunaTrans(Constants.COD_VACUNA_3RA_DOSIS, convertidor.convertStringToFecha(txtTercerDosis.getText()));
            listVacunaTrans.add(vacunaTrans);
        }
        if (chbxRabia.isSelected()) {
            VacunaTrans vacunaTrans = this.createVacunaTrans(Constants.COD_VACUNA_RABIA, convertidor.convertStringToFecha(txtRabia.getText()));
            listVacunaTrans.add(vacunaTrans);
        }
        if (chbxAnual.isSelected()) {
            VacunaTrans vacunaTrans = this.createVacunaTrans(Constants.COD_VACUNA_ANUAL, convertidor.convertStringToFecha(txtAnual.getText()));
            listVacunaTrans.add(vacunaTrans);
        }
        return listVacunaTrans;
    }

    private VacunaTrans createVacunaTrans(long codVacuna, Fecha fechaDosis) {
        VacunaTrans vacunaTrans = new VacunaTrans();
        vacunaTrans.setFechaDosis(fechaDosis);
        GenericCodeTrans genericCodeTrans = new GenericCodeTrans();
        genericCodeTrans.setCodigo(codVacuna);
        vacunaTrans.setCodVacuna(genericCodeTrans);
        return vacunaTrans;
    }
}
