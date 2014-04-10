package veterinarias.consultas.solvers;

import java.sql.SQLException;
import java.util.List;

import veterinarias.consultas.contracts.ContractObtSociosPorNombre;
import veterinarias.consultas.results.ResultObtSociosPorNombre;
import veterinarias.entities.Socio;
import veterinarias.generics.GenericContract;
import veterinarias.generics.GenericSolver;
import veterinarias.objects.trans.SocioTrans;
import veterinarias.util.AccessDataBase;
import veterinarias.util.Convertidor;

public class SolverObtSociosPorNombre extends GenericSolver {

    //Datos contrato
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    //Datos result
    private List<Socio> listaSocios;

    public void loadContract(GenericContract genericContract) {
        ContractObtSociosPorNombre contractObtSociosPorNombre = (ContractObtSociosPorNombre) genericContract;
        primerNombre = contractObtSociosPorNombre.getPrimerNombre();
        segundoNombre = contractObtSociosPorNombre.getSegundoNombre();
        primerApellido = contractObtSociosPorNombre.getPrimerApellido();
        segundoApellido = contractObtSociosPorNombre.getSegundoApellido();
    }

    public void validate() {
        try {
            AccessDataBase accessDataBase = new AccessDataBase();
            listaSocios = accessDataBase.obtSociosPorNombre(primerNombre, segundoNombre, primerApellido, segundoApellido);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultObtSociosPorNombre getResponseFromSolver() {
        ResultObtSociosPorNombre resultObtSociosPorNombre = new ResultObtSociosPorNombre();
        Convertidor convertidor = new Convertidor();
        List<SocioTrans> listaSociosTrans = convertidor.convertListSocioToSocioTrans(listaSocios);
        resultObtSociosPorNombre.setSociosTrans(listaSociosTrans);
        return resultObtSociosPorNombre;
    }
}