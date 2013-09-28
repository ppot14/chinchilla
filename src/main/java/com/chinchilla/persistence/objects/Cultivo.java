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
public class Cultivo implements Serializable{
    
    private int id_cultivo;
    private String variedad;
    private String especie;
    private String destino;

    @Override
    public String toString() {
        return "Cultivo{" + "id_cultivo=" + id_cultivo + ", variedad=" + variedad + ", especie=" + especie + ", destino=" + destino + '}';
    }

    public int getId_cultivo() {
        return id_cultivo;
    }

    public void setId_cultivo(int id_cultivo) {
        this.id_cultivo = id_cultivo;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.especie != null ? this.especie.hashCode() : 0);
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
        final Cultivo other = (Cultivo) obj;
        if (this.id_cultivo != other.id_cultivo) {
            return false;
        }
        if ((this.variedad == null) ? (other.variedad != null) : !this.variedad.equals(other.variedad)) {
            return false;
        }
        if ((this.especie == null) ? (other.especie != null) : !this.especie.equals(other.especie)) {
            return false;
        }
        if ((this.destino == null) ? (other.destino != null) : !this.destino.equals(other.destino)) {
            return false;
        }
        return true;
    }
    
    
    
}
