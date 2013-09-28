/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.objects;

import java.io.Serializable;

/**
 *
 * @author Pepe
 */
public class Coordenada implements Serializable{

    private int id_parcela;
    private int orden;
    private double latitud;
    private double longitud;

    @Override
    public String toString() {
        return "[Coordenada] " + "(" + getId_parcela() + ") " + getId_parcela() + " (" + getLatitud() + "," + getLongitud() + ")";
    }

    /**
     * @return the id_parcela
     */
    public int getId_parcela() {
        return id_parcela;
    }

    /**
     * @param id_parcela the id_parcela to set
     */
    public void setId_parcela(int id_parcela) {
        this.id_parcela = id_parcela;
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }

    /**
     * @return the latitud
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_parcela;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordenada other = (Coordenada) obj;
        if (this.id_parcela != other.id_parcela) {
            return false;
        }
        if (this.orden != other.orden) {
            return false;
        }
        if (Double.doubleToLongBits(this.latitud) != Double.doubleToLongBits(other.latitud)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitud) != Double.doubleToLongBits(other.longitud)) {
            return false;
        }
        return true;
    }
    
    
}
