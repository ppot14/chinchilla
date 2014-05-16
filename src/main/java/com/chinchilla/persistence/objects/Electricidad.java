/*
 * The MIT License
 *
 * Copyright 2014 Pepe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.chinchilla.persistence.objects;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pepe
 */
public class Electricidad implements Serializable{
    
    private int id_electricidad;
    private Date fecha_inicio;
    private Date fecha_fin;
    private double consumo;
    private double precio_kw;
    private double precio_potencia;
    private double impuesto_electricidad;
    private double iva;
    
    public Electricidad(){
        
    }

    public Electricidad(int id_electricidad, Date fecha_inicio, Date fecha_fin, double consumo, double precio_kw, double precio_potencia, double impuesto_electricidad, double iva) {
        this.id_electricidad = id_electricidad;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.consumo = consumo;
        this.precio_kw = precio_kw;
        this.precio_potencia = precio_potencia;
        this.impuesto_electricidad = impuesto_electricidad;
        this.iva = iva;
    }
    
    public int getId_electricidad() {
        return id_electricidad;
    }

    public void setId_electricidad(int id_electricidad) {
        this.id_electricidad = id_electricidad;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getPrecio_kw() {
        return precio_kw;
    }

    public void setPrecio_kw(double precio_kw) {
        this.precio_kw = precio_kw;
    }

    public double getImpuesto_electricidad() {
        return impuesto_electricidad;
    }

    public void setImpuesto_electricidad(double impuesto_electricidad) {
        this.impuesto_electricidad = impuesto_electricidad;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the precio_potencia
     */
    public double getPrecio_potencia() {
        return precio_potencia;
    }

    /**
     * @param precio_potencia the precio_potencia to set
     */
    public void setPrecio_potencia(double precio_potencia) {
        this.precio_potencia = precio_potencia;
    }

    @Override
    public String toString() {
        return "Electricidad{" + 
                "id_electricidad=" + id_electricidad + 
                ", fecha_inicio=" + fecha_inicio + 
                ", fecha_fin=" + fecha_fin + 
                ", consumo=" + consumo + 
                ", precio_kw=" + precio_kw + 
                ", precio_potencia=" + precio_potencia + 
                ", impuesto_electricidad=" + impuesto_electricidad + 
                ", iva=" + iva + 
                '}';
    }
    
    
}
