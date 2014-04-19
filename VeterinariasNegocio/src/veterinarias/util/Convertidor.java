package veterinarias.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import veterinarias.entities.Socio;
import veterinarias.objects.trans.SocioTrans;

public class Convertidor {

    public List<SocioTrans> convertListSocioToSocioTrans(List<Socio> listaSocios) {
        List<SocioTrans> listaSociosTrans = null;
        if (listaSocios != null) {
            listaSociosTrans = new ArrayList<SocioTrans>();
            for (Socio socio : listaSocios) {
                SocioTrans socioTrans = this.convertSocioToSocioTrans(socio);
                listaSociosTrans.add(socioTrans);
            }
        }
        return listaSociosTrans;
    }

    public SocioTrans convertSocioToSocioTrans(Socio socio) {
        SocioTrans socioTrans = null;
        if (socio != null) {
            socioTrans = new SocioTrans();
            socioTrans.setCelular(socio.getCelular());
            socioTrans.setCobrador(socio.getCobrador());
            socioTrans.setCuotasPendientesTrans(null);
            socioTrans.setDireccion(socio.getDireccion());
            socioTrans.setMascotasTrans(null);
            socioTrans.setNroSocio(socio.getNroSocio());
            socioTrans.setPrimerApellido(socio.getPrimerApellido());
            socioTrans.setPrimerNombre(socio.getPrimerNombre());
            socioTrans.setSegundoApellido(socio.getSegundoApellido());
            socioTrans.setSegundoNombre(socio.getSegundoNombre());
            socioTrans.setTelefono(socio.getTelefono());
        }
        return socioTrans;
    }

    public Date convertCalendarToSQLDate(Calendar calendar) {
        Date date = null;
        if (calendar != null) {
            date = new Date(calendar.getTimeInMillis());
        }
        return date;
    }
}
