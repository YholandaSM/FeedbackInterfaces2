package com.mycompany.feedbackinterfaces2.controlador;

/**
 *
 * @author Hp
 */
public class SentenciasSql {

public  String consulta = "SELECT concat(cli.nombre,' ',cli.apellidos)as cliente, idIncidencia,inc.descripcion,sec.nombre as seccion,fecha,importe,est.codigo as estado\n"
            + "from incidencias inc,secciones sec,estado est,clientes cli\n"
            + "where inc.idEstado=est.idEstado\n"
            + "and inc.idSeccion=sec.idSeccion\n"
            + "and inc.idCliente=cli.idcliente\n" ;     
          //  + " and  inc.idCliente=?"
          //  + " and inc.idSeccion=?"
          //  + " and inc.idEstado=?"
         //   + " and fecha between ? and ?"
          //  + "order by inc.idIncidencia";
            

    public static String CONSULTACLIENTEPORNOMBRE = "select idCliente from clientes"
            + " where nombre=?"
            + " and apellidos=?";

    public static String CONSULTAESTADO = "select idEstado from estado"
            + " where codigo=?";

    public static String CONSULTASECCION = "select idSeccion from secciones"
            + " where nombre=?";
    
    
    
    

}
