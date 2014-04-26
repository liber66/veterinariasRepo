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

    private JTabbedPane pestañas;

    public void init() {
        colocarSkin();
        pestañas = new JTabbedPane();
        colocarPestañasPredeterminadas();
        JPanel pboton = new JPanel();
        JButton restaurar = new JButton("Restaurar");
        restaurar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < pestañas.getTabCount(); i++) {
                    pestañas.removeTabAt(i);
                }
                colocarPestañasPredeterminadas();
            }
        });
        pboton.add(restaurar);
        add(pestañas);
        add(pboton, BorderLayout.SOUTH);
    }

    public void colocarPestañasPredeterminadas() {
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Java Zone"));
        JPanel p2 = new JPanel();
        p2.add(new JLabel("JTabbedPane con X como imagen"));
        JPanel p3 = new JPanel();
        p3.add(new JLabel("JTabbedPane con X dibujada"));
        PanelTab btc = new PanelTab(pestañas);
        PanelTab btc2 = new PanelTab(pestañas);
        PanelTab btc3 = new PanelTab(pestañas);
        pestañas.addTab("Prueba", p1);
        pestañas.addTab("Prueba Java Zone", p2);
        pestañas.addTab("Prueba Java Zone", p3);
        pestañas.setTabComponentAt(0, btc);
        pestañas.setTabComponentAt(1, btc2);
        pestañas.setTabComponentAt(2, btc3);
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