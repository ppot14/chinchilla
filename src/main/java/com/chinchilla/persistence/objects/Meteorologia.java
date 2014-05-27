/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.objects;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pepe
 */
public class Meteorologia implements Serializable, Comparable{

    private int id_meteorologia;
    private Date fecha;
    private double publio_chinchilla;
    private double publio_osuna;
    private String viento;
    private String estado;
    private double temp_max;
    private double temp_min;

    /**
     * @return the id_meteorologia
     */
    public int getId_meteorologia() {
        return id_meteorologia;
    }

    /**
     * @param id_meteorologia the id_meteorologia to set
     */
    public void setId_meteorologia(int id_meteorologia) {
        this.id_meteorologia = id_meteorologia;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the publio_chinchilla
     */
    public double getPublio_chinchilla() {
        return publio_chinchilla;
    }

    /**
     * @param publio_chinchilla the publio_chinchilla to set
     */
    public void setPublio_chinchilla(double publio_chinchilla) {
        this.publio_chinchilla = publio_chinchilla;
    }

    /**
     * @return the publio_osuna
     */
    public double getPublio_osuna() {
        return publio_osuna;
    }

    /**
     * @param publio_osuna the publio_osuna to set
     */
    public void setPublio_osuna(double publio_osuna) {
        this.publio_osuna = publio_osuna;
    }

    /**
     * @return the viento
     */
    public String getViento() {
        return viento;
    }

    /**
     * @param viento the viento to set
     */
    public void setViento(String viento) {
        this.viento = viento;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the temp_max
     */
    public double getTemp_max() {
        return temp_max;
    }

    /**
     * @param temp_max the temp_max to set
     */
    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    /**
     * @return the temp_min
     */
    public double getTemp_min() {
        return temp_min;
    }

    /**
     * @param temp_min the temp_min to set
     */
    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    @Override
    public String toString() {
        return "Meteorologia{" + "id_meteorologia=" + id_meteorologia + ", fecha=" + fecha + ", publio_chinchilla=" + publio_chinchilla + ", publio_osuna=" + publio_osuna + ", viento=" + viento + ", estado=" + estado + ", temp_max=" + temp_max + ", temp_min=" + temp_min + '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.fecha.compareTo(((Meteorologia)o).getFecha());
    }
    
}
