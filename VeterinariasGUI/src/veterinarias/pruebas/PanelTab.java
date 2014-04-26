package veterinarias.pruebas;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import veterinarias.gui.generics.ButtonX;

public class PanelTab extends JPanel {

    JTabbedPane pesta�as;

    public PanelTab(JTabbedPane p) {
        this.pesta�as = p;
        setOpaque(false);
        JButton button = new ButtonX(pesta�as, this);
        add(button);
    }
}