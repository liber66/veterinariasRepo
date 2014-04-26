package veterinarias.gui.generics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

public class ButtonX extends JButton implements MouseListener {

    private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;
    private JPanel panelPestania;

    public ButtonX(JTabbedPane tabPane, JPanel panelPestania) {
        //Recuerdo el TabbedPane y el panel de la pestaña para cerrar la pestaña cuando se presiona la x 
        this.tabbedPane = tabPane;
        this.panelPestania = panelPestania;
        //Seteo atributos del boton x
        int size = 17;
        setPreferredSize(new Dimension(size, size));
        setToolTipText("Cerrar Pestaña");
        setUI(new BasicButtonUI());
        setContentAreaFilled(false);
        setFocusable(false);
        setBorder(BorderFactory.createEtchedBorder());
        setBorderPainted(false);
        addMouseListener(this);
        setRolloverEnabled(true);
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = tabbedPane.indexOfTabComponent(ButtonX.this.panelPestania);
                if (pos != -1 && tabbedPane.getTabCount() > 2) {
                    tabbedPane.remove(pos);
                }
            }
        });
    }

    public void updateUI() {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (getModel().isPressed()) {
            g2.translate(1, 1);
        }
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.BLACK);
        if (getModel().isRollover()) {
            g2.setColor(Color.RED);
        }
        g2.drawLine(5, 5, 12, 12);
        g2.drawLine(12, 6, 6, 12);
        g2.dispose();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component component = e.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component = e.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
