package veterinarias.socios.solvers;

import java.sql.SQLException;

import veterinarias.generics.GenericContract;
import veterinarias.generics.GenericSolver;
import veterinarias.objects.trans.SocioTrans;
import veterinarias.socios.contracts.ContractNuevoSocio;
import veterinarias.socios.results.ResultNuevoSocio;
import veterinarias.util.AccessDataBase;

public class SolverNuevoSocio extends GenericSolver {

    //Datos contrato
    private Long nroSocio;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String telefono;
    private String celular;
    private String cobrador;

    public void loadContract(GenericContract genericContract) {
        ContractNuevoSocio contractNuevoSocio = (ContractNuevoSocio) genericContract;
        nroSocio = contractNuevoSocio.getNroSocio();
        primerNombre = contractNuevoSocio.getPrimerNombre();
        segundoNombre = contractNuevoSocio.getSegundoNombre();
        primerApellido = contractNuevoSocio.getPrimerApellido();
        segundoApellido = contractNuevoSocio.getSegundoApellido();
        direccion = contractNuevoSocio.getDireccion();
        telefono = contractNuevoSocio.getTelefono();
        celular = contractNuevoSocio.getCelular();
        cobrador = contractNuevoSocio.getCobrador();
    }

    public void validate() {
    }

    public void registarObjetosSolver() {
        try {
            AccessDataBase accessDataBase = new AccessDataBase();
            accessDataBase.agregarNuevoSocio(nroSocio, primerNombre, segundoNombre, primerApellido, segundoApellido, direccion, telefono, celular, cobrador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultNuevoSocio getResponseFromSolver() {
        ResultNuevoSocio resultNuevoSocio = new ResultNuevoSocio();
        SocioTrans socioTrans = new SocioTrans();
        socioTrans.setCelular(celular);
        socioTrans.setCobrador(cobrador);
        socioTrans.setDireccion(direccion);
        socioTrans.setNroSocio(nroSocio);
        socioTrans.setPrimerApellido(primerApellido);
        socioTrans.setPrimerNombre(primerNombre);
        socioTrans.setSegundoApellido(segundoApellido);
        socioTrans.setSegundoNombre(segundoNombre);
        socioTrans.setTelefono(telefono);
        resultNuevoSocio.setSocioTrans(socioTrans);
        return resultNuevoSocio;
    }
}
