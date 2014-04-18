package veterinarias.socios.results;

import veterinarias.generics.GenericResult;
import veterinarias.objects.trans.SocioTrans;

public class ResultNuevoSocio extends GenericResult {

    private static final long serialVersionUID = 1L;
    private SocioTrans socioTrans;

    public SocioTrans getSocioTrans() {
        return socioTrans;
    }

    public void setSocioTrans(SocioTrans socioTrans) {
        this.socioTrans = socioTrans;
    }
}
