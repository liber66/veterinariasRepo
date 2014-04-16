package veterinarias.pruebas;

import veterinarias.consultas.contracts.ContractObtSocios;
import veterinarias.consultas.results.ResultObtSocios;
import veterinarias.consultas.solvers.SolverObtSocios;

public class pruebaObtSociosPorNombre {

    public static void main(String[] args) {
        ContractObtSocios contractObtSociosPorNombre = new ContractObtSocios();
        contractObtSociosPorNombre.setPrimerNombre("Liber");
        contractObtSociosPorNombre.setPrimerApellido("Azambuya");
        contractObtSociosPorNombre.setSegundoNombre("Marcos");
        contractObtSociosPorNombre.setSegundoApellido("Alvarez");
        SolverObtSocios solverObtSociosPorNombre = new SolverObtSocios();
        solverObtSociosPorNombre.loadContract(contractObtSociosPorNombre);
        solverObtSociosPorNombre.validate();
        ResultObtSocios resultObtSociosPorNombre = solverObtSociosPorNombre.getResponseFromSolver();
        System.out.println(resultObtSociosPorNombre.getSociosTrans().get(0).getNroSocio());
    }
}
