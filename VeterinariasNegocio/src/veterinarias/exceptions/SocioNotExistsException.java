package veterinarias.exceptions;

public class SocioNotExistsException extends GenericException {

    private static final long serialVersionUID = 1L;

    public SocioNotExistsException(Integer codigo, String mensaje, Integer severidad) {
        super(codigo, mensaje, severidad);
    }
}
