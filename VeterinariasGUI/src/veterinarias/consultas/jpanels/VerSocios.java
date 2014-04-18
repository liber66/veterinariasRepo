package veterinarias.consultas.jpanels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import veterinarias.pruebas.ImagePanel;

public class VerSocios extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    // Variables declaration - do not modify
    private JLabel lblPrimerNombre;
    private JLabel lblSegundoNombre;
    private JLabel lblPrimerApellido;
    private JLabel lblSegundoApellido;
    private ImagePanel panelBusqueda;
    private JTextField txtSegundoApellido;
    private JTextField txtPrimerApellido;
    private JTextField txtPrimerNombre;
    private JTextField txtSegundoNombre;
    //private final Action btnBuscarSocioAction = new BotonBuscarSocioAction(this);
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTable jTable1;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JLabel lblNroSocio;
    private JTextField txtNroSocio;
    private JTextField txtCelular;
    private JLabel lblCelular;
    private JComboBox<String> cmbCobrador;

    /** Creates new form VerSociosPorNombre */
    public VerSocios() {
        initComponents();
        panelBusqueda.setVisible(true);
        panelBusqueda.setImagen("perro.jpg");
        panel.setVisible(false);
    }

    public JTextField getTxtSegundoApellido() {
        return txtSegundoApellido;
    }

    public void setTxtSegundoApellido(JTextField txtSegundoApellido) {
        this.txtSegundoApellido = txtSegundoApellido;
    }

    public JTextField getTxtPrimerApellido() {
        return txtPrimerApellido;
    }

    public void setTxtPrimerApellido(JTextField txtPrimerApellido) {
        this.txtPrimerApellido = txtPrimerApellido;
    }

    public JTextField getTxtPrimerNombre() {
        return txtPrimerNombre;
    }

    public void setTxtPrimerNombre(JTextField txtPrimerNombre) {
        this.txtPrimerNombre = txtPrimerNombre;
    }

    public JTextField getTxtSegundoNombre() {
        return txtSegundoNombre;
    }

    public void setTxtSegundoNombre(JTextField txtSegundoNombre) {
        this.txtSegundoNombre = txtSegundoNombre;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtNroSocio() {
        return txtNroSocio;
    }

    public void setTxtNroSocio(JTextField txtNroSocio) {
        this.txtNroSocio = txtNroSocio;
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(JTextField txtCelular) {
        this.txtCelular = txtCelular;
    }

    public JComboBox<String> getCmbCobrador() {
        return cmbCobrador;
    }

    public void setCmbCobrador(JComboBox<String> cmbCobrador) {
        this.cmbCobrador = cmbCobrador;
    }

    public JTable getJTable1() {
        return jTable1;
    }

    public void setJTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        panelBusqueda = new ImagePanel();
        lblPrimerNombre = new javax.swing.JLabel();
        lblPrimerNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblSegundoNombre = new javax.swing.JLabel();
        lblSegundoNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblPrimerApellido = new javax.swing.JLabel();
        lblPrimerApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblSegundoApellido = new javax.swing.JLabel();
        lblSegundoApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblPrimerNombre.setText("Primer Nombre:");
        lblSegundoNombre.setText("Segundo Nombre:");
        lblPrimerApellido.setText("Primer Apellido:");
        lblSegundoApellido.setText("Segundo Apellido:");
        txtSegundoApellido = new JTextField();
        txtSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtPrimerApellido = new JTextField();
        txtPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtPrimerNombre = new JTextField();
        txtPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtSegundoNombre = new JTextField();
        txtSegundoNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        JButton btnBuscar = new JButton("Buscar");
        //btnBuscar.setAction(btnBuscarSocioAction);
        panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
        lblDireccion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        txtDireccion = new JTextField();
        txtDireccion.setColumns(10);
        JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
        lblTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        txtTelefono = new JTextField();
        txtTelefono.setColumns(10);
        lblNroSocio = new JLabel("Nro Socio:");
        lblNroSocio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        txtNroSocio = new JTextField();
        txtNroSocio.setColumns(10);
        txtCelular = new JTextField();
        txtCelular.setColumns(10);
        lblCelular = new JLabel("Celular:");
        lblCelular.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        cmbCobrador = new JComboBox<String>();
        cmbCobrador.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Si", "No" }));
        JLabel lblCobrador = new JLabel("Cobrador:");
        lblCobrador.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        //jScrollPane1.setViewportView(jTable1);
        javax.swing.GroupLayout gl_panelBusqueda = new javax.swing.GroupLayout(panelBusqueda);
        gl_panelBusqueda
                .setHorizontalGroup(gl_panelBusqueda
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panelBusqueda
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                gl_panelBusqueda
                                                        .createParallelGroup(Alignment.LEADING)
                                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                                                        .addGroup(
                                                                gl_panelBusqueda
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                gl_panelBusqueda
                                                                                        .createParallelGroup(Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                gl_panelBusqueda
                                                                                                        .createSequentialGroup()
                                                                                                        .addGroup(
                                                                                                                gl_panelBusqueda
                                                                                                                        .createParallelGroup(Alignment.LEADING)
                                                                                                                        .addComponent(lblPrimerApellido)
                                                                                                                        .addComponent(lblPrimerNombre)
                                                                                                                        .addComponent(lblTelefono)
                                                                                                                        .addComponent(lblNroSocio)).addGap(81))
                                                                                        .addGroup(
                                                                                                gl_panelBusqueda
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(lblCobrador, GroupLayout.DEFAULT_SIZE,
                                                                                                                196, Short.MAX_VALUE)
                                                                                                        .addPreferredGap(ComponentPlacement.RELATED)))
                                                                        .addGroup(
                                                                                gl_panelBusqueda
                                                                                        .createParallelGroup(Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                gl_panelBusqueda
                                                                                                        .createSequentialGroup()
                                                                                                        .addGroup(
                                                                                                                gl_panelBusqueda
                                                                                                                        .createParallelGroup(
                                                                                                                                Alignment.TRAILING, false)
                                                                                                                        .addComponent(txtPrimerNombre,
                                                                                                                                GroupLayout.DEFAULT_SIZE, 236,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                        .addGroup(
                                                                                                                                gl_panelBusqueda
                                                                                                                                        .createSequentialGroup()
                                                                                                                                        .addComponent(
                                                                                                                                                txtPrimerApellido)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                ComponentPlacement.RELATED))
                                                                                                                        .addComponent(txtNroSocio,
                                                                                                                                GroupLayout.DEFAULT_SIZE, 236,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                        .addComponent(txtTelefono))
                                                                                                        .addGap(18)
                                                                                                        .addGroup(
                                                                                                                gl_panelBusqueda
                                                                                                                        .createParallelGroup(Alignment.LEADING)
                                                                                                                        .addComponent(lblSegundoApellido)
                                                                                                                        .addComponent(lblSegundoNombre)
                                                                                                                        .addComponent(lblDireccion)
                                                                                                                        .addComponent(lblCelular,
                                                                                                                                GroupLayout.PREFERRED_SIZE, 75,
                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                        .addComponent(cmbCobrador, GroupLayout.PREFERRED_SIZE, 70,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(61)
                                                                        .addGroup(
                                                                                gl_panelBusqueda
                                                                                        .createParallelGroup(Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                gl_panelBusqueda
                                                                                                        .createParallelGroup(Alignment.LEADING, false)
                                                                                                        .addComponent(txtDireccion)
                                                                                                        .addComponent(txtSegundoApellido)
                                                                                                        .addComponent(txtSegundoNombre,
                                                                                                                GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                                                                                        .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE,
                                                                                                                89, GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(txtCelular, GroupLayout.PREFERRED_SIZE, 236,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE))).addContainerGap()));
        gl_panelBusqueda.setVerticalGroup(gl_panelBusqueda.createParallelGroup(Alignment.LEADING).addGroup(
                gl_panelBusqueda
                        .createSequentialGroup()
                        .addGap(34)
                        .addGroup(
                                gl_panelBusqueda.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtPrimerNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSegundoNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPrimerNombre).addComponent(lblSegundoNombre))
                        .addGap(19)
                        .addGroup(
                                gl_panelBusqueda
                                        .createParallelGroup(Alignment.TRAILING)
                                        .addGroup(
                                                gl_panelBusqueda.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(txtPrimerApellido, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblPrimerApellido).addComponent(lblSegundoApellido))
                                        .addComponent(txtSegundoApellido, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addGap(20)
                        .addGroup(
                                gl_panelBusqueda.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addComponent(lblDireccion)
                                        .addComponent(txtNroSocio, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addComponent(lblNroSocio))
                        .addGap(18)
                        .addGroup(
                                gl_panelBusqueda.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addComponent(lblTelefono)
                                        .addComponent(lblCelular, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCelular, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addGap(21)
                        .addGroup(
                                gl_panelBusqueda.createParallelGroup(Alignment.BASELINE).addComponent(btnBuscar)
                                        .addComponent(lblCobrador, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbCobrador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18).addComponent(panel, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE).addContainerGap()));
        scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setViewportBorder(null);
        javax.swing.GroupLayout layout3 = new javax.swing.GroupLayout(panel);
        layout3.setHorizontalGroup(layout3.createParallelGroup(Alignment.LEADING).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE));
        layout3.setVerticalGroup(layout3.createParallelGroup(Alignment.TRAILING).addGroup(
                layout3.createSequentialGroup().addContainerGap(70, Short.MAX_VALUE)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)));
        panel.setLayout(layout3);
        panelBusqueda.setLayout(gl_panelBusqueda);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(panelBusqueda, GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(panelBusqueda, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE));
        this.setLayout(layout);
        //
        jTable1 = new JTable();
        //scrollPane.setOpaque(false);
        panel.setOpaque(false);
        scrollPane.setViewportView(jTable1);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
    }// </editor-fold>
}