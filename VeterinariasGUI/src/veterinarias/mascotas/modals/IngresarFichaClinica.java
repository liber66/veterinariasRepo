package veterinarias.mascotas.modals;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import veterinarias.mascotas.actions.BotonConfirmarFichaClinicaAction;
import veterinarias.socios.jframes.NuevasMascotas;

public class IngresarFichaClinica extends JPanel {

    private static final long serialVersionUID = 1L;
    private GroupLayout gl_contentPane;
    private JScrollPane scrPnlInformacion;
    //Atributos
    private NuevasMascotas nuevasMascotas;
    private JDialog dialog;
    //Componentes
    private JTextArea txtInformacion;
    private JButton btnConfirmar;
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
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setAction(btnConfirmarFichaClinicaAction);
        //Agrego al JScrollPAnel el area de texto
        scrPnlInformacion = new JScrollPane();
        scrPnlInformacion.setViewportView(txtInformacion);
        //Armo Group Layout del contentPane
        gl_contentPane = new GroupLayout(this);
        this.setLayout(gl_contentPane);
        gl_contentPane.setHorizontalGroup(horizontalGroupPanel());
        gl_contentPane.setVerticalGroup(verticalGroupPanel());
    }

    private ParallelGroup horizontalGroupPanel() {
        ParallelGroup result = gl_contentPane.createParallelGroup(Alignment.LEADING);
        result.addComponent(scrPnlInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        result.addGap(5);
        result.addComponent(btnConfirmar, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 100, 100);
        return result;
    }

    private ParallelGroup verticalGroupPanel() {
        ParallelGroup result = gl_contentPane.createParallelGroup(Alignment.LEADING);
        //SequentialGroup campo de texto y boton de confirmar
        SequentialGroup sGroupTablaSocios = gl_contentPane.createSequentialGroup();
        sGroupTablaSocios.addComponent(scrPnlInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
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
}
