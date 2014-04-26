package veterinarias.mascotas.modals;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import veterinarias.gui.generics.GenericTabbedPane;
import veterinarias.mascotas.actions.BotonConfirmarFichaClinicaAction;
import veterinarias.socios.jframes.NuevasMascotas;

import com.toedter.calendar.JDateChooser;

public class IngresarFichaClinica extends JPanel {

    private static final long serialVersionUID = 1L;
    private GroupLayout gl_contentPane;
    private GenericTabbedPane tabbedPane;
    private JButton btnConfirmar;
    //Atributos
    private NuevasMascotas nuevasMascotas;
    private JDialog dialog;
    //Componentes de una pestaña
    private JPanel panelPestaniaInicial;
    private GroupLayout gl_panelPestaniaInicial;
    private JLabel lblFecha;
    private JDateChooser dateChooser;
    private JScrollPane scrPnlInformacion;
    private JTextArea txtInformacion;
    //Acciones
    private BotonConfirmarFichaClinicaAction btnConfirmarFichaClinicaAction = new BotonConfirmarFichaClinicaAction(this);

    /**
     * Create the panel.
     */
    public IngresarFichaClinica(NuevasMascotas nuevasMascotas) {
        this.nuevasMascotas = nuevasMascotas;
        this.initComponents();
        //btnConfirmarFichaClinicaAction.setNuevasMascotas(nuevasMascotas);
        //setBackground(Color.LIGHT_GRAY);
    }

    protected void initComponents() {
        //Inicializo componentes
        txtInformacion = new JTextArea(10, 50);
        txtInformacion.setText(nuevasMascotas.getInformacion());
        txtInformacion.setLineWrap(true);
        txtInformacion.setWrapStyleWord(true);
        txtInformacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        //Inicializo TabbedPane y le agrego las pestañas
        tabbedPane = new GenericTabbedPane(JTabbedPane.TOP);
        tabbedPane.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String nameComponent = tabbedPane.getSelectedComponent().getName();
                if (nameComponent != null && nameComponent.equals("+")) {
                    JPanel panel = new JPanel();
                    tabbedPane.addClosableTabWithAddTab("New tab", panel);
                    //Creo componentes nuevos
                    JLabel lblFecha = new JLabel("Fecha:");
                    lblFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
                    JDateChooser dateChooser = new JDateChooser();
                    dateChooser.setDate(new Date());
                    ((JTextField) dateChooser.getDateEditor()).setEditable(false);
                    JTextArea txtInformacion = new JTextArea(10, 50);
                    txtInformacion.setText(nuevasMascotas.getInformacion());
                    txtInformacion.setLineWrap(true);
                    txtInformacion.setWrapStyleWord(true);
                    txtInformacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
                    JScrollPane scrPnlInformacion = new JScrollPane();
                    scrPnlInformacion.setViewportView(txtInformacion);
                    //Agrego layout
                    GroupLayout groupLayout = new GroupLayout(panel);
                    panel.setLayout(groupLayout);
                    groupLayout.setHorizontalGroup(horizontalGroupPanelInicial(groupLayout, lblFecha, dateChooser, scrPnlInformacion));
                    groupLayout.setVerticalGroup(verticalGroupPanelInicial(groupLayout, lblFecha, dateChooser, scrPnlInformacion));
                    tabbedPane.setSelectedComponent(panel);
                }
            }
        });
        panelPestaniaInicial = new JPanel();
        tabbedPane.addClosableTabWithAddTab("New tab", panelPestaniaInicial);
        //Creo componentes de pestaña inicial
        lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        ((JTextField) dateChooser.getDateEditor()).setEditable(false);
        //Agrego al JScrollPAnel el area de texto
        scrPnlInformacion = new JScrollPane();
        scrPnlInformacion.setViewportView(txtInformacion);
        gl_panelPestaniaInicial = new GroupLayout(panelPestaniaInicial);
        panelPestaniaInicial.setLayout(gl_panelPestaniaInicial);
        //Agrego al group layout de la pestaña inicial los componentes
        gl_panelPestaniaInicial.setHorizontalGroup(horizontalGroupPanelInicial(gl_panelPestaniaInicial, lblFecha, dateChooser, scrPnlInformacion));
        gl_panelPestaniaInicial.setVerticalGroup(verticalGroupPanelInicial(gl_panelPestaniaInicial, lblFecha, dateChooser, scrPnlInformacion));
        //Agrego boton confirmacion
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setAction(btnConfirmarFichaClinicaAction);
        //Armo Group Layout del contentPane
        gl_contentPane = new GroupLayout(this);
        this.setLayout(gl_contentPane);
        gl_contentPane.setHorizontalGroup(horizontalGroupPanel());
        gl_contentPane.setVerticalGroup(verticalGroupPanel());
    }

    private Group horizontalGroupPanelInicial(GroupLayout groupLayout, JLabel lblFecha, JDateChooser dateChooser, JScrollPane scrPnlInformacion) {
        ParallelGroup result = groupLayout.createParallelGroup(Alignment.LEADING);
        //SequentialGroup Fecha
        SequentialGroup sGroupFecha = groupLayout.createSequentialGroup();
        sGroupFecha.addGap(20);
        sGroupFecha.addComponent(lblFecha, 50, 50, 50);
        sGroupFecha.addGap(20);
        sGroupFecha.addComponent(dateChooser, 120, 120, 120);
        //Result
        result.addGroup(sGroupFecha);
        result.addGap(20);
        result.addComponent(scrPnlInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        return result;
    }

    private Group verticalGroupPanelInicial(GroupLayout groupLayout, JLabel lblFecha, JDateChooser dateChooser, JScrollPane scrPnlInformacion) {
        ParallelGroup result = groupLayout.createParallelGroup(Alignment.LEADING);
        //ParallelGroup Fecha
        ParallelGroup pGroupFecha = groupLayout.createParallelGroup(Alignment.LEADING);
        pGroupFecha.addGap(20);
        pGroupFecha.addComponent(lblFecha, 20, 20, 20);
        pGroupFecha.addGap(40);
        pGroupFecha.addComponent(dateChooser, 25, 25, 25);
        //SequentialGroup informacion
        SequentialGroup sGroupInformacion = groupLayout.createSequentialGroup();
        sGroupInformacion.addGap(20);
        sGroupInformacion.addGroup(pGroupFecha);
        sGroupInformacion.addGap(10);
        sGroupInformacion.addComponent(scrPnlInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        //Result
        result.addGroup(sGroupInformacion);
        return result;
    }

    private ParallelGroup horizontalGroupPanel() {
        ParallelGroup result = gl_contentPane.createParallelGroup(Alignment.LEADING);
        result.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        result.addGap(5);
        result.addComponent(btnConfirmar, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 100, 100);
        return result;
    }

    private ParallelGroup verticalGroupPanel() {
        ParallelGroup result = gl_contentPane.createParallelGroup(Alignment.LEADING);
        //SequentialGroup campo de texto y boton de confirmar
        SequentialGroup sGroupTablaSocios = gl_contentPane.createSequentialGroup();
        sGroupTablaSocios.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        sGroupTablaSocios.addGap(5);
        sGroupTablaSocios.addComponent(btnConfirmar, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupTablaSocios.addGap(5);
        //Result
        result.addGroup(sGroupTablaSocios);
        return result;
    }

    public JTextArea getTxtInformacion() {
        return txtInformacion;
    }

    public void setTxtInformacion(JTextArea txtInformacion) {
        this.txtInformacion = txtInformacion;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    public NuevasMascotas getNuevasMascotas() {
        return nuevasMascotas;
    }

    public void setNuevasMascotas(NuevasMascotas nuevasMascotas) {
        this.nuevasMascotas = nuevasMascotas;
    }

    public GenericTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(GenericTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }
}
