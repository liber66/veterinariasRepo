package veterinarias.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import veterinarias.entities.FichaClinica;
import veterinarias.entities.Mascota;
import veterinarias.entities.Socio;
import veterinarias.interfaces.utils.Calendario;
import veterinarias.interfaces.utils.Fecha;
import veterinarias.objects.trans.FichaClinicaTrans;
import veterinarias.objects.trans.MascotaTrans;
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

    public List<FichaClinica> convertListFichaClinicaTransToListFichaClinica(List<FichaClinicaTrans> listFichaClinicaTrans) {
        List<FichaClinica> listFichaClinica = null;
        if (listFichaClinicaTrans != null) {
            listFichaClinica = new ArrayList<FichaClinica>();
            for (FichaClinicaTrans fichaClinicaTrans : listFichaClinicaTrans) {
                FichaClinica fichaClinica = this.convertFichaClinicaTransToFichaClinica(fichaClinicaTrans);
                listFichaClinica.add(fichaClinica);
            }
        }
        return listFichaClinica;
    }

    public FichaClinica convertFichaClinicaTransToFichaClinica(FichaClinicaTrans fichaClinicaTrans) {
        FichaClinica fichaClinica = null;
        if (fichaClinicaTrans != null) {
            fichaClinica = new FichaClinica();
            fichaClinica.setFecha(fichaClinicaTrans.getFecha().getTime());
            fichaClinica.setInformacion(fichaClinicaTrans.getInformacion());
        }
        return fichaClinica;
    }

    private Mascota obtenerMascotaFromMascotaTrans(MascotaTrans mascotaTrans) {
        Mascota mascota = null;
        if (mascotaTrans != null) {
            mascota = new Mascota();
            Date fechaNacimiento = this.convertCalendarToSQLDate(mascotaTrans.getFechaNacimiento());
            mascota.setFechaNacimiento(fechaNacimiento);
            mascota.setInformacion(mascotaTrans.getInformacion());
            mascota.setMuerta(mascotaTrans.getMuerta());
            mascota.setNombre(mascotaTrans.getNombre());
            mascota.setPeso(mascotaTrans.getPeso());
        }
        return mascota;
    }

    private Socio obtenerSocioFromSocioTrans(SocioTrans socioTrans) {
        Socio socio = null;
        if (socioTrans != null) {
            socio = new Socio();
            socio.setCelular(socioTrans.getCelular());
            socio.setCobrador(socioTrans.getCobrador());
            socio.setDireccion(socioTrans.getDireccion());
            socio.setNroSocio(socioTrans.getNroSocio());
            socio.setPrimerApellido(socioTrans.getPrimerApellido());
            socio.setPrimerNombre(socioTrans.getPrimerNombre());
            socio.setSegundoApellido(socioTrans.getSegundoApellido());
            socio.setSegundoNombre(socioTrans.getSegundoNombre());
            socio.setTelefono(socioTrans.getTelefono());
        }
        return socio;
    }

    public java.sql.Date convertCalendarToSQLDate(Calendar calendar) {
        java.sql.Date date = null;
        if (calendar != null) {
            date = new java.sql.Date(calendar.getTimeInMillis());
        }
        return date;
    }

    //PRE: el formato de la fecha debe ser DD/MM/AAAA.
    public Fecha convertStringToFecha(String fecha) {
        Fecha fechaResult = null;
        if (fecha != null && !fecha.isEmpty()) {
            fechaResult = new Fecha(fecha, Calendario.DMA);
        }
        return fechaResult;
    }

    //POST: Devuelve la fecha con el formato DD/MM/AAAA.
    public String convertFechaToString(Fecha fecha) {
        String fechaResult = null;
        if (fecha != null) {
            fechaResult = fecha.toString(Calendario.DMA);
        }
        return fechaResult;
    }

    public Date convertFechaToDate(Fecha fecha) {
        Date date = null;
        if (fecha != null) {
            date = fecha.getTime();
        }
        return date;
    }

    public Fecha convertDateToFecha(Date date) {
        Fecha fecha = null;
        if (date != null) {
            fecha = new Fecha(date);
        }
        return fecha;
    }
}
