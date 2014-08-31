package veterinarias.mascotas.solvers;

import java.sql.SQLException;
import java.util.List;

import veterinarias.generics.GenericContract;
import veterinarias.generics.GenericSolver;
import veterinarias.mascotas.contracts.ContractConfirmarMascotas;
import veterinarias.objects.trans.MascotaTrans;
import veterinarias.util.AccessDataBase;

public class SolverConfirmarMascotas extends GenericSolver {

    private List<MascotaTrans> listMascotaTrans;

    @Override
    protected void loadContract(GenericContract contract) {
        ContractConfirmarMascotas contractConfirmarMascotas = (ContractConfirmarMascotas) contract;
        listMascotaTrans = contractConfirmarMascotas.getListMascotasTrans();
    }

    @Override
    protected void commitSolver() {
        try {
            AccessDataBase accessDataBase = new AccessDataBase();
            accessDataBase.insertarNuevasMascotas(listMascotaTrans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
