package veterinarias.pruebas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal extends JApplet {

    private JTabbedPane pestaņas;

    public void init() {
        colocarSkin();
        pestaņas = new JTabbedPane();
        colocarPestaņasPredeterminadas();
        JPanel pboton = new JPanel();
        JButton restaurar = new JButton("Restaurar");
        restaurar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < pestaņas.getTabCount(); i++) {
                    pestaņas.removeTabAt(i);
                }
                colocarPestaņasPredeterminadas();
            }
        });
        pboton.add(restaurar);
        add(pestaņas);
        add(pboton, BorderLayout.SOUTH);
    }

    public void colocarPestaņasPredeterminadas() {
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Java Zone"));
        JPanel p2 = new JPanel();
        p2.add(new JLabel("JTabbedPane con X como imagen"));
        JPanel p3 = new JPanel();
        p3.add(new JLabel("JTabbedPane con X dibujada"));
        PanelTab btc = new PanelTab(pestaņas);
        PanelTab btc2 = new PanelTab(pestaņas);
        PanelTab btc3 = new PanelTab(pestaņas);
        pestaņas.addTab("Prueba", p1);
        pestaņas.addTab("Prueba Java Zone", p2);
        pestaņas.addTab("Prueba Java Zone", p3);
        pestaņas.setTabComponentAt(0, btc);
        pestaņas.setTabComponentAt(1, btc2);
        pestaņas.setTabComponentAt(2, btc3);
    }

    public void colocarSkin() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}