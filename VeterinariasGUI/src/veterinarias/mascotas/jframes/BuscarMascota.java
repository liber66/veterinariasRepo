package veterinarias.mascotas.jframes;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import veterinarias.pruebas.ImagePanel;

public class BuscarMascota extends JFrame {

    private static final long serialVersionUID = 1L;
    private ImagePanel contentPane;

    /**
     * Create the frame.
     */
    public BuscarMascota() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        int ancho = d.width * 2 / 3;
        int alto = d.height * 2 / 3;
        setSize(ancho, alto);
        setLocation(d.width / 2 - ancho / 2, d.height / 2 - alto / 2);
        setMinimumSize(new Dimension(ancho, alto));
        this.initComponents();
        contentPane.setImagen("perro.jpg");
        contentPane.setVisible(true);
    }

    protected void initComponents() {
        contentPane = new ImagePanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
    }
}
