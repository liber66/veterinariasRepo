package veterinarias.exceptions;

public class MascotaExistsException extends GenericException {

    private static final long serialVersionUID = 1L;

    public MascotaExistsException(Integer codigo, String mensaje, Integer severidad) {
        super(codigo, mensaje, severidad);
    }
}
