package veterinarias.consultas.jpanels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import veterinarias.mascotas.actions.BotonAgregarMascotaAction;
import veterinarias.pruebas.ImagePanel;
import veterinarias.socios.actions.BotonAgregarSocioAction;

public class NuevoSocio extends JFrame {

    private static final long serialVersionUID = 1L;
    private ImagePanel contentPane;
    private GroupLayout gl_contentPane;
    //Labels
    private JLabel lblNroSocio;
    private JLabel lblPrimerNombre;
    private JLabel lblSegundoNombre;
    private JLabel lblPrimerApellido;
    private JLabel lblSegundoApellido;
    private JLabel lblDireccion;
    private JLabel lblTelefono;
    private JLabel lblCelular;
    private JLabel lblCobrador;
    private JLabel lblSocioIngresado;
    //Texts
    private JTextField txtNroSocio;
    private JTextField txtPrimerNombre;
    private JTextField txtSegundoNombre;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoApellido;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCelular;
    private JComboBox<String> cmbCobrador;
    //Botones
    private JButton btnAgregarSocio;
    private JButton btnAgregarMascota;
    //Tabla
    private JPanel pnlSocios;
    private JScrollPane scrPnlSocios;
    private JTable tbleSocios;
    private GroupLayout gl_pnlSocios;
    //Acciones
    private final Action btnAgregarSocioAction = new BotonAgregarSocioAction(this);
    private final Action btnAgregarMascotaAction = new BotonAgregarMascotaAction(this);

    /**
     * Create the frame.
     */
    public NuevoSocio() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = d.width * 2 / 3;
        int alto = d.height * 2 / 3;
        setSize(ancho, alto);
        setLocation(d.width / 2 - ancho / 2, d.height / 2 - alto / 2);
        setMinimumSize(new Dimension(ancho, alto));
        this.initComponents();
        contentPane.setImagen("perro.jpg");
        contentPane.setVisible(true);
    }

    private void initComponents() {
        contentPane = new ImagePanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Inicializo Labels
        lblPrimerNombre = new JLabel("Primer Nombre:");
        lblPrimerNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblSegundoNombre = new JLabel("Segundo Nombre:");
        lblSegundoNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblPrimerApellido = new JLabel("Primer Apellido:");
        lblPrimerApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblSegundoApellido = new JLabel("Segundo Apellido:");
        lblSegundoApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblNroSocio = new JLabel("Nro Socio:");
        lblNroSocio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblDireccion = new JLabel("Direcci\u00F3n:");
        lblDireccion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblTelefono = new JLabel("Tel\u00E9fono:");
        lblTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblCelular = new JLabel("Celular:");
        lblCelular.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblCobrador = new JLabel("Cobrador:");
        lblCobrador.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblSocioIngresado = new JLabel("J.C. Acabas de Ingresar el Siguiente Socio... ");
        lblSocioIngresado.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        //Inicializo campos de entrada
        txtPrimerNombre = new JTextField();
        txtPrimerNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtSegundoNombre = new JTextField();
        txtSegundoNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtPrimerApellido = new JTextField();
        txtPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtSegundoApellido = new JTextField();
        txtSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtNroSocio = new JTextField();
        txtNroSocio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtDireccion = new JTextField();
        txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtCelular = new JTextField();
        txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cmbCobrador = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] { "No", "Si" }));
        cmbCobrador.setFont(new Font("Tahoma", Font.PLAIN, 12));
        //Inicializo tabla de socios
        pnlSocios = new JPanel();
        pnlSocios.setBorder(null);
        pnlSocios.setOpaque(false);
        scrPnlSocios = new JScrollPane();
        scrPnlSocios.setBorder(null);
        scrPnlSocios.setViewportBorder(null);
        scrPnlSocios.setOpaque(false);
        scrPnlSocios.getViewport().setOpaque(false);
        tbleSocios = new JTable();
        scrPnlSocios.setViewportView(tbleSocios);
        //Botones
        btnAgregarSocio = new JButton("Agregar Socio");
        btnAgregarSocio.setAction(btnAgregarSocioAction);
        btnAgregarMascota = new JButton("Agregar Mascota");
        btnAgregarMascota.setAction(btnAgregarMascotaAction);
        btnAgregarMascota.setVisible(false);
        //Armo Group Layout de Panel Socios
        gl_pnlSocios = new GroupLayout(pnlSocios);
        pnlSocios.setLayout(gl_pnlSocios);
        gl_pnlSocios.setHorizontalGroup(horizontalGroupPnlSocios());
        gl_pnlSocios.setVerticalGroup(verticalGroupPnlSocios());
        //Armo Group Layout del contentPane
        gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);
        gl_contentPane.setHorizontalGroup(horizontalGroupContentPane());
        gl_contentPane.setVerticalGroup(verticalGroupContentPane());
    }

    private ParallelGroup horizontalGroupPnlSocios() {
        ParallelGroup result = gl_pnlSocios.createParallelGroup(Alignment.LEADING);
        result.addComponent(scrPnlSocios, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        return result;
    }

    private ParallelGroup verticalGroupPnlSocios() {
        ParallelGroup result = gl_pnlSocios.createParallelGroup(Alignment.TRAILING);
        result.addComponent(scrPnlSocios, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        return result;
    }

    private ParallelGroup horizontalGroupContentPane() {
        ParallelGroup result = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        //ParallelGroup primeras labels
        ParallelGroup pGroupPrimerasLabels = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        pGroupPrimerasLabels.addComponent(lblPrimerNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblPrimerApellido, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblNroSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblCobrador, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        //ParallelGroup primeros textfields
        ParallelGroup pGroupPrimerosTexts = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        pGroupPrimerosTexts.addComponent(txtPrimerNombre, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupPrimerosTexts.addComponent(txtPrimerApellido, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupPrimerosTexts.addComponent(txtNroSocio, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupPrimerosTexts.addComponent(txtTelefono, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupPrimerosTexts.addComponent(cmbCobrador, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 15, 15);
        //ParallelGroup segundas labels
        ParallelGroup pGroupSegundasLabels = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        pGroupSegundasLabels.addComponent(lblSegundoNombre, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupSegundasLabels.addComponent(lblSegundoApellido, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupSegundasLabels.addComponent(lblDireccion, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupSegundasLabels.addComponent(lblCelular, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        //ParallelGroup segundos textfields
        ParallelGroup pGroupSegundosTexts = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        pGroupSegundosTexts.addComponent(txtSegundoNombre, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupSegundosTexts.addComponent(txtSegundoApellido, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupSegundosTexts.addComponent(txtDireccion, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupSegundosTexts.addComponent(txtCelular, GroupLayout.DEFAULT_SIZE, 15, 236);
        //SequentialGroup 
        SequentialGroup sGroupBusqueda = gl_contentPane.createSequentialGroup();
        sGroupBusqueda.addContainerGap();
        sGroupBusqueda.addGroup(pGroupPrimerasLabels);
        sGroupBusqueda.addContainerGap(20, 50);
        sGroupBusqueda.addGroup(pGroupPrimerosTexts);
        sGroupBusqueda.addGap(1, 1, 100);
        sGroupBusqueda.addGroup(pGroupSegundasLabels);
        sGroupBusqueda.addContainerGap(20, 50);
        sGroupBusqueda.addGroup(pGroupSegundosTexts);
        //ParallelGroup tabla de socio agregado
        ParallelGroup pGroupTablaSocio = gl_contentPane.createParallelGroup(Alignment.LEADING);
        pGroupTablaSocio.addComponent(lblSocioIngresado);
        pGroupTablaSocio.addGap(10);
        pGroupTablaSocio.addComponent(pnlSocios, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        //Result
        result.addGroup(sGroupBusqueda);
        result.addGap(20);
        result.addGroup(pGroupTablaSocio);
        result.addGap(5);
        result.addComponent(btnAgregarSocio, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 15, 15);
        result.addComponent(btnAgregarMascota, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 15, 15);
        return result;
    }

    private ParallelGroup verticalGroupContentPane() {
        ParallelGroup result = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        //SequentialGroup primeras labels
        SequentialGroup sGroupPrimerasLabels = gl_contentPane.createSequentialGroup();
        sGroupPrimerasLabels.addGap(5);
        sGroupPrimerasLabels.addComponent(lblPrimerNombre, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerasLabels.addGap(5);
        sGroupPrimerasLabels.addComponent(lblPrimerApellido, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerasLabels.addGap(5);
        sGroupPrimerasLabels.addComponent(lblNroSocio, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerasLabels.addGap(5);
        sGroupPrimerasLabels.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerasLabels.addGap(5);
        sGroupPrimerasLabels.addComponent(lblCobrador, GroupLayout.DEFAULT_SIZE, 10, 10);
        //SequentialGroup primeros textfields
        SequentialGroup sGroupPrimerosTexts = gl_contentPane.createSequentialGroup();
        sGroupPrimerosTexts.addContainerGap();
        sGroupPrimerosTexts.addComponent(txtPrimerNombre, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerosTexts.addComponent(txtPrimerApellido, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerosTexts.addComponent(txtNroSocio, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerosTexts.addComponent(txtTelefono, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerosTexts.addComponent(cmbCobrador, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerosTexts.addContainerGap();
        //SequentialGroup segundas labels
        SequentialGroup sGroupSegundasLabels = gl_contentPane.createSequentialGroup();
        sGroupSegundasLabels.addGap(5);
        sGroupSegundasLabels.addComponent(lblSegundoNombre, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundasLabels.addGap(5);
        sGroupSegundasLabels.addComponent(lblSegundoApellido, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundasLabels.addGap(5);
        sGroupSegundasLabels.addComponent(lblDireccion, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundasLabels.addGap(5);
        sGroupSegundasLabels.addComponent(lblCelular, GroupLayout.DEFAULT_SIZE, 10, 10);
        //SequentialGroup segundos textfields
        SequentialGroup sGroupSegundosTexts = gl_contentPane.createSequentialGroup();
        sGroupSegundosTexts.addContainerGap();
        sGroupSegundosTexts.addComponent(txtSegundoNombre, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundosTexts.addComponent(txtSegundoApellido, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundosTexts.addComponent(txtDireccion, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundosTexts.addComponent(txtCelular, GroupLayout.DEFAULT_SIZE, 10, 10);
        //sGroupSegundosTexts.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 10, 10);
        //ParallelGroup campos de busqueda
        ParallelGroup pGroupBusqueda = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        pGroupBusqueda.addGroup(sGroupPrimerasLabels);
        pGroupBusqueda.addGap(20, 20, 50);
        pGroupBusqueda.addGroup(sGroupPrimerosTexts);
        pGroupBusqueda.addGap(1, 1, 100);
        pGroupBusqueda.addGroup(sGroupSegundasLabels);
        pGroupBusqueda.addGap(20, 20, 50);
        pGroupBusqueda.addGroup(sGroupSegundosTexts);
        //SequentialGroup sGroupTablaSocios
        SequentialGroup sGroupTablaSocios = gl_contentPane.createSequentialGroup();
        sGroupTablaSocios.addGroup(pGroupBusqueda);
        sGroupTablaSocios.addGap(10);
        sGroupTablaSocios.addComponent(lblSocioIngresado);
        sGroupTablaSocios.addGap(10);
        sGroupTablaSocios.addComponent(pnlSocios, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        sGroupTablaSocios.addGap(5);
        sGroupTablaSocios.addComponent(btnAgregarSocio, GroupLayout.DEFAULT_SIZE, 15, 15);
        sGroupTablaSocios.addComponent(btnAgregarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        //Result
        result.addGroup(sGroupTablaSocios);
        return result;
    }

    public JTextField getTxtNroSocio() {
        return txtNroSocio;
    }

    public void setTxtNroSocio(JTextField txtNroSocio) {
        this.txtNroSocio = txtNroSocio;
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

    public JTextField getTxtPrimerApellido() {
        return txtPrimerApellido;
    }

    public void setTxtPrimerApellido(JTextField txtPrimerApellido) {
        this.txtPrimerApellido = txtPrimerApellido;
    }

    public JTextField getTxtSegundoApellido() {
        return txtSegundoApellido;
    }

    public void setTxtSegundoApellido(JTextField txtSegundoApellido) {
        this.txtSegundoApellido = txtSegundoApellido;
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

    public JTable getTbleSocios() {
        return tbleSocios;
    }

    public void setTbleSocios(JTable tbleSocios) {
        this.tbleSocios = tbleSocios;
    }

    public JScrollPane getScrPnlSocios() {
        return scrPnlSocios;
    }

    public void setScrPnlSocios(JScrollPane scrPnlSocios) {
        this.scrPnlSocios = scrPnlSocios;
    }

    public void mostrarBotonAgregarMascota() {
        btnAgregarSocio.setVisible(false);
        btnAgregarMascota.setVisible(true);
    }

    public void mostrarBotonAgregarSocio() {
        btnAgregarMascota.setVisible(false);
        btnAgregarSocio.setVisible(true);
    }
}
