package veterinarias.mascotas.solvers;

import java.sql.SQLException;
import java.util.Calendar;

import veterinarias.generics.GenericContract;
import veterinarias.generics.GenericSolver;
import veterinarias.mascotas.contracts.ContractNuevaMascota;
import veterinarias.util.AccessDataBase;

public class SolverNuevaMascota extends GenericSolver {

    //Datos contrato
    private Long nroSocio;
    private String nombreMascota;
    private Calendar fechaNacimiento;
    private Long peso;
    private String informacion;
    private String especie;
    private String raza;
    private String sexo;
    private static String MUERTA = "N";

    @Override
    public void loadContract(GenericContract genericContract) {
        ContractNuevaMascota contractNuevaMascota = (ContractNuevaMascota) genericContract;
        nroSocio = contractNuevaMascota.getNroSocio();
        nombreMascota = contractNuevaMascota.getNombreMascota();
        fechaNacimiento = contractNuevaMascota.getFechaNacimiento();
        peso = contractNuevaMascota.getPeso();
        informacion = contractNuevaMascota.getInformacion();
        especie = contractNuevaMascota.getEspecie();
        raza = contractNuevaMascota.getRaza();
        sexo = contractNuevaMascota.getSexo();
    }

    @Override
    public void commitSolver() {
        try {
            AccessDataBase accessDataBase = new AccessDataBase();
            accessDataBase.agregarNuevaMascota(nroSocio, nombreMascota, fechaNacimiento, peso, informacion, especie, raza, sexo, MUERTA);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
