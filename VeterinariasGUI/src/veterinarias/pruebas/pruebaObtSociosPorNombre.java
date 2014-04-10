package veterinarias.pruebas;

import veterinarias.consultas.contracts.ContractObtSociosPorNombre;
import veterinarias.consultas.results.ResultObtSociosPorNombre;
import veterinarias.consultas.solvers.SolverObtSociosPorNombre;

public class pruebaObtSociosPorNombre {

    public static void main(String[] args) {
        ContractObtSociosPorNombre contractObtSociosPorNombre = new ContractObtSociosPorNombre();
        contractObtSociosPorNombre.setPrimerNombre("Liber");
        contractObtSociosPorNombre.setPrimerApellido("Azambuya");
        contractObtSociosPorNombre.setSegundoNombre("Marcos");
        contractObtSociosPorNombre.setSegundoApellido("Alvarez");
        SolverObtSociosPorNombre solverObtSociosPorNombre = new SolverObtSociosPorNombre();
        solverObtSociosPorNombre.loadContract(contractObtSociosPorNombre);
        solverObtSociosPorNombre.validate();
        ResultObtSociosPorNombre resultObtSociosPorNombre = solverObtSociosPorNombre.getResponseFromSolver();
        System.out.println(resultObtSociosPorNombre.getSociosTrans().get(0).getNroSocio());
    }
}
