package veterinarias.socios.jframes;

import java.awt.Color;

public class AgregarMascotasAlSocio extends NuevasMascotas {

    private static final long serialVersionUID = 1L;

    public AgregarMascotasAlSocio() {
        super();
        txtNroSocio.setText("7");
        txtNroSocio.setEditable(false);
        txtNroSocio.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void limpiarCampos() {
        txtNombreMascota.setText("");
        txtFechaNacimiento.setText("");
        txtPeso.setText("");
        txtEspecie.setText("");
        txtRaza.setText("");
        rdbtmSexoGroup.clearSelection();
        ingresarFichaClinica = null;
    }
}
