/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.feedbackinterfaces2.controlador;

import com.mycompany.feedbackinterfaces2.modelo.conexion.ConexionMySql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hp
 */
public class Funciones {

    ConexionMySql conexionMySql = new ConexionMySql();
    Connection con = conexionMySql.conectar();

    public void insertarIncidencia() {

    }

    public static ResultSet consultarIncidencias(Integer cliente, Integer seccion, Integer estado,
            Date fechaDesde, Date fechaHasta
    ) throws SQLException {
        SentenciasSql sentencias = new SentenciasSql();
        //contadores para calcularvel número de parámetro
        int contador = 0;
        int contCliente = 0;
        int contseccion = 0;
        int contEstado = 0;
       
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
        if (fechaDesde != null && fechaHasta != null) {
            sentencias.consulta += " and fecha between ? and ?";
        } else if (fechaDesde != null && fechaDesde == null) {
            sentencias.consulta += " and fecha>= ?";

        } else if (fechaDesde == null && fechaDesde != null) {

            sentencias.consulta += " and fecha<= ?";
        }
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
            ps.setDate(4, fechaDesde);
        }
        if (fechaHasta != null) {
            ps.setDate(5, fechaHasta);
        }

        ResultSet rsDatos = ps.executeQuery();

        return rsDatos;

    }

    /**
     *
     * @param nombreCompleto
     * @return
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
            return idCliente;
        }

    }

    /**
     *
     * @param estado
     * @return
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
            return idEstado;
        }

    }

    /**
     *
     * @param seccion
     * @return
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
            return idSeccion;
        }

    }

    /**
     *
     * @param uDate
     * @return
     */
    public static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
