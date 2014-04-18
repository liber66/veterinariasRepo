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

    public List<Socio> obtSociosPorNombre(Long nroSocio, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            String direccion, String telefono, String celular, String cobrador) throws SQLException {
        List<Socio> listaSocios = new ArrayList<Socio>();
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        String sql = "SELECT * FROM socios s WHERE";
        if (nroSocio != null) {
            sql += " s.nro_socio = " + nroSocio + " AND";
        }
        if (primerNombre != null && !primerNombre.isEmpty()) {
            sql += " s.primer_nombre = '" + primerNombre + "' AND";
        }
        if (segundoNombre != null && !segundoNombre.isEmpty()) {
            sql += " s.segundo_nombre = '" + segundoNombre + "' AND";
        }
        if (primerApellido != null && !primerApellido.isEmpty()) {
            sql += " s.primer_apellido = '" + primerApellido + "' AND";
        }
        if (segundoApellido != null && !segundoApellido.isEmpty()) {
            sql += " s.segundo_apellido = '" + segundoApellido + "' AND";
        }
        if (direccion != null && !direccion.isEmpty()) {
            sql += " s.direccion = '" + direccion + "' AND";
        }
        if (telefono != null && !telefono.isEmpty()) {
            sql += " s.telefono = '" + telefono + "' AND";
        }
        if (celular != null && !celular.isEmpty()) {
            sql += " s.celular = '" + celular + "' AND";
        }
        if (cobrador != null && !cobrador.isEmpty()) {
            sql += " s.cobrador = '" + cobrador + "' AND";
        }
        //Elimino el ultimo 'AND' que quedo de mas en la consulta
        sql = sql.substring(0, sql.length() - 3);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Socio socio = new Socio();
            socio.setNroSocio(rs.getLong("nro_socio"));
            socio.setPrimerNombre(rs.getString("primer_nombre"));
            socio.setSegundoNombre(rs.getString("segundo_nombre"));
            socio.setPrimerApellido(rs.getString("primer_apellido"));
            socio.setSegundoApellido(rs.getString("segundo_apellido"));
            socio.setTelefono(rs.getString("telefono"));
            socio.setCelular(rs.getString("celular"));
            socio.setDireccion(rs.getString("direccion"));
            socio.setCobrador(rs.getString("cobrador"));
            listaSocios.add(socio);
        }
        ps.close();
        connection.close();
        return listaSocios;
    }

    public void agregarNuevoSocio(Long nroSocio, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String direccion,
            String telefono, String celular, String cobrador) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        String sql = "INSERT INTO socios (nro_socio, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, telefono, celular, direccion, cobrador) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, nroSocio);
        ps.setString(2, primerNombre);
        ps.setString(3, segundoNombre);
        ps.setString(4, primerApellido);
        ps.setString(5, segundoApellido);
        ps.setString(6, telefono);
        ps.setString(7, celular);
        ps.setString(8, direccion);
        ps.setString(9, cobrador);
        ps.executeUpdate();
        ps.close();
        connection.close();
    }
}
