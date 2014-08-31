package veterinarias.socios.jframes;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import veterinarias.gui.generics.GenericMaskFormatter;
import veterinarias.gui.generics.GenericTablePanel;
import veterinarias.mascotas.actions.BotonAgregarFichaClinicaAction;
import veterinarias.mascotas.actions.BotonAgregarMascotaAction;
import veterinarias.mascotas.actions.BotonAgregarVacunasAction;
import veterinarias.mascotas.actions.BotonCofirmarMascotasAction;
import veterinarias.mascotas.actions.BotonEliminarMascotaAction;
import veterinarias.mascotas.actions.BotonLimpiarAction;
import veterinarias.mascotas.actions.BotonModificarMascotaAction;
import veterinarias.mascotas.modals.IngresarFichaClinica;
import veterinarias.objects.trans.FichaClinicaTrans;
import veterinarias.objects.trans.VacunaTrans;
import veterinarias.pruebas.ImagePanel;

public class NuevasMascotas extends JFrame {

    private static final long serialVersionUID = 1L;
    public static NuevasMascotas mainMenu = null;
    private ImagePanel contentPane;
    private GroupLayout gl_contentPane;
    //Atributos
    protected IngresarFichaClinica ingresarFichaClinica;
    //private AgregarVacunas agregarVacunas;
    private List<VacunaTrans> vacunasTrans;
    private List<FichaClinicaTrans> fichasClinicasTrans;
    //Lista que contiene las fichas clinicas de las mascotas ingresadas, donde el indice en la lista se corresponde
    //con el indice en la tabla de la mascota a la cual pertenecen
    private List<IngresarFichaClinica> fichasClinicasIngresadas = new ArrayList<IngresarFichaClinica>();
    private String informacion;
    private static String AGREGAR_FICHA_CLINICA = "Agregar Ficha Clinica";
    private static String MODIFICAR_FICHA_CLINICA = "Modificar Ficha Clinica";
    private static String AGREGAR_VACUNAS = "Agregar Vacunas";
    private boolean estoyAgregando;
    private boolean estoyModificando;
    private boolean estoyEliminando;
    //Labels
    protected JLabel lblNroSocio;
    protected JLabel lblNombreMascota;
    protected JLabel lblFechaNacimiento;
    protected JLabel lblPeso;
    protected JLabel lblEspecie;
    protected JLabel lblRaza;
    protected JLabel lblSexo;
    protected JLabel lblMascotasIngresadas;
    //Texts
    protected JTextField txtNroSocio;
    protected JTextField txtNombreMascota;
    protected JFormattedTextField txtFechaNacimiento;
    protected JTextField txtEspecie;
    protected JTextField txtRaza;
    protected JTextField txtPeso;
    //Radio Buttoms
    protected ButtonGroup rdbtmSexoGroup;
    protected JRadioButton rdbtmSexoMacho;
    protected JRadioButton rdbtmSexoHembra;
    //Tabla
    private GenericTablePanel tablaMascotas;
    //Botones
    private JButton btnAgregarFichaClinica;
    private JButton btnLimpiar;
    private JButton btnAgregarMascota;
    private JButton btnModificarMascota;
    private JButton btnEliminarMascota;
    protected JButton btnConfirmar;
    protected JButton btnAgregarVacunas;
    //Acciones
    private BotonAgregarMascotaAction btnAgregarMascotaAction = new BotonAgregarMascotaAction(this);
    private BotonModificarMascotaAction btnModificarMascotaAction = new BotonModificarMascotaAction(this);
    private BotonEliminarMascotaAction btnEliminarMascotaAction = new BotonEliminarMascotaAction(this);
    protected BotonCofirmarMascotasAction btnCofirmarMascotasAction = new BotonCofirmarMascotasAction(this);
    private BotonAgregarFichaClinicaAction btnAgregarFichaClinicaAction = new BotonAgregarFichaClinicaAction(this, AGREGAR_FICHA_CLINICA);
    private BotonLimpiarAction btnLimpiarAction = new BotonLimpiarAction(this);
    private BotonAgregarVacunasAction btnAgregarVacunasAction = new BotonAgregarVacunasAction(this);

    /**
     * Create the frame.
     */
    public NuevasMascotas() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        int ancho = d.width * 2 / 3;
        int alto = d.height * 2 / 3;
        setSize(ancho, alto);
        setLocation(d.width / 2 - ancho / 2, d.height / 2 - alto / 2);
        setMinimumSize(new Dimension(ancho, alto));
        this.initComponents();
        contentPane.setImagen("mascotas4.jpg");
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
        //Inicializo atributos
        estoyAgregando = false;
        estoyModificando = false;
        estoyEliminando = false;
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
        lblMascotasIngresadas = new JLabel("Las Siguientes Mascotas Seran Ingresadas... ");
        lblMascotasIngresadas.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblMascotasIngresadas.setVisible(false);
        //Inicializo campos de entrada
        txtNroSocio = new JTextField();
        txtNroSocio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtNombreMascota = new JTextField();
        txtNombreMascota.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtFechaNacimiento = new JFormattedTextField(GenericMaskFormatter.getDateMask());
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
        String[] nombresColumnas = { "Nro Socio", "Nombre", "Fecha Nacimiento", "Peso (g)", "Especie", "Raza", "Sexo" };
        int[] minWidthColumns = { 72, 136, 112, 64, 104, 120, 40 };
        int[] maxWidthColumns = { 72, -1, 112, 64, -1, -1, 40 };
        tablaMascotas = new GenericTablePanel(nombresColumnas, minWidthColumns, null, maxWidthColumns);
        tablaMascotas.setTitleFont(new Font("Comic Sans MS", Font.BOLD, 12));
        int[] posColumnasCentradas = { 2, 6 };
        tablaMascotas.centrarColumnas(posColumnasCentradas);
        tablaMascotas.visualizar(false);
        tablaMascotas.getTable().getSelectionModel().addListSelectionListener(new RowListener());
        //Botones
        btnAgregarMascota = new JButton("Agregar Mascota");
        btnAgregarMascota.setAction(btnAgregarMascotaAction);
        btnModificarMascota = new JButton("Modificar Mascota");
        btnModificarMascota.setAction(btnModificarMascotaAction);
        btnModificarMascota.setEnabled(false);
        btnEliminarMascota = new JButton("Eliminar Mascota");
        btnEliminarMascota.setAction(btnEliminarMascotaAction);
        btnEliminarMascota.setEnabled(false);
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setAction(btnCofirmarMascotasAction);
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setAction(btnLimpiarAction);
        btnConfirmar.setEnabled(false);
        btnAgregarFichaClinica = new JButton(AGREGAR_FICHA_CLINICA);
        btnAgregarFichaClinica.setAction(btnAgregarFichaClinicaAction);
        btnAgregarVacunas = new JButton(AGREGAR_VACUNAS);
        btnAgregarVacunas.setAction(btnAgregarVacunasAction);
        //Armo Group Layout del contentPane
        gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);
        gl_contentPane.setHorizontalGroup(horizontalGroupContentPane());
        gl_contentPane.setVerticalGroup(verticalGroupContentPane());
    }

    private ParallelGroup horizontalGroupContentPane() {
        ParallelGroup result = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        //ParallelGroup primeras labels
        ParallelGroup pGroupPrimerasLabels = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        pGroupPrimerasLabels.addComponent(lblNroSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblFechaNacimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblEspecie, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(lblSexo, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, 50);
        pGroupPrimerasLabels.addComponent(btnLimpiar, GroupLayout.DEFAULT_SIZE, 120, 120);
        //ParallelGroup primeros textfields
        ParallelGroup pGroupPrimerosTexts = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        pGroupPrimerosTexts.addComponent(txtNroSocio, 130, 130, 236);
        pGroupPrimerosTexts.addComponent(txtFechaNacimiento, 130, 130, 236);
        pGroupPrimerosTexts.addComponent(txtEspecie, 130, 130, 236);
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
        pGroupSegundasLabels.addComponent(btnAgregarFichaClinica, GroupLayout.Alignment.LEADING, 160, 160, 160);
        //ParallelGroup segundos textfields
        ParallelGroup pGroupSegundosTexts = gl_contentPane.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        pGroupSegundosTexts.addComponent(txtNombreMascota, 130, 130, 236);
        pGroupSegundosTexts.addComponent(txtPeso, 130, 130, 236);
        pGroupSegundosTexts.addComponent(txtRaza, 130, 130, 236);
        pGroupSegundosTexts.addComponent(btnAgregarVacunas, GroupLayout.Alignment.LEADING, 160, 160, 160);
        //SequentialGroup 
        SequentialGroup sGroupBusqueda = gl_contentPane.createSequentialGroup();
        sGroupBusqueda.addContainerGap();
        sGroupBusqueda.addGroup(pGroupPrimerasLabels);
        sGroupBusqueda.addContainerGap(20, 50);
        sGroupBusqueda.addGroup(pGroupPrimerosTexts);
        sGroupBusqueda.addGap(1, 1, Short.MAX_VALUE);
        sGroupBusqueda.addGroup(pGroupSegundasLabels);
        sGroupBusqueda.addContainerGap(20, 50);
        sGroupBusqueda.addGroup(pGroupSegundosTexts);
        //ParallelGroup tabla de mascotas agregadas
        ParallelGroup pGroupTablaMascotas = gl_contentPane.createParallelGroup(Alignment.LEADING);
        pGroupTablaMascotas.addComponent(lblMascotasIngresadas);
        pGroupTablaMascotas.addGap(10);
        pGroupTablaMascotas.addComponent(tablaMascotas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        //SequentialGroup botonera abajo
        SequentialGroup sGroupBotones = gl_contentPane.createSequentialGroup();
        sGroupBotones.addGap(20);
        sGroupBotones.addComponent(btnAgregarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        sGroupBotones.addGap(20);
        sGroupBotones.addComponent(btnModificarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        sGroupBotones.addGap(20);
        sGroupBotones.addComponent(btnEliminarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        sGroupBotones.addGap(150, 150, Short.MAX_VALUE);
        sGroupBotones.addComponent(btnConfirmar, GroupLayout.DEFAULT_SIZE, 15, 15);
        //Result
        result.addGroup(sGroupBusqueda);
        result.addGap(20);
        result.addGroup(pGroupTablaMascotas);
        result.addGap(5);
        result.addGroup(Alignment.CENTER, sGroupBotones);
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
        sGroupPrimerasLabels.addGap(13);
        sGroupPrimerasLabels.addComponent(lblSexo, GroupLayout.DEFAULT_SIZE, 20, 20);
        sGroupPrimerasLabels.addGap(10);
        sGroupPrimerasLabels.addComponent(btnLimpiar, GroupLayout.DEFAULT_SIZE, 15, 15);
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
        sGroupPrimerosTexts.addGap(8);
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
        sGroupSegundasLabels.addGap(13);
        sGroupSegundasLabels.addComponent(btnAgregarFichaClinica, GroupLayout.DEFAULT_SIZE, 10, 10);
        //SequentialGroup segundos textfields
        SequentialGroup sGroupSegundosTexts = gl_contentPane.createSequentialGroup();
        sGroupSegundosTexts.addContainerGap();
        sGroupSegundosTexts.addComponent(txtNombreMascota, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundosTexts.addComponent(txtPeso, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundosTexts.addComponent(txtRaza, GroupLayout.DEFAULT_SIZE, 10, 10);
        sGroupSegundosTexts.addGap(10);
        sGroupSegundosTexts.addComponent(btnAgregarVacunas, GroupLayout.DEFAULT_SIZE, 10, 10);
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
        //ParallelGroup botonera abajo
        ParallelGroup pGroupBotones = gl_contentPane.createParallelGroup(Alignment.LEADING);
        pGroupBotones.addGap(40);
        pGroupBotones.addComponent(btnAgregarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        pGroupBotones.addGap(10);
        pGroupBotones.addComponent(btnModificarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        pGroupBotones.addGap(50);
        pGroupBotones.addComponent(btnEliminarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        pGroupBotones.addGap(50);
        pGroupBotones.addComponent(btnConfirmar, GroupLayout.DEFAULT_SIZE, 15, 15);
        //SequentialGroup tabla de mascotas agregadas
        SequentialGroup sGroupTablaMascotas = gl_contentPane.createSequentialGroup();
        sGroupTablaMascotas.addGroup(pGroupBusqueda);
        sGroupTablaMascotas.addGap(20);
        sGroupTablaMascotas.addComponent(lblMascotasIngresadas);
        sGroupTablaMascotas.addGap(10);
        sGroupTablaMascotas.addComponent(tablaMascotas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        sGroupTablaMascotas.addGap(5);
        //sGroupTablaMascotas.addComponent(btnAgregarMascota, GroupLayout.DEFAULT_SIZE, 15, 15);
        sGroupTablaMascotas.addGroup(pGroupBotones);
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

    public JFormattedTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(JFormattedTextField txtFechaNacimiento) {
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

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public GenericTablePanel getTablaMascotas() {
        return tablaMascotas;
    }

    public void setTablaMascotas(GenericTablePanel tablaMascotas) {
        this.tablaMascotas = tablaMascotas;
    }

    public void agregarFichaClinica(String informacion) {
        if (informacion == null || informacion.isEmpty()) {
            btnAgregarFichaClinica.setText(AGREGAR_FICHA_CLINICA);
        } else {
            btnAgregarFichaClinica.setText(MODIFICAR_FICHA_CLINICA);
        }
        this.informacion = informacion;
    }

    //METODO REUTILIZABLE CUANDO HAGA EL CONIRMAR
    /* public void agregarFichasClinicas(GenericTabbedPane tabbedPane) {
         fichasClinicasTrans = new ArrayList<FichaClinicaTrans>();
         for (Component pestania : tabbedPane.getComponents()) {
             JPanel jpanel = (JPanel) pestania;
             FichaClinicaTrans fichaClinicaTrans = new FichaClinicaTrans();
             String informacion = null;
             for (Component component : jpanel.getComponents()) {
                 if (component instanceof JDateChooser) {
                     Date fecha = ((JDateChooser) component).getDate();
                     fichaClinicaTrans.setFecha(fecha);
                 }
                 if (component instanceof JScrollPane) {
                     JViewport jViewport = ((JScrollPane) component).getViewport();
                     informacion = ((JTextArea) jViewport.getComponent(0)).getText();
                     fichaClinicaTrans.setInformacion(informacion);
                 }
             }
             //Falta filtrar si la informacion contiene caracteres en blanco, tabs...etc
             if (informacion != null && !informacion.isEmpty()) {
                 fichasClinicasTrans.add(fichaClinicaTrans);
             }
         }
     }*/
    private class RowListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent event) {
            cargarValores(event);
        }
    }

    private void cargarValores(ListSelectionEvent evt) {
        JTable table = tablaMascotas.getTable();
        int rowPos = table.getSelectedRow();
        if (rowPos != -1 && !(estoyAgregando || estoyModificando || estoyEliminando)) {
            txtNroSocio.setText(table.getValueAt(rowPos, 0).toString());
            txtNombreMascota.setText(table.getValueAt(rowPos, 1).toString());
            txtFechaNacimiento.setText(table.getValueAt(rowPos, 2).toString());
            txtPeso.setText(table.getValueAt(rowPos, 3).toString());
            txtEspecie.setText(table.getValueAt(rowPos, 4).toString());
            txtRaza.setText(table.getValueAt(rowPos, 5).toString());
            if ("M".equals(table.getValueAt(rowPos, 6).toString())) {
                rdbtmSexoMacho.setSelected(true);
            } else {
                rdbtmSexoHembra.setSelected(true);
            }
            ingresarFichaClinica = fichasClinicasIngresadas.get(rowPos);
            this.habilitarBotones(true);
            this.habilitarBotonConfirmar(true);
            this.habilitarBotonAgregar(false);
        }
    }

    public void habilitarBotones(boolean enable) {
        btnModificarMascota.setEnabled(enable);
        btnEliminarMascota.setEnabled(enable);
    }

    public void habilitarBotonConfirmar(boolean enable) {
        btnConfirmar.setEnabled(enable);
    }

    public JLabel getLblMascotasIngresadas() {
        return lblMascotasIngresadas;
    }

    public void setLblMascotasIngresadas(JLabel lblMascotasIngresadas) {
        this.lblMascotasIngresadas = lblMascotasIngresadas;
    }

    public void limpiarCampos() {
        txtNroSocio.setText("");
        txtNombreMascota.setText("");
        txtFechaNacimiento.setText("");
        txtPeso.setText("");
        txtEspecie.setText("");
        txtRaza.setText("");
        rdbtmSexoGroup.clearSelection();
        ingresarFichaClinica = null;
        vacunasTrans = new ArrayList<VacunaTrans>();
    }

    public IngresarFichaClinica getIngresarFichaClinica() {
        return ingresarFichaClinica;
    }

    public void setIngresarFichaClinica(IngresarFichaClinica ingresarFichaClinica) {
        this.ingresarFichaClinica = ingresarFichaClinica;
    }

    public List<IngresarFichaClinica> getFichasClinicasIngresadas() {
        return fichasClinicasIngresadas;
    }

    public void setFichasClinicasIngresadas(List<IngresarFichaClinica> fichasClinicasIngresadas) {
        this.fichasClinicasIngresadas = fichasClinicasIngresadas;
    }

    public void eiminarFichaClinica(int pos) {
        fichasClinicasIngresadas.remove(pos);
    }

    public boolean isEstoyAgregando() {
        return estoyAgregando;
    }

    public void setEstoyAgregando(boolean estoyAgregando) {
        this.estoyAgregando = estoyAgregando;
    }

    public boolean isEstoyModificando() {
        return estoyModificando;
    }

    public void setEstoyModificando(boolean estoyModificando) {
        this.estoyModificando = estoyModificando;
    }

    public boolean isEstoyEliminando() {
        return estoyEliminando;
    }

    public void setEstoyEliminando(boolean estoyEliminando) {
        this.estoyEliminando = estoyEliminando;
    }

    public void modificarFichaClinica(int rowPos, IngresarFichaClinica ingresarFichaClinica) {
        fichasClinicasIngresadas.set(rowPos, ingresarFichaClinica);
    }

    public void agregarFichaClinica(int rowPos, IngresarFichaClinica ingresarFichaClinica) {
        fichasClinicasIngresadas.add(rowPos, ingresarFichaClinica);
    }

    public void habilitarBotonAgregar(boolean enable) {
        btnAgregarMascota.setEnabled(enable);
    }

    public List<VacunaTrans> getVacunasTrans() {
        return vacunasTrans;
    }

    public void setVacunasTrans(List<VacunaTrans> vacunasTrans) {
        this.vacunasTrans = vacunasTrans;
    }

    public List<FichaClinicaTrans> getFichasClinicasTrans() {
        return fichasClinicasTrans;
    }

    public void setFichasClinicasTrans(List<FichaClinicaTrans> fichasClinicasTrans) {
        this.fichasClinicasTrans = fichasClinicasTrans;
    }
}
