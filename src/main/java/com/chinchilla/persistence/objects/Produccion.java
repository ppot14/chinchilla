/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.objects;

import java.util.Date;

/**
 *
 * @author Pepe
 */
public class Produccion {
    
    private int id_produccion;
    private int id_cultivo;
    private int id_parcela;
    private Date fecha;
    private int kilos;
    private double precio_kilo;

    public int getId_produccion() {
        return id_produccion;
    }

    public void setId_produccion(int id_produccion) {
        this.id_produccion = id_produccion;
    }

    public int getId_cultivo() {
        return id_cultivo;
    }

    public void setId_cultivo(int id_cultivo) {
        this.id_cultivo = id_cultivo;
    }

    public int getId_parcela() {
        return id_parcela;
    }

    public void setId_parcela(int id_parcela) {
        this.id_parcela = id_parcela;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getKilos() {
        return kilos;
    }

    public void setKilos(int kilos) {
        this.kilos = kilos;
    }

    public double getPrecio_kilo() {
        return precio_kilo;
    }

    public void setPrecio_kilo(double precio_kilo) {
        this.precio_kilo = precio_kilo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_produccion;
        hash = 97 * hash + this.id_cultivo;
        hash = 97 * hash + this.id_parcela;
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
        final Produccion other = (Produccion) obj;
        if (this.id_produccion != other.id_produccion) {
            return false;
        }
        if (this.id_cultivo != other.id_cultivo) {
            return false;
        }
        if (this.id_parcela != other.id_parcela) {
            return false;
        }
        if (this.fecha != other.fecha && (this.fecha == null || !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.kilos != other.kilos) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio_kilo) != Double.doubleToLongBits(other.precio_kilo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produccion{" + "id_produccion=" + id_produccion + ", id_cultivo=" + id_cultivo + ", id_parcela=" + id_parcela + ", fecha=" + fecha + ", kilos=" + kilos + ", precio_kilo=" + precio_kilo + '}';
    }
    
    
    
}
