package veterinarias.mascotas.solvers;

import java.util.List;

import veterinarias.errors.ErrorNegocio;
import veterinarias.generics.GenericContract;
import veterinarias.generics.GenericSolver;
import veterinarias.mascotas.contracts.ContractValidarNuevaMascota;
import veterinarias.mascotas.validations.MascotaValidador;

public class SolverValidarNuevaMascota extends GenericSolver {

    private Long nroSocio;
    private String nombreMascota;
    private static String MUERTA = "N";

    @Override
    protected void loadContract(GenericContract contract) {
        ContractValidarNuevaMascota contractValidarNuevaMascota = (ContractValidarNuevaMascota) contract;
        nroSocio = contractValidarNuevaMascota.getNroSocio();
        nombreMascota = contractValidarNuevaMascota.getNombreMascota();
    }

    @Override
    protected List<ErrorNegocio> validateSolver() {
        List<ErrorNegocio> erroresNegocio = MascotaValidador.validarNuevaMascota(nroSocio, nombreMascota, MUERTA);
        return erroresNegocio;
    }
}
