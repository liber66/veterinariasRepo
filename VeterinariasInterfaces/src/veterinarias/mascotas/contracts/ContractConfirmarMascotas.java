package veterinarias.mascotas.contracts;

import java.util.List;

import veterinarias.generics.GenericContract;
import veterinarias.objects.trans.MascotaTrans;

public class ContractConfirmarMascotas extends GenericContract {

    private static final long serialVersionUID = 1L;
    private List<MascotaTrans> listMascotasTrans;

    public List<MascotaTrans> getListMascotasTrans() {
        return listMascotasTrans;
    }

    public void setListMascotasTrans(List<MascotaTrans> listMascotasTrans) {
        this.listMascotasTrans = listMascotasTrans;
    }
}