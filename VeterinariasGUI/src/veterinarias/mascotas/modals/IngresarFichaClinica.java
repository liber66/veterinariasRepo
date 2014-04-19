package veterinarias.mascotas.modals;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IngresarFichaClinica extends JPanel {

    private static final long serialVersionUID = 1L;
    private GroupLayout gl_contentPane;
    private JScrollPane scrPnlInformacion;
    //Texts
    private JTextArea txtInformacion;

    /**
     * Create the panel.
     */
    public IngresarFichaClinica() {
        this.initComponents();
    }

    protected void initComponents() {
        txtInformacion = new JTextArea(10, 50);
        txtInformacion.setLineWrap(true);
        txtInformacion.setWrapStyleWord(true);
        txtInformacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
        return result;
    }

    private ParallelGroup verticalGroupPanel() {
        ParallelGroup result = gl_contentPane.createParallelGroup(Alignment.TRAILING);
        result.addComponent(scrPnlInformacion, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        return result;
    }
}
