package veterinarias.mascotas.validations;

import java.util.ArrayList;
import java.util.List;

import veterinarias.errors.ErrorNegocio;
import veterinarias.exceptions.MascotaExistsException;
import veterinarias.exceptions.SocioNotExistsException;
import veterinarias.socios.validations.ValidarExisteSocio;

public class MascotaValidador {

    public static List<ErrorNegocio> validarNuevaMascota(Long nroSocio, String nombreMascota, String muerta) {
        List<ErrorNegocio> erroresNegocio = new ArrayList<ErrorNegocio>();
        try {
            ValidarExisteSocio.validar(nroSocio);
            ValidarNoExisteMascota.validar(nroSocio, nombreMascota, muerta);
        } catch (SocioNotExistsException e) {
            ErrorNegocio errorNegocio = new ErrorNegocio();
            errorNegocio.setCodigo(e.getCodigo());
            errorNegocio.setDescripcion(e.getMensaje());
            errorNegocio.setSeveridad(e.getSeveridad());
            erroresNegocio.add(errorNegocio);
        } catch (MascotaExistsException e) {
            ErrorNegocio errorNegocio = new ErrorNegocio();
            errorNegocio.setCodigo(e.getCodigo());
            errorNegocio.setDescripcion(e.getMensaje());
            errorNegocio.setSeveridad(e.getSeveridad());
            erroresNegocio.add(errorNegocio);
        }
        return erroresNegocio;
    }
}
