package veterinarias.socios.jframes;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import veterinarias.mascotas.actions.BotonAgregarFichaClinicaAction;
import veterinarias.mascotas.actions.BotonAgregarMascotaAction;
import veterinarias.pruebas.ImagePanel;

public class NuevasMascotas extends JFrame {

    private static final long serialVersionUID = 1L;
    public static NuevasMascotas mainMenu = null;
    private ImagePanel contentPane;
    private GroupLayout gl_contentPane;
    //Labels
    private JLabel lblNroSocio;
    private JLabel lblNombreMascota;
    private JLabel lblFechaNacimiento;
    private JLabel lblPeso;
    private JLabel lblEspecie;
    private JLabel lblRaza;
    private JLabel lblSexo;
    private JLabel lblMascotasIngresadas;
    //Texts
    private JTextField txtNroSocio;
    private JTextField txtNombreMascota;
    private JTextField txtFechaNacimiento;
    private JTextField txtEspecie;
    private JTextField txtRaza;
    private JTextField txtPeso;
    //Radio Buttoms
    private ButtonGroup rdbtmSexoGroup;
    private JRadioButton rdbtmSexoMacho;
    private JRadioButton rdbtmSexoHembra;
    //Tabla
    private JPanel pnlMascotas;
    private JScrollPane scrPnlMascotas;
    private JTable tbleMascotas;
    private GroupLayout gl_pnlMascotas;
    //Botones
    private JButton btnAgregarMascota;
    private JButton btnAgregarFichaClinica;
    //Acciones
    private BotonAgregarMascotaAction btnAgregarMascotaAction = new BotonAgregarMascotaAction(this);
    private BotonAgregarFichaClinicaAction btnAgregarFichaClinicaAction = new BotonAgregarFichaClinicaAction(this);

    /**
     * Create the frame.
     */
    public NuevasMascotas() {
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

    public static NuevasMascotas getMainMenu() {
        if (mainMenu == null) {
            mainMenu = new NuevasMascotas();
        }
        return mainMenu;
    }

    private void initComponents() {
        contentPane = new ImagePanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Inicializo Labels
        lblNroSocio = new JLabel("Nro Socio:");
        lblNroSocio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblNombreMascota = new JLabel("Nombre Mascota:");
        lblNombreMascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        lblFechaNacimiento.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblEspecie = new JLabel("Especie:");
        lblEspecie.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblRaza = new JLabel("Raza:");
        lblRaza.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblPeso = new JLabel("Peso(g):");
        lblPeso.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblMascotasIngresadas = new JLabel("J.C. Acabas de Ingresar las Siguientes Mascotas... ");
        lblMascotasIngresadas.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        //Inicializo campos de entrada
        txtNroSocio = new JTextField();
        txtNroSocio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtNombreMascota = new JTextField();
        txtNombreMascota.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtEspecie = new JTextField();
        txtEspecie.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtRaza = new JTextField();
        txtRaza.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtPeso = new JTextField();
        txtPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
        //Armo radio buttoms
        rdbtmSexoMacho = new JRadioButton("Macho");
        rdbtmSexoMacho.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtmSexoHembra = new JRadioButton("Hembra");
        rdbtmSexoHembra.setFont(new Font("Tahoma", Font.BOLD, 12));
        rdbtmSexoGroup = new ButtonGroup();
        rdbtmSexoGroup.add(rdbtmSexoMacho);
        rdbtmSexoGroup.add(rdbtmSexoHembra);
        //Inicializo tabla de mascotas
        pnlMascotas = new JPanel();
        pnlMascotas.setBorder(null);
        pnlMascotas.setOpaque(false);
        scrPnlMascotas = new JScrollPane();
        scrPnlMascotas.setBorder(null);
        scrPnlMascotas.setViewportBorder(null);
        scrPnlMascotas.setOpaque(false);
        scrPnlMascotas.getViewport().setOpaque(false);
        tbleMascotas = new JTable();
        scrPnlMascotas.setViewportView(tbleMascotas);
        //Botones
        btnAgregarMascota = new JButton("Agregar Mascota");
        btnAgregarMascota.setAction(btnAgregarMascotaAction);
        btnAgregarFichaClinica = new JButton("Agregar Ficha Clinica");
        btnAgregarFichaClinica.setAction(btnAgregarFichaClinicaAction);
        //Armo Group Layout de Panel Socios
        gl_pnlMascotas = new GroupLayout(pnlMascotas);
        pnlMascotas.setLayout(gl_pnlMascotas);
        gl_pnlMascotas.setHorizontalGroup(horizontalGroupPnlMascotas());
        gl_pnlMascotas.setVerticalGroup(verticalGroupPnlMascotas());
        //Armo Group Layout del contentPane
        gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);
        gl_contentPane.setHorizontalGroup(horizontalGroupContentPane());
        gl_contentPane.setVerticalGroup(verticalGroupContentPane());
    }

    private ParallelGroup horizontalGroupPnlMascotas() {
        ParallelGroup result = gl_pnlMascotas.createParallelGroup(Alignment.LEADING);
        result.addComponent(scrPnlMascotas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        return result;
    }

    private ParallelGroup verticalGroupPnlMascotas() {
        ParallelGroup result = gl_pnlMascotas.createParallelGroup(Alignment.TRAILING);
        result.addComponent(scrPnlMascotas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        return result;
    }

    private ParallelGroup horizontalGroupContentPane() {
        ParallelGroup result = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        //ParallelGroup primeras labels
        ParallelGroup pGroupPrimerasLabels = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        pGroupPrimerasLabels.addComponent(lblNroSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblFechaNacimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblEspecie, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblSexo, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        //ParallelGroup primeros textfields
        ParallelGroup pGroupPrimerosTexts = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        pGroupPrimerosTexts.addComponent(txtNroSocio, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupPrimerosTexts.addComponent(txtFechaNacimiento, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupPrimerosTexts.addComponent(txtEspecie, GroupLayout.DEFAULT_SIZE, 15, 236);
        //SequentialGroup radio buttons
        SequentialGroup sGroupRadioButtons = gl_contentPane.createSequentialGroup();
        sGroupRadioButtons.addComponent(rdbtmSexoMacho, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupRadioButtons.addGap(10);
        sGroupRadioButtons.addComponent(rdbtmSexoHembra, GroupLayout.DEFAULT_SIZE, 10, 10);
        pGroupPrimerosTexts.addGroup(GroupLayout.Alignment.LEADING, sGroupRadioButtons);
        //ParallelGroup segundas labels
        ParallelGroup pGroupSegundasLabels = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        pGroupSegundasLabels.addComponent(lblNombreMascota, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupSegundasLabels.addComponent(lblPeso, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupSegundasLabels.addComponent(lblRaza, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupSegundasLabels.addComponent(btnAgregarFichaClinica, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        //ParallelGroup segundos textfields
        ParallelGroup pGroupSegundosTexts = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        pGroupSegundosTexts.addComponent(txtNombreMascota, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupSegundosTexts.addComponent(txtPeso, GroupLayout.DEFAULT_SIZE, 15, 236);
        pGroupSegundosTexts.addComponent(txtRaza, GroupLayout.DEFAULT_SIZE, 15, 236);
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
        //ParallelGroup agregar texto informacion
        /* ParallelGroup pGroupTextInformacion = gl_contentPane.createParallelGroup(Alignment.LEADING);
         SequentialGroup sGroupInformacion = gl_contentPane.createSequentialGroup();
         sGroupInformacion.addGap(8);
         sGroupInformacion.addComponent(lblInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
         sGroupInformacion.addGap(85);
         sGroupInformacion.addComponent(txtInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 750);
         pGroupTextInformacion.addGroup(sGroupBusqueda);
         pGroupTextInformacion.addGroup(sGroupInformacion);*/
        //ParallelGroup tabla de mascotas agregadas
        ParallelGroup pGroupTablaMascotas = gl_contentPane.createParallelGroup(Alignment.LEADING);
        pGroupTablaMascotas.addComponent(lblMascotasIngresadas);
        pGroupTablaMascotas.addGap(10);
        pGroupTablaMascotas.addComponent(pnlMascotas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        //Result
        result.addGroup(sGroupBusqueda);
        result.addGap(20);
        result.addGroup(pGroupTablaMascotas);
        result.addGap(5);
        result.addComponent(btnAgregarMascota, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 15, 15);
        return result;
    }

    private ParallelGroup verticalGroupContentPane() {
        ParallelGroup result = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        //SequentialGroup primeras labels
        SequentialGroup sGroupPrimerasLabels = gl_contentPane.createSequentialGroup();
        sGroupPrimerasLabels.addGap(5);
        sGroupPrimerasLabels.addComponent(lblNroSocio, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerasLabels.addGap(5);
        sGroupPrimerasLabels.addComponent(lblFechaNacimiento, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerasLabels.addGap(5);
        sGroupPrimerasLabels.addComponent(lblEspecie, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerasLabels.addGap(10);
        sGroupPrimerasLabels.addComponent(lblSexo, GroupLayout.DEFAULT_SIZE, 20, 20);
        //SequentialGroup primeros textfields
        SequentialGroup sGroupPrimerosTexts = gl_contentPane.createSequentialGroup();
        sGroupPrimerosTexts.addContainerGap();
        sGroupPrimerosTexts.addComponent(txtNroSocio, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerosTexts.addComponent(txtFechaNacimiento, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupPrimerosTexts.addComponent(txtEspecie, GroupLayout.DEFAULT_SIZE, 10, 10);
        //ParallelGroup radio buttons
        ParallelGroup pGroupRadioButtons = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        pGroupRadioButtons.addComponent(rdbtmSexoMacho, GroupLayout.DEFAULT_SIZE, 30, 30);
        pGroupRadioButtons.addGap(10);
        pGroupRadioButtons.addComponent(rdbtmSexoHembra, GroupLayout.DEFAULT_SIZE, 30, 30);
        sGroupPrimerosTexts.addGap(5);
        sGroupPrimerosTexts.addGroup(pGroupRadioButtons);
        //sGroupPrimerosTexts.addContainerGap();
        //SequentialGroup segundas labels
        SequentialGroup sGroupSegundasLabels = gl_contentPane.createSequentialGroup();
        sGroupSegundasLabels.addGap(5);
        sGroupSegundasLabels.addComponent(lblNombreMascota, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundasLabels.addGap(5);
        sGroupSegundasLabels.addComponent(lblPeso, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundasLabels.addGap(5);
        sGroupSegundasLabels.addComponent(lblRaza, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundasLabels.addGap(10);
        sGroupSegundasLabels.addComponent(btnAgregarFichaClinica, GroupLayout.DEFAULT_SIZE, 10, 10);
        //SequentialGroup segundos textfields
        SequentialGroup sGroupSegundosTexts = gl_contentPane.createSequentialGroup();
        sGroupSegundosTexts.addContainerGap();
        sGroupSegundosTexts.addComponent(txtNombreMascota, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundosTexts.addComponent(txtPeso, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundosTexts.addComponent(txtRaza, GroupLayout.DEFAULT_SIZE, 10, 10);
        //ParallelGroup informacion
        /*ParallelGroup pGroupInformacion = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        pGroupInformacion.addGap(8);
        pGroupInformacion.addComponent(lblInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupInformacion.addGap(85);
        pGroupInformacion.addComponent(txtInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 750);*/
        //ParallelGroup campos de busqueda
        ParallelGroup pGroupBusqueda = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        pGroupBusqueda.addGroup(sGroupPrimerasLabels);
        pGroupBusqueda.addGap(20, 20, 50);
        pGroupBusqueda.addGroup(sGroupPrimerosTexts);
        pGroupBusqueda.addGap(1, 1, 100);
        pGroupBusqueda.addGroup(sGroupSegundasLabels);
        pGroupBusqueda.addGap(20, 20, 50);
        pGroupBusqueda.addGroup(sGroupSegundosTexts);
        //SequentialGroup tabla de mascotas agregadas
        SequentialGroup sGroupTablaMascotas = gl_contentPane.createSequentialGroup();
        sGroupTablaMascotas.addGroup(pGroupBusqueda);
        sGroupTablaMascotas.addGap(10);
        //sGroupTablaMascotas.addGroup(pGroupInformacion);
        sGroupTablaMascotas.addComponent(lblMascotasIngresadas);
        sGroupTablaMascotas.addGap(10);
        sGroupTablaMascotas.addComponent(pnlMascotas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        sGroupTablaMascotas.addGap(5);
        sGroupTablaMascotas.addComponent(btnAgregarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        //Result
        result.addGroup(sGroupTablaMascotas);
        return result;
    }

    public JTextField getTxtNroSocio() {
        return txtNroSocio;
    }

    public void setTxtNroSocio(JTextField txtNroSocio) {
        this.txtNroSocio = txtNroSocio;
    }

    public JTextField getTxtNombreMascota() {
        return txtNombreMascota;
    }

    public void setTxtNombreMascota(JTextField txtNombreMascota) {
        this.txtNombreMascota = txtNombreMascota;
    }

    public JTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    public JTextField getTxtEspecie() {
        return txtEspecie;
    }

    public void setTxtEspecie(JTextField txtEspecie) {
        this.txtEspecie = txtEspecie;
    }

    public JTextField getTxtRaza() {
        return txtRaza;
    }

    public void setTxtRaza(JTextField txtRaza) {
        this.txtRaza = txtRaza;
    }

    public JTextField getTxtPeso() {
        return txtPeso;
    }

    public void setTxtPeso(JTextField txtPeso) {
        this.txtPeso = txtPeso;
    }

    public ButtonGroup getRdbtmSexoGroup() {
        return rdbtmSexoGroup;
    }

    public void setRdbtmSexoGroup(ButtonGroup rdbtmSexoGroup) {
        this.rdbtmSexoGroup = rdbtmSexoGroup;
    }

    public JScrollPane getScrPnlMascotas() {
        return scrPnlMascotas;
    }

    public void setScrPnlMascotas(JScrollPane scrPnlMascotas) {
        this.scrPnlMascotas = scrPnlMascotas;
    }
}
