package veterinarias.gui.generics;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class GenericMaskFormatter extends MaskFormatter {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    //Formato DD/MM/AAAA
    public static MaskFormatter getDateMask() {
        MaskFormatter dateMask = null;
        try {
            dateMask = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
        }
        return dateMask;
    }
}
