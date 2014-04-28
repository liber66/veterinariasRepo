package veterinarias.mascotas.validations;

import java.sql.SQLException;

import veterinarias.entities.Mascota;
import veterinarias.exceptions.MascotaExistsException;
import veterinarias.util.AccessDataBase;

public class ValidarNoExisteMascota {

    private static Integer CODIGO = 1;
    private static String MENSAJE = "Ya Existe Mascota con Nombre: ";
    private static Integer SEVERIDAD = 1;

    public static void validar(Long nroSocio, String nombreMascota, String muerta) throws MascotaExistsException {
        try {
            AccessDataBase accessDataBase = new AccessDataBase();
            Mascota mascota = accessDataBase.obtenerMascota(nroSocio, nombreMascota, muerta);
            if (mascota != null) {
                MENSAJE += nombreMascota;
                throw new MascotaExistsException(CODIGO, MENSAJE, SEVERIDAD);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
