package veterinarias.generics;

import java.util.ArrayList;
import java.util.List;

import veterinarias.errors.ErrorNegocio;

public class GenericSolver {

    protected List<ErrorNegocio> erroresNegocio;

    public GenericResult solve(GenericContract contract) {
        this.loadContract(contract);
        erroresNegocio = this.validateSolver();
        if (erroresNegocio.isEmpty()) {
            commitSolver();
        }
        return getResultFromSolver();
    }

    /**
     * Este metodo es el encargado de desglozar el contrato en atributos.
     * 
     * @param contract
     *            Contrato enviado desde presentacion.
     */
    protected void loadContract(GenericContract contract) {
    }

    /**
     * Metodo que hace todas las validaciones de negocio.
     */
    protected List<ErrorNegocio> validateSolver() {
        return new ArrayList<ErrorNegocio>();
    }

    /**
     * Metodo que debe registrar los objetos en la UOW que se necesitan
     * persistir. Para las consultas no se necesita reimplementar, pero para las
     * confirmaciones si.
     */
    protected void commitSolver() {
    }

    /**
     * Este metodo es el encargado de fabricar el resultado que ncesita
     * presentacion.
     * 
     * @return ResultBean que se devuelve a presentacion.
     */
    protected GenericResult getResultFromSolver() {
        GenericResult genericResult = new GenericResult();
        genericResult.setErroresNegocio(erroresNegocio);
        return genericResult;
    }
}
