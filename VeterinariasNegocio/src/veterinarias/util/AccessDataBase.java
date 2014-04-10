package veterinarias.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import veterinarias.entities.Socio;

public class AccessDataBase {

    private static String DB_URL = "jdbc:postgresql://127.0.0.1:5432";
    private static String DB_USER = "postgres";
    private static String DB_PASS = "admin";

    public List<Socio> obtSociosPorNombre(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) throws SQLException {
        List<Socio> listaSocios = new ArrayList<Socio>();
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        connection.setAutoCommit(false);
        boolean soyPrimero = true;
        String sql = "SELECT * FROM socios s WHERE";
        if (primerNombre != null && !primerNombre.isEmpty()) {
            if (soyPrimero) {
                sql += " s.primer_nombre = '" + primerNombre + "'";
                soyPrimero = false;
            }
        }
        if (segundoNombre != null && !segundoNombre.isEmpty()) {
            if (soyPrimero) {
                sql += " s.segundo_nombre = '" + segundoNombre + "'";
                soyPrimero = false;
            } else {
                sql += " and s.segundo_nombre = '" + segundoNombre + "'";
            }
        }
        if (primerApellido != null && !primerApellido.isEmpty()) {
            if (soyPrimero) {
                sql += " s.primer_apellido = '" + primerApellido + "'";
                soyPrimero = false;
            } else {
                sql += " and s.primer_apellido = '" + primerApellido + "'";
            }
        }
        if (segundoApellido != null && !segundoApellido.isEmpty()) {
            if (soyPrimero) {
                sql += " s.segundo_apellido = '" + segundoApellido + "'";
                soyPrimero = false;
            } else {
                sql += " and s.segundo_apellido = '" + segundoApellido + "'";
            }
        }
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Socio socio = new Socio();
            Long nroSocio = rs.getLong("nro_socio");
            String pNombre = rs.getString("primer_nombre");
            String sNombre = rs.getString("segundo_nombre");
            String pApellido = rs.getString("primer_apellido");
            String sApellido = rs.getString("segundo_apellido");
            String telefono = rs.getString("telefono");
            String celular = rs.getString("celular");
            String direccion = rs.getString("direccion");
            String cobrador = rs.getString("cobrador");
            socio.setNroSocio(nroSocio);
            socio.setPrimerNombre(pNombre);
            socio.setSegundoNombre(sNombre);
            socio.setPrimerApellido(pApellido);
            socio.setSegundoApellido(sApellido);
            socio.setTelefono(telefono);
            socio.setCelular(celular);
            socio.setDireccion(direccion);
            socio.setCobrador(cobrador);
            listaSocios.add(socio);
        }
        connection.close();
        return listaSocios;
    }
}
