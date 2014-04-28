package veterinarias.gui.utils;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class Util {

    //Obtener JRadioButton seleccionado de un ButtonGroup
    public static JRadioButton getSelection(ButtonGroup buttonGroup) {
        JRadioButton result = null;
        Enumeration<AbstractButton> enumeration = buttonGroup.getElements();
        while (enumeration.hasMoreElements() && result == null) {
            JRadioButton radioButton = (JRadioButton) enumeration.nextElement();
            if (radioButton.getModel() == buttonGroup.getSelection()) {
                result = radioButton;
            }
        }
        return result;
    }
}
