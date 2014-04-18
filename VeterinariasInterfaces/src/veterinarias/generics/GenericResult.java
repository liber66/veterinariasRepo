package veterinarias.generics;

import java.io.Serializable;
import java.util.List;

import veterinarias.errors.ErrorNegocio;

public class GenericResult implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ErrorNegocio> erroresNegocio;

    public List<ErrorNegocio> getErroresNegocio() {
        return erroresNegocio;
    }

    public void setErroresNegocio(List<ErrorNegocio> erroresNegocio) {
        this.erroresNegocio = erroresNegocio;
    }
}
