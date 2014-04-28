package veterinarias.interfaces.utils;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Calendario extends GregorianCalendar {

    private static final long serialVersionUID = 1L;
    public static int DMA = 0; // DD/MM/AAAA
    public static int HM = 1;
    public static int HMS = 2;
    public static int LARGO = 3;
    public static int DMAHMS = 4;
    public static int AAAAMMDD = 5;
    public static int TIMESTAMP = 6;
    public static int BASE = 7;
    public static int AAAAMMDDHHMMSS = 8;
    public static int AAMMDDHHMMSS = 9;
    public static int DDMMAAAA = 10;

    public Calendario() {
    }

    public Calendario(TimeZone zone) {
        super(zone);
    }

    public Calendario(Locale aLocale) {
        super(aLocale);
    }

    public Calendario(TimeZone zone, Locale aLocale) {
        super(zone, aLocale);
    }

    public Calendario(int year, int month, int date) {
        super(year, month - 1, date);
    }

    public Calendario(int year, int month, int date, int hour, int minute) {
        super(year, month - 1, date, hour, minute);
    }

    public Calendario(int year, int month, int date, int hour, int minute, int second) {
        super(year, month - 1, date, hour, minute, second);
    }

    public Calendario(String fecha, int formato) {
        try {
            int dia = 1;
            int mes = 1;
            int anio = 1900;
            int hora = 0;
            int minuto = 0;
            int segundo = 0;
            int milisec = 0;
            if (formato == DMA) {
                dia = Integer.parseInt(fecha.substring(0, 2));
                mes = Integer.parseInt(fecha.substring(3, 5));
                anio = Integer.parseInt(fecha.substring(6, 10));
            } else if (formato == HM) {
                hora = Integer.parseInt(fecha.substring(0, 2));
                minuto = Integer.parseInt(fecha.substring(3, 5));
            } else if (formato == HMS) {
                hora = Integer.parseInt(fecha.substring(0, 2));
                minuto = Integer.parseInt(fecha.substring(3, 5));
                segundo = Integer.parseInt(fecha.substring(6, 8));
            } else if (formato == DMAHMS) {
                dia = Integer.parseInt(fecha.substring(0, 2));
                mes = Integer.parseInt(fecha.substring(3, 5));
                anio = Integer.parseInt(fecha.substring(6, 10));
                hora = Integer.parseInt(fecha.substring(11, 13));
                minuto = Integer.parseInt(fecha.substring(14, 16));
                segundo = Integer.parseInt(fecha.substring(17, 19));
            } else if (formato == AAAAMMDD) {
                dia = Integer.parseInt(fecha.substring(6, 8));
                mes = Integer.parseInt(fecha.substring(4, 6));
                anio = Integer.parseInt(fecha.substring(0, 4));
            } else if (formato == TIMESTAMP) {
                anio = Integer.parseInt(fecha.substring(0, 4));
                mes = Integer.parseInt(fecha.substring(5, 7));
                dia = Integer.parseInt(fecha.substring(8, 10));
                hora = Integer.parseInt(fecha.substring(11, 13));
                minuto = Integer.parseInt(fecha.substring(14, 16));
                segundo = Integer.parseInt(fecha.substring(17, 19));
                if (fecha.length() > 19)
                    milisec = Integer.parseInt(fecha.substring(20, 23));
            } else if (formato == BASE) {
                anio = Integer.parseInt(fecha.substring(0, 4));
                mes = Integer.parseInt(fecha.substring(5, 7));
                dia = Integer.parseInt(fecha.substring(8, 10));
            } else if (formato == AAAAMMDDHHMMSS) {
                hora = Integer.parseInt(fecha.substring(12, 14));
                minuto = Integer.parseInt(fecha.substring(10, 12));
                segundo = Integer.parseInt(fecha.substring(8, 10));
                dia = Integer.parseInt(fecha.substring(6, 8));
                mes = Integer.parseInt(fecha.substring(4, 6));
                anio = Integer.parseInt(fecha.substring(0, 4));
            } else if (formato == AAMMDDHHMMSS) {
                hora = Integer.parseInt(fecha.substring(10, 12));
                minuto = Integer.parseInt(fecha.substring(8, 10));
                segundo = Integer.parseInt(fecha.substring(6, 8));
                dia = Integer.parseInt(fecha.substring(4, 6));
                mes = Integer.parseInt(fecha.substring(2, 4));
                anio = Integer.parseInt(fecha.substring(0, 2));
            } else if (formato == DDMMAAAA) {
                dia = Integer.parseInt(fecha.substring(0, 2));
                mes = Integer.parseInt(fecha.substring(2, 4));
                anio = Integer.parseInt(fecha.substring(4, 8));
            }
            set(5, dia);
            set(2, mes - 1);
            set(1, anio);
            set(11, hora);
            set(12, minuto);
            set(13, segundo);
            set(14, milisec);
        } catch (Exception e) {
            set(5, 1);
            set(2, 0);
            set(1, 1900);
            set(11, 0);
            set(12, 0);
            set(13, 0);
        }
    }

    public static int verificarFormato(String fecha, int formatos[]) throws InvalidCalendarioFormatException {
        for (int i = 0; i < formatos.length; i++) {
            int formato = formatos[i];
            if (formato == DDMMAAAA && verificarFormatoDDMMAAAA(fecha) || formato == DMA && verificarFormatoDMA(fecha))
                return formato;
        }
        throw new InvalidCalendarioFormatException();
    }

    public static boolean verificarFormatoDDMMAAAA(String fecha) throws InvalidCalendarioFormatException {
        if (fecha.length() < 8)
            return false;
        else
            return validarFecha(fecha.substring(0, 2), fecha.substring(2, 4), fecha.substring(4, 8));
    }

    public static boolean verificarFormatoDMA(String fecha) throws InvalidCalendarioFormatException {
        if (fecha.length() < 10)
            return false;
        else
            return validarFecha(fecha.substring(0, 2), fecha.substring(3, 5), fecha.substring(6, 10));
    }

    private String ceros(int nro) {
        return (new StringBuilder(String.valueOf(nro >= 10 ? "" : "0"))).append(nro).toString();
    }

    private String ceros3(int nro) {
        return (new StringBuilder(String.valueOf(nro >= 100 ? "" : "0"))).append(nro >= 10 ? "" : "0").append(nro).toString();
    }

    public String getAMPM() {
        return get(9) != 0 ? "PM" : "AM";
    }

    public int getAnio() {
        return get(1);
    }

    public int getDia() {
        return get(5);
    }

    public int getHora() {
        return get(11);
    }

    public int getHoraAMPM() {
        return get(10) != 0 ? get(10) : 12;
    }

    public int getMes() {
        return get(2) + 1;
    }

    public int getMilisegundo() {
        return get(14);
    }

    public int getMinuto() {
        return get(12);
    }

    public String getNombreDia() {
        String dias[] = { "No existe", "Domingo", "Lunes", "Martes", "Mi\351rcoles", "Jueves", "Viernes", "S\341bado" };
        return dias[get(7)];
    }

    public String getNombreMes() {
        String meses[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" };
        return meses[get(2)];
    }

    public int getSegundo() {
        return get(13);
    }

    public void setTimeInMillis(long time) {
        super.setTimeInMillis(time);
    }

    public String toString() {
        return (new StringBuilder(String.valueOf(getAnio()))).append("-").append(ceros(getMes())).append("-").append(ceros(getDia())).append(" ")
                .append(ceros(getHora())).append(":").append(ceros(getMinuto())).append(":").append(ceros(getSegundo())).toString();
    }

    public String toString(int formato) {
        if (formato == DMA)
            return (new StringBuilder(String.valueOf(ceros(getDia())))).append("/").append(ceros(getMes())).append("/").append(getAnio()).toString();
        if (formato == HM)
            return (new StringBuilder(String.valueOf(ceros(getHora())))).append(":").append(ceros(getMinuto())).toString();
        if (formato == HMS)
            return (new StringBuilder(String.valueOf(ceros(getHora())))).append(":").append(ceros(getMinuto())).append(":").append(ceros(getSegundo()))
                    .toString();
        if (formato == LARGO)
            return (new StringBuilder(String.valueOf(getNombreDia()))).append(" ").append(getDia()).append(" de ").append(getNombreMes()).append(" de ")
                    .append(getAnio()).append(", ").append(getHoraAMPM()).append(":").append(ceros(getMinuto())).append(" ").append(getAMPM()).toString();
        if (formato == DMAHMS)
            return (new StringBuilder(String.valueOf(ceros(getDia())))).append("/").append(ceros(getMes())).append("/").append(getAnio()).append(" ")
                    .append(ceros(getHora())).append(":").append(ceros(getMinuto())).append(":").append(ceros(getSegundo())).toString();
        if (formato == AAAAMMDD)
            return (new StringBuilder(String.valueOf(getAnio()))).append(ceros(getMes())).append(ceros(getDia())).toString();
        if (formato == TIMESTAMP)
            return (new StringBuilder(String.valueOf(getAnio()))).append("-").append(ceros(getMes())).append("-").append(ceros(getDia())).append(" ")
                    .append(ceros(getHora())).append(":").append(ceros(getMinuto())).append(":").append(ceros(getSegundo())).append(".")
                    .append(ceros3(getMilisegundo())).toString();
        if (formato == BASE)
            return (new StringBuilder(String.valueOf(getAnio()))).append("-").append(ceros(getMes())).append("-").append(ceros(getDia())).toString();
        if (formato == AAAAMMDDHHMMSS)
            return (new StringBuilder(String.valueOf(getAnio()))).append(ceros(getMes())).append(ceros(getDia())).append(ceros(getHora()))
                    .append(ceros(getMinuto())).append(ceros(getSegundo())).toString();
        if (formato == AAMMDDHHMMSS) {
            int unAnio = getAnio() % 100;
            return (new StringBuilder(String.valueOf(ceros(unAnio)))).append(ceros(getMes())).append(ceros(getDia())).append(ceros(getHora()))
                    .append(ceros(getMinuto())).append(ceros(getSegundo())).toString();
        }
        if (formato == DDMMAAAA) {
            return (new StringBuilder(String.valueOf(ceros(getDia())))).append(ceros(getMes())).append(getAnio()).toString();
        } else {
            return toString();
        }
    }

    public static boolean validarFecha(String dia, String mes, String anio) {
        Integer iDia;
        Integer iMes;
        Integer iAnio;
        iDia = new Integer(dia);
        iMes = new Integer(mes);
        iAnio = new Integer(anio);
        String fecha = null;
        label0: {
            if (iAnio.intValue() < 1000 || iAnio.intValue() > 9999)
                return false;
            try {
                Calendario cal = new Calendario(iAnio.intValue(), iMes.intValue(), iDia.intValue());
                if (cal.getAnio() == iAnio.intValue() && cal.getMes() == iMes.intValue() && cal.getDia() == iDia.intValue()) {
                    String sDia = "";
                    String sMes = "";
                    if (iDia.intValue() < 10)
                        sDia = (new StringBuilder("0")).append(iDia.toString()).toString();
                    else
                        sDia = iDia.toString();
                    if (iDia.intValue() < 10)
                        sMes = (new StringBuilder("0")).append(iMes.toString()).toString();
                    else
                        sMes = iMes.toString();
                    break label0;
                }
            } catch (NumberFormatException nfe) {
                return false;
            }
            return false;
        }
        return true;
    }
}
