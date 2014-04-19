package veterinarias.gui.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import veterinarias.principal.actions.BuscarMascotaAction;
import veterinarias.principal.actions.BuscarSocioAction;
import veterinarias.principal.actions.NuevasMascotasAction;
import veterinarias.principal.actions.NuevoSocioAction;

public class PrincipalJFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    //private final Action buscarSocioPorNombreAction = ;
    public static PrincipalJFrame mainMenu = null;

    //private ImagePanel fondo;
    public static PrincipalJFrame getMainMenu() {
        if (mainMenu == null) {
            mainMenu = new PrincipalJFrame();
        }
        return mainMenu;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    PrincipalJFrame frame = new PrincipalJFrame();
                    frame.setVisible(true);
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PrincipalJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Double width = d.getWidth();
        Double height = d.getHeight() - 35;
        Double x = width / 1500;
        Double y = height / 700;
        setBounds(x.intValue(), y.intValue(), width.intValue(), height.intValue());
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu mnSesion = new JMenu("Sesi\u00F3n");
        menuBar.add(mnSesion);
        JMenuItem mntmIniciarSesion = new JMenuItem("Iniciar Sesi\u00F3n");
        mnSesion.add(mntmIniciarSesion);
        JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
        mnSesion.add(mntmCerrarSesion);
        JMenuItem mntmCrearUsuario = new JMenuItem("Crear Usuario");
        mnSesion.add(mntmCrearUsuario);
        JMenu mnSocios = new JMenu("Socios");
        menuBar.add(mnSocios);
        JMenuItem mntmNuevoSocio = new JMenuItem("Nuevo Socio");
        mntmNuevoSocio.setAction(new NuevoSocioAction());
        mnSocios.add(mntmNuevoSocio);
        JMenuItem mntmBuscarSocio = new JMenuItem("Buscar Socio");
        mntmBuscarSocio.setAction(new BuscarSocioAction());
        mnSocios.add(mntmBuscarSocio);
        JMenuItem mntmEliminarSocio = new JMenuItem("Eliminar Socio");
        mnSocios.add(mntmEliminarSocio);
        JMenu mnMascotas = new JMenu("Mascotas");
        menuBar.add(mnMascotas);
        JMenuItem mntmNuevasMascotas = new JMenuItem("Nuevas Mascotas");
        mntmNuevasMascotas.setAction(new NuevasMascotasAction());
        mnMascotas.add(mntmNuevasMascotas);
        JMenuItem mntmBuscarMascotas = new JMenuItem("Buscar Mascotas");
        mntmBuscarMascotas.setAction(new BuscarMascotaAction());
        mnMascotas.add(mntmBuscarMascotas);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        //
        /*fondo = new ImagePanel();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(fondo,
                javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)));
        fondo.setImagen("perro.jpg");*/
    }
}
