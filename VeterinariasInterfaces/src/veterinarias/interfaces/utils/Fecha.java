package veterinarias.interfaces.utils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class Fecha extends Calendario {

    private static final long serialVersionUID = 1L;
    private static final int ONE_SECOND = 1000;
    private static final int ONE_MINUTE = 60000;
    private static final int ONE_HOUR = 0x36ee80;
    private static final long ONE_DAY = 0x5265c00L;
    private static final long ONE_WEEK = 0x240c8400L;

    public Fecha() {
        complete();
    }

    public Fecha(Fecha fecha) {
        this(fecha.getAnio(), fecha.getMes(), fecha.getDia(), fecha.getHora(), fecha.getMinuto(), fecha.getSegundo());
        complete();
    }

    public Fecha(TimeZone zone) {
        super(zone);
        complete();
    }

    public Fecha(Locale aLocale) {
        super(aLocale);
        complete();
    }

    public Fecha(TimeZone zone, Locale aLocale) {
        super(zone, aLocale);
        complete();
    }

    public Fecha(int year, int month, int date) {
        super(year, month, date);
        complete();
    }

    public Fecha(int year, int month, int date, int hour, int minute) {
        super(year, month, date, hour, minute);
        complete();
    }

    public Fecha(int year, int month, int date, int hour, int minute, int second) {
        super(year, month, date, hour, minute, second);
        complete();
    }

    public Fecha(String fecha, int formato) {
        super(fecha, formato);
        complete();
    }

    public Fecha(Date fechaSql) {
        if (fechaSql != null) {
            long tt = fechaSql.getTime();
            super.setTimeInMillis(tt);
            set(1, get(1));
            set(2, get(2));
        }
        complete();
    }

    public static Fecha getFechaActual() {
        return new Fecha(new Date(System.currentTimeMillis()));
    }

    public Date getDateSql() {
        Fecha aux = new Fecha(get(1), get(2) + 1, get(5));
        long tt = aux.getTimeInMillis();
        Date salida = new Date(tt);
        return salida;
    }

    public Date getDateSql(boolean withTime) {
        Date d = getDateSql();
        if (withTime) {
            long l = getTime().getTime();
            d.setTime(l);
        }
        return d;
    }

    public Fecha(Timestamp t) {
        if (t != null) {
            long tt = t.getTime();
            super.setTimeInMillis(tt);
            set(1, get(1));
            set(2, get(2));
        }
        complete();
    }

    public Timestamp getTimestampSql() {
        Fecha aux = new Fecha(get(1), get(2) + 1, get(5), get(11), get(12), get(13));
        long tt = aux.getTimeInMillis();
        Timestamp salida = new Timestamp(tt);
        return salida;
    }

    public int getAsInt(int formato) {
        int salida = 0;
        try {
            if (formato == AAAAMMDD) {
                salida = get(1);
                salida = salida * 100 + get(2) + 1;
                salida = salida * 100 + get(5);
            } else {
                salida = get(5);
                salida = salida * 100 + get(2) + 1;
                salida = salida * 10000 + get(1);
            }
        } catch (Exception e) {
            salida = -1;
        }
        return salida;
    }

    public boolean esMenor(Fecha otraFecha) {
        if (otraFecha == null)
            return true;
        return getAsInt(AAAAMMDD) < otraFecha.getAsInt(AAAAMMDD);
    }

    public boolean esMayor(Fecha otraFecha) {
        if (otraFecha == null)
            return false;
        return getAsInt(AAAAMMDD) > otraFecha.getAsInt(AAAAMMDD);
    }

    private static boolean enSecuencia(Fecha fechaDesde1, Fecha fechaHasta1, Fecha fechaDesde2, Fecha fechaHasta2, boolean limiteCerrado) {
        boolean sec = fechaDesde1 == null || fechaDesde1.equals(fechaHasta1) || fechaDesde1.esMenor(fechaHasta1);
        if (sec) {
            sec = fechaDesde2 == null || fechaDesde2.equals(fechaHasta2) || fechaDesde2.esMenor(fechaHasta2);
            if (sec)
                sec = fechaHasta1 != null && fechaDesde2 != null && (fechaHasta1.esMenor(fechaDesde2) || fechaHasta1.equals(fechaDesde2) && !limiteCerrado);
        }
        return sec;
    }

    public static boolean esPeriodoSolapado(Fecha fechaDesde1, Fecha fechaHasta1, Fecha fechaDesde2, Fecha fechaHasta2, boolean limiteCerrado) {
        boolean ensecuencia = enSecuencia(fechaDesde1, fechaHasta1, fechaDesde2, fechaHasta2, limiteCerrado)
                || enSecuencia(fechaDesde2, fechaHasta2, fechaDesde1, fechaHasta1, limiteCerrado);
        return !ensecuencia;
    }

    public boolean equals(Fecha f2) {
        if (f2 != null) {
            String stf1 = toString(AAAAMMDD);
            String stf2 = f2.toString(AAAAMMDD);
            return stf1.equals(stf2);
        } else {
            return false;
        }
    }

    public static Fecha darMayor(Fecha fechas[]) {
        Fecha salida = new Fecha("19000101", AAAAMMDD);
        for (int i = 0; i < fechas.length && salida != null; i++) {
            Fecha n = fechas[i];
            if (salida.esMenor(n))
                salida = n;
        }
        return salida;
    }

    public static Fecha darMayor(Fecha f1, Fecha f2) {
        Fecha lista[] = { f1, f2 };
        return darMayor(lista);
    }

    public static Fecha darMenor(Fecha fechas[]) {
        Fecha salida = null;
        for (int i = 0; i < fechas.length; i++) {
            Fecha n = fechas[i];
            if (n != null && n.esMenor(salida))
                salida = n;
        }
        return salida;
    }

    public static Fecha darMenor(Fecha f1, Fecha f2) {
        Fecha lista[] = { f1, f2 };
        return darMenor(lista);
    }

    public boolean esMenorOIgual(Fecha f) {
        return equals(f) || esMenor(f);
    }

    public boolean esMayorOIgual(Fecha f) {
        return equals(f) || esMayor(f);
    }

    public int restar(Fecha fechaMenor) {
        return (int) ((getTimeInMillis() - fechaMenor.getTimeInMillis()) / 0x5265c00L) + 1;
    }

    public boolean isUltimoDiaDelMes() {
        Fecha fechaAux = new Fecha(this);
        int mesActual = getMes();
        fechaAux.add(5, 1);
        return mesActual != fechaAux.getMes();
    }
}
