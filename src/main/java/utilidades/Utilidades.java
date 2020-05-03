package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Clase con algunas funciones útiles para conersión y validación de fechas.
 *
 * @author Hp
 */
public class Utilidades {

    /**
     * Método que comprueba si el formato de una fecha es correcta
     *
     * @param fecha Fecha que se pasa por parámetro
     * @return devuelve true si la fecha es correcta y false , si no lo es
     */
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Método que formatea una fecha.
     *
     * @param uDate fecha en formato java.util.Date
     * @return Devuelve una fecha en formato java.sql.Date
     */
    public static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
