package com.mycompany.feedbackinterfaces2.modelo;

import java.sql.Date;

/**
 * Clase que representa la tabla incidencias en bbdd
 * @author Hp
 */
public class Incidencia {

    private int idIncidencia;
    private String descripcion;
    private Date fecha;
    private int idCliente;
    private int idSeccion;
    private int idEstado;
    private float importe;
    
    
    /**
     * Constructor vacío
     */
    public Incidencia() {
    }
    
    
    /**
     * Constructor con todos los atributos
     * @param idIncidencia
     * @param descripcion
     * @param fecha
     * @param idCliente
     * @param idSeccion
     * @param idEstado
     * @param importe 
     */
    public Incidencia(int idIncidencia, String descripcion, Date fecha, int idCliente, int idSeccion, int idEstado, float importe) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idSeccion = idSeccion;
        this.idEstado = idEstado;
        this.importe = importe;
    }
    
    
    /**
     * Constructor con varios atributos
     * @param descripcion
     * @param fecha
     * @param idCliente
     * @param idSeccion
     * @param idEstado
     * @param importe 
     */
    public Incidencia(String descripcion, Date fecha, int idCliente, int idSeccion, int idEstado, float importe) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idSeccion = idSeccion;
        this.idEstado = idEstado;
        this.importe = importe;
    }

    
    
    
    /**
     * Método que devuelve el id de una incidencia
     * @return  el id de una incidencia
     */
    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Incidencia{" + "incidencia=" + idIncidencia + ", descripcion=" + descripcion + ", fecha=" + fecha + ", idCliente=" + idCliente + ", idSeccion=" + idSeccion + ", idEstado=" + idEstado + ", impote=" + importe + '}';
    }
    
    

}
