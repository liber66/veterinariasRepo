package veterinarias.objects.trans;

import java.util.Date;

public class CuotaPendienteTrans {

    private SocioTrans socioTrans;
    private Date fechaCuota;
    private String descripcion;
    private Date fechaPago;

    public SocioTrans getSocioTrans() {
        return socioTrans;
    }

    public void setSocioTrans(SocioTrans socioTrans) {
        this.socioTrans = socioTrans;
    }

    public Date getFechaCuota() {
        return fechaCuota;
    }

    public void setFechaCuota(Date fechaCuota) {
        this.fechaCuota = fechaCuota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
