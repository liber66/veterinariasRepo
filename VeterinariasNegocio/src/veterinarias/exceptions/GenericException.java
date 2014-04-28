package veterinarias.exceptions;

public class GenericException extends Exception {

    private static final long serialVersionUID = 1L;
    private Integer codigo;
    private String mensaje;
    private Integer severidad;

    public GenericException(Integer codigo, String mensaje, Integer severidad) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.severidad = severidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getSeveridad() {
        return severidad;
    }

    public void setSeveridad(Integer severidad) {
        this.severidad = severidad;
    }
}
