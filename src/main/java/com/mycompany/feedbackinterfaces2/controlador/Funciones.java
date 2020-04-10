package com.mycompany.feedbackinterfaces2.controlador;

import com.mycompany.feedbackinterfaces2.modelo.Incidencia;
import com.mycompany.feedbackinterfaces2.modelo.conexion.ConexionMySql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Clase con métodos que realizan alguna operación en bbdd.
 *
 * @author Hp
 */
public class Funciones {

    ConexionMySql conexionMySql = new ConexionMySql();
    Connection con = conexionMySql.conectar();

    /**
     * Constructor vacío
     */
    public void insertarIncidencia() {

    }

    /**
     * Método que realiza una consulta a bbdd y devuelve un listado de
     * incidencias, en función de los parámetros informados .
     *
     * @param cliente
     * @param seccion
     * @param estado
     * @param fechaDesde
     * @param fechaHasta
     * @return Listado de incidencias
     * @throws SQLException
     */
    public static ResultSet consultarIncidencias(Integer cliente, Integer seccion, Integer estado,
            Date fechaDesde, Date fechaHasta
    ) throws SQLException {
        SentenciasSql sentencias = new SentenciasSql();
        //contadores para calcular el número de parámetro
        int contador = 0;
        int contCliente = 0;
        int contseccion = 0;
        int contEstado = 0;
        int contFecDesde = 0;
        int contFecHasta = 0;

        //Nos conectamos  a la BBDD
        ConexionMySql con = new ConexionMySql();
        Connection conex = con.conectar();
        PreparedStatement ps = null;

        //Construimosmla consulta según los parámetros que nos llegan
        if (cliente != null) {
            sentencias.consulta += " and  inc.idCliente=?";
            contador++;
            contCliente = contador;

        }
        if (seccion != null) {
            sentencias.consulta += " and inc.idSeccion=?";
            contador++;
            contseccion = contador;
        }
        if (estado != null) {
            sentencias.consulta += " and inc.idEstado=?";
            contador++;
            contEstado = contador;

        }
        if (fechaDesde != null) {
            sentencias.consulta += " and fecha >=?";
            contador++;
            contFecDesde = contador;
        }

        if (fechaHasta != null) {
            sentencias.consulta += " and fecha<= ?";
            contador++;
            contFecHasta = contador;

        }
        sentencias.consulta += " order by cliente,inc.idIncidencia";
        ps = conex.prepareStatement(sentencias.consulta);

        //Asignamos el número de parámetro
        if (cliente != null) {
            ps.setInt(contCliente, cliente);
        }
        if (seccion != null) {
            ps.setInt(contseccion, seccion);
        }
        if (estado != null) {
            ps.setInt(contEstado, estado);
        }
        if (fechaDesde != null) {
            ps.setDate(contFecDesde, fechaDesde);
        }
        if (fechaHasta != null) {
            ps.setDate(contFecHasta, fechaHasta);
        }

        ResultSet rsDatos = ps.executeQuery();
        rsDatos.close();
        conex.close();

        return rsDatos;

    }

    /**
     * Método que consulta un cliente a la bbdd pasándole como parámetro el
     * nombre
     *
     * @param nombreCompleto
     * @return Devuelve el id del cliente
     * @throws SQLException
     */
    public static Integer devolverIdCliente(String nombreCompleto) throws SQLException {
        ConexionMySql con = new ConexionMySql();
        Connection conex = con.conectar();

        if (nombreCompleto.contains("*")) {
            return null;
        } else {
            String nombre = nombreCompleto.substring(0, nombreCompleto.indexOf(" "));
            String apellido = nombreCompleto.substring(nombreCompleto.indexOf(" ") + 1);

            PreparedStatement ps = conex.prepareStatement(SentenciasSql.CONSULTACLIENTEPORNOMBRE);
            ps.setString(1, nombre);
            ps.setString(2, apellido.trim());

            ResultSet rsDatos = ps.executeQuery();
            Integer idCliente = 0;

            if (rsDatos.next()) {

                idCliente = rsDatos.getInt(1);

            }

            rsDatos.close();
            conex.close();
            return idCliente;
        }

    }

    /**
     * Método que consulta un estado a la bbdd pasándole como parámetro el
     * nombre
     *
     * @param estado
     * @return Devuelve el identificador del estado
     */
    public static Integer devolverIdEstado(String estado) throws SQLException {

        if (estado.contains("*")) {
            return null;
        } else {
            ConexionMySql con = new ConexionMySql();
            Connection conex = con.conectar();
            String codigoEstado = estado.substring(0, estado.indexOf(" "));

            PreparedStatement ps = conex.prepareStatement(SentenciasSql.CONSULTAESTADO);
            ps.setString(1, codigoEstado);
            Integer idEstado = 0;
            ResultSet rsDatos = ps.executeQuery();

            if (rsDatos.next()) {
                idEstado = rsDatos.getInt(1);
            }

            rsDatos.close();
            conex.close();
            return idEstado;
        }

    }

    /**
     * Método que consulta una sección a la bbdd pasándole como parámetro el
     * nombre
     *
     * @param seccion
     * @return Devuelve del identificador de la sección
     * @throws SQLException
     */
    public static Integer devolverIdSeccion(String seccion) throws SQLException {
        if (seccion.contains("*")) {
            return null;
        } else {

            ConexionMySql con = new ConexionMySql();
            Connection conex = con.conectar();

            PreparedStatement ps = conex.prepareStatement(SentenciasSql.CONSULTASECCION);
            ps.setString(1, seccion);

            ResultSet rsDatos = ps.executeQuery();
            int idSeccion = 0;
            if (rsDatos.next()) {
                idSeccion = rsDatos.getInt(1);
            }

            rsDatos.close();
            conex.close();
            return idSeccion;
        }

    }

    /**
     * Método que formatea una fecha. Se le pasa una fecha java.util.Date, y
     * devuelve java.sql.Date.
     *
     * @param uDate
     * @return Devuelve una fecha en formato java.sql.Date
     */
    public static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    /**
     * Método que inserta una incidencia en bbdd.
     *
     * @param inc
     * @return devuelve true si se ha insertdo correctamente,y false si se ha
     * producido algún error.
     */
    public static boolean insertar(Incidencia inc) {

        try {
            ConexionMySql con = new ConexionMySql();
            Connection conex = con.conectar();

            PreparedStatement ps = conex.prepareStatement(SentenciasSql.INSERTAR);
            ps.setString(1, inc.getDescripcion());
            ps.setDate(2, inc.getFecha());
            ps.setInt(3, inc.getIdCliente());
            ps.setInt(4, inc.getIdSeccion());
            ps.setInt(5, inc.getIdEstado());
            ps.setFloat(6, inc.getImporte());

            //Ejecutamos la sentencia
            int filas;
            filas = ps.executeUpdate();
            System.out.println("Se ha insertado la incidencia " + inc);
            ps.close();
            conex.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Se ha producido un error al insertar la incidencia "
                    + inc);
            return false;
        }

    }

    /**
     * Elimina de bbdd la incidencia con el id pasado por parámetro
     *
     * @param id
     * @return evuelve true si se ha insertdo correctamente,y false si se ha
     * producido algún error.
     */
    public static boolean eliminarIncidencia(Integer id) {
        try {
            ConexionMySql con = new ConexionMySql();
            Connection conex = con.conectar();

            PreparedStatement ps = conex.prepareStatement(SentenciasSql.BORRAR);
            ps.setInt(1, id);

            //Ejecutamos la sentencia
            int filas;
            filas = ps.executeUpdate();
            System.out.println("Se ha eliminado la incidencia " + id);
            ps.close();
            conex.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la incidencia "
                    + ex.getMessage() + " " + ex.getSQLState());
            return false;
        }

    }

    /**
     * Modifica la incidencia cuyo id es el pasado por parámetro
     *
     * @param id
     * @return evuelve true si se ha insertdo correctamente,y false si se ha
     * producido algún error.
     */
    public static boolean modificarIncidencia(Incidencia inc) {
        try {
            ConexionMySql con = new ConexionMySql();
            Connection conex = con.conectar();

            PreparedStatement ps = conex.prepareStatement(SentenciasSql.MODIFICAR);
            ps.setString(1, inc.getDescripcion());
            ps.setDate(2, inc.getFecha());
            ps.setInt(3, inc.getIdSeccion());
            ps.setInt(4, inc.getIdEstado());
            ps.setFloat(5, inc.getImporte());
            ps.setInt(6, inc.getIdIncidencia());

            //Ejecutamos la sentencia
            int filas;
            filas = ps.executeUpdate();
            System.out.println("Se ha modificado la incidencia " + inc);
            ps.close();
            conex.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la incidencia "
                    + ex.getMessage() + " " + ex.getSQLState());
            return false;
        }

    }

    /**
     * Método que convierte un String en formato java.sql.Date.
     *
     * @param fecha
     * @return Devuelve una fecha en formato java.sql.Date.
     * @throws ParseException
     */
    public static java.sql.Date convertirStringAFecha(String fecha) throws ParseException {
        java.sql.Date fecFormatoDate = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            fecFormatoDate = new java.sql.Date(sdf.parse(fecha).getTime());
            System.out.println("Fecha con el formato java.sql.Date: " + fecFormatoDate);
        } catch (Exception ex) {
            System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
        }

        return fecFormatoDate;
    }

    /**
     * Permite convertir un String en fecha (Date).
     *
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    /*  public static java.util.Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = (Date) formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
     */
    /**
     * Método que busca una incidencia cuyo id es el pasado por parámetro.
     *
     * @param id
     * @return Devuelve un objeto Incidencia.
     */
    public static Incidencia buscaIncidenciaPorId(int id) {
        Incidencia inc = null;
        String desc = null;
        Date fecha = null;
        Integer cliente = null;
        Integer seccion = null;
        Integer estado = null;
        Float importe = null;
        try {
            ConexionMySql con = new ConexionMySql();
            Connection conex = con.conectar();

            PreparedStatement ps = conex.prepareStatement(SentenciasSql.BUSCAINCIDENCIAPORID);
            ps.setInt(1, id);

            //Ejecutamos la sentencia
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                desc = rs.getString(2);
                fecha = rs.getDate(3);
                cliente = rs.getInt(4);
                seccion = rs.getInt(5);
                estado = rs.getInt(6);
                importe = rs.getFloat(7);
            }
            inc = new Incidencia(id, desc, fecha, cliente, seccion, estado, importe);
            ps.close();
            conex.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar incidencia por id " + ex.getMessage());
        }
        return inc;
    }

}
