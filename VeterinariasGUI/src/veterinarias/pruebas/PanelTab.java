package veterinarias.pruebas;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import veterinarias.gui.generics.ButtonX;

public class PanelTab extends JPanel {

    JTabbedPane pestañas;

    public PanelTab(JTabbedPane p) {
        this.pestañas = p;
        setOpaque(false);
        JButton button = new ButtonX(pestañas, this);
        add(button);
    }
}