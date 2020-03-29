package com.mycompany.feedbackinterfaces2.modelo.conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que realiza una conexión a la BBDD
 *
 * @author Hp
 */
public class ConexionMySql {

    private final String usuario;
    private final String password;
    private final String path;

    public ConexionMySql() {

        usuario = "root";
        password = "";
        path = "jdbc:mysql://localhost:3308/fdb_bbddinterfaces";
    }

    /**
     * Método que conecta a la BBDD
     *
     * @return
     */
    public Connection conectar() {

        Connection conexion = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(path, usuario, password);
            System.out.println("Conexión correcta");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se ha podido realizar la conexión");
        }

        return conexion;

    }

}
