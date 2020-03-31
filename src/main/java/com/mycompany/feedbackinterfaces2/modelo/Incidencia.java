package com.mycompany.feedbackinterfaces2.modelo;

import java.sql.Date;

/**
 *
 * @author Hp
 */
public class Incidencia {

    private int incidencia;
    private String descripcion;
    private Date fecha;
    private int idCliente;
    private int idSeccion;
    private int idEstado;
    private float importe;

    public Incidencia() {
    }

    public Incidencia(int incidencia, String descripcion, Date fecha, int idCliente, int idSeccion, int idEstado, float importe) {
        this.incidencia = incidencia;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idSeccion = idSeccion;
        this.idEstado = idEstado;
        this.importe = importe;
    }

    public int getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(int incidencia) {
        this.incidencia = incidencia;
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
        return "Incidencia{" + "incidencia=" + incidencia + ", descripcion=" + descripcion + ", fecha=" + fecha + ", idCliente=" + idCliente + ", idSeccion=" + idSeccion + ", idEstado=" + idEstado + ", impote=" + importe + '}';
    }
    
    

}