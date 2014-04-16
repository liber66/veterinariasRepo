package veterinarias.consultas.jpanels;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import veterinarias.pruebas.ImagePanel;

public class VerMascotas extends JFrame {

    private ImagePanel contentPane;
    private GroupLayout gl_contentPane;
    private JButton boton;

    /**
     * Create the frame.
     */
    public VerMascotas() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = d.width * 2 / 3;
        int alto = d.height * 2 / 3;
        setSize(ancho, alto);
        setLocation(d.width / 2 - ancho / 2, d.height / 2 - alto / 2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.initComponents();
        contentPane.setVisible(true);
        contentPane.setImagen("perro.jpg");
    }

    private void initComponents() {
        contentPane = new ImagePanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        boton = new JButton("boton");
        gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);
        gl_contentPane.setHorizontalGroup(this.alineamientoHorizontal());
        gl_contentPane.setVerticalGroup(this.alineamientoVertical());
        //gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 664, Short.MAX_VALUE));
        //gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 468, Short.MAX_VALUE));
        //
        
    }

    private ParallelGroup alineamientoHorizontal() {
        ParallelGroup parallelGroup = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        SequentialGroup sequentialGroup = gl_contentPane.createSequentialGroup();
        sequentialGroup.addContainerGap(); /* colocamos un espacio vacio a la zquierda del componente */
        sequentialGroup.addComponent(boton, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE);
        sequentialGroup.addContainerGap(); /* colocamos un espacio vacio a la derecha del componente */
        parallelGroup.addGroup(sequentialGroup);
        return parallelGroup;
    }

    private ParallelGroup alineamientoVertical() {
        ParallelGroup parallelGroup = gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING);
        SequentialGroup sequentialGroup = gl_contentPane.createSequentialGroup();
        sequentialGroup.addContainerGap(); /* colocamos un espacio vacio arriba del componente */
        sequentialGroup.addComponent(boton, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE);
        sequentialGroup.addContainerGap(); /* colocamos un espacio vacio abajo del componente */
        parallelGroup.addGroup(sequentialGroup);
        return parallelGroup;
    }
}
