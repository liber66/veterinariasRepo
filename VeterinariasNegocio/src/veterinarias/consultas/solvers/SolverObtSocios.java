package veterinarias.consultas.solvers;

import java.sql.SQLException;
import java.util.List;

import veterinarias.consultas.contracts.ContractObtSocios;
import veterinarias.consultas.results.ResultObtSocios;
import veterinarias.entities.Socio;
import veterinarias.generics.GenericContract;
import veterinarias.generics.GenericSolver;
import veterinarias.objects.trans.SocioTrans;
import veterinarias.util.AccessDataBase;
import veterinarias.util.Convertidor;

public class SolverObtSocios extends GenericSolver {

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
    //Datos result
    private List<Socio> listaSocios;

    public void loadContract(GenericContract genericContract) {
        ContractObtSocios contractObtSocios = (ContractObtSocios) genericContract;
        nroSocio = contractObtSocios.getNroSocio();
        primerNombre = contractObtSocios.getPrimerNombre();
        segundoNombre = contractObtSocios.getSegundoNombre();
        primerApellido = contractObtSocios.getPrimerApellido();
        segundoApellido = contractObtSocios.getSegundoApellido();
        direccion = contractObtSocios.getDireccion();
        telefono = contractObtSocios.getTelefono();
        celular = contractObtSocios.getCelular();
        cobrador = contractObtSocios.getCobrador();
    }

    public void validate() {
        try {
            AccessDataBase accessDataBase = new AccessDataBase();
            listaSocios = accessDataBase.obtSociosPorNombre(nroSocio, primerNombre, segundoNombre, primerApellido, segundoApellido, direccion, telefono,
                    celular, cobrador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultObtSocios getResponseFromSolver() {
        ResultObtSocios resultObtSocios = new ResultObtSocios();
        Convertidor convertidor = new Convertidor();
        List<SocioTrans> listaSociosTrans = convertidor.convertListSocioToSocioTrans(listaSocios);
        resultObtSocios.setSociosTrans(listaSociosTrans);
        return resultObtSocios;
    }
}