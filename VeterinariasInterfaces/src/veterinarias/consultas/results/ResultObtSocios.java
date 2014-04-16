package veterinarias.consultas.results;

import java.util.List;

import veterinarias.generics.GenericResult;
import veterinarias.objects.trans.SocioTrans;

public class ResultObtSocios extends GenericResult {

    private List<SocioTrans> sociosTrans;

    public List<SocioTrans> getSociosTrans() {
        return sociosTrans;
    }

    public void setSociosTrans(List<SocioTrans> sociosTrans) {
        this.sociosTrans = sociosTrans;
    }
}
