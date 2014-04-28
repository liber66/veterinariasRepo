package veterinarias.socios.validations;

import java.sql.SQLException;

import veterinarias.entities.Socio;
import veterinarias.exceptions.SocioNotExistsException;
import veterinarias.util.AccessDataBase;

public class ValidarExisteSocio {

    private static Integer CODIGO = 1;
    private static String MENSAJE = "No Existe Socio con Nro. Socio: ";
    private static Integer SEVERIDAD = 1;

    public static Socio validar(Long nroSocio) throws SocioNotExistsException {
        Socio socio = null;
        try {
            AccessDataBase accessDataBase = new AccessDataBase();
            socio = accessDataBase.obtSocioPorNumero(nroSocio);
            if (socio == null) {
                MENSAJE += nroSocio;
                throw new SocioNotExistsException(CODIGO, MENSAJE, SEVERIDAD);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return socio;
    }
}
