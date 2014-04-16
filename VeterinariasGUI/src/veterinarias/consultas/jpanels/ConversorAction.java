package veterinarias.consultas.jpanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorAction extends Conversor implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        //**************************************************
        // CÓDIGO DE MANEJO DE EVENTOS
        //**************************************************
        try {
            String actionCommand = e.getActionCommand();
            double euros = Double.parseDouble(campoDeTexto.getText());
            double pesetas = euros * 166.386;
            etiqueta2.setText("Equivale a " + pesetas + " pesetas");
        } catch (NumberFormatException e2) {
            etiqueta2.setText("En el campo de texto no hay un número");
        }
    }
}
