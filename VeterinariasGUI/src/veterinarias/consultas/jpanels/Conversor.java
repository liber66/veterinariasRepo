package veterinarias.consultas.jpanels;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Conversor {

    protected JLabel etiqueta1;
    protected JTextField campoDeTexto;
    protected JButton boton;
    protected JButton boton2;
    protected JLabel etiqueta2;

    public Conversor() {
        // Crear la ventana de la aplicacion
        JFrame ventana = new JFrame("Conversor de Euros a pesetas");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Crear los componentes
        etiqueta1 = new JLabel("Importe en Euros");
        campoDeTexto = new JTextField(20);
        boton = new JButton("Convertir");
        etiqueta2 = new JLabel("Pulse para obtener el" + "importe en pesetas");
        // Crear un contenedor
        JPanel panelDeContenido = new JPanel();
        // Configurar el contenedor para mostrar los componentes cuando
        // se muestre.
        panelDeContenido.add(etiqueta1);
        panelDeContenido.add(campoDeTexto);
        panelDeContenido.add(boton);
        panelDeContenido.add(etiqueta2);
        // Configurar la ventana para mostrar el panel cuando se muestre
        ventana.setContentPane(panelDeContenido);
        //**************************************************
        // ASOCIACIÓN DEL CÓDIGO DE MANEJO DE EVENTOS
        //**************************************************
        boton.addActionListener(new ConversorAction());
        boton2 = new JButton("Pruebva Liber");
        panelDeContenido.add(boton2);
        boton2.addActionListener(new ConversorAction());
        //**************************************************
        // HACER VISIBLE LA VENTANA
        //**************************************************
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new Conversor();
    }
}
