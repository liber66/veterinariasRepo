package veterinarias.gui.generics;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GenericTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    private static String SIMBOLO_AGREGAR_PESTANIA = "+";
    private Component additionTab;

    public GenericTabbedPane(int tabPlacement) {
        super(tabPlacement);
    }

    public void addClosableTab(String title, Component component) {
        super.addTab(title, component);
        //Creo panel para la pestania inicial
        JPanel panelPestania = new JPanel();
        panelPestania.setOpaque(false);
        JLabel tituloPestania = new JLabel("New Tab");
        panelPestania.add(tituloPestania);
        ButtonX buttonX = new ButtonX(this, panelPestania);
        panelPestania.add(buttonX);
        int pos = getTabCount() - 1;
        setTabComponentAt(pos, panelPestania);
    }

    public void addClosableTabWithAddTab(String title, Component component) {
        //Si ya existe la additionTab => la elimino para luego agregarla como ultima pestaņa.
        if (getTabCount() > 0) {
            remove(additionTab);
        }
        super.addTab(title, component);
        //Creo panel para la pestania inicial
        JPanel panelPestania = new JPanel();
        panelPestania.setOpaque(false);
        JLabel tituloPestania = new JLabel("New Tab");
        tituloPestania.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        panelPestania.add(tituloPestania);
        ButtonX buttonX = new ButtonX(this, panelPestania);
        panelPestania.add(buttonX);
        int pos = getTabCount() - 1;
        setTabComponentAt(pos, panelPestania);
        //Agrego la additionTab como ultima pestaņa
        this.addAdditionTab();
    }

    public void addAdditionTab() {
        //Agrego pestaņa con simbolo "+" para poder agregar nuevas pestaņas dinamicamente
        JPanel panelAgregarPestaņa = new JPanel();
        panelAgregarPestaņa.setName(SIMBOLO_AGREGAR_PESTANIA);
        super.addTab(SIMBOLO_AGREGAR_PESTANIA, panelAgregarPestaņa);
        additionTab = getComponent(getTabCount());
    }
}
