package veterinarias.consultas.jpanels;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VerSociosPorNombrePaso2 extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public VerSociosPorNombrePaso2() {
        initComponents();
    }

    private void initComponents() {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450,
                Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300,
                Short.MAX_VALUE));
        JLabel lblAsdadad = new JLabel("asdadad");
        tabbedPane.addTab("New tab", null, lblAsdadad, null);
        JLabel lblGfgh = new JLabel("gfgh");
        tabbedPane.addTab("New tab", null, lblGfgh, null);
        JLabel lblBkjhjkhkjjhk = new JLabel("bkjhjkhkjjhk");
        tabbedPane.addTab("New tab", null, lblBkjhjkhkjjhk, null);
        this.setLayout(layout);
    }
}
