/*
 * The MIT License
 *
 * Copyright 2013 Pepe.
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

import java.util.Date;

/**
 *
 * @author Pepe
 */
public class Labor {

    private int id_labor;
    private int id_tipo_labor;
    private Date fecha_comienzo;
    private double cantidad_dosis_por_ha;
    private double duracion;
    private double litros_gasoil;

    public int getId_labor() {
        return id_labor;
    }

    public void setId_labor(int id_labor) {
        this.id_labor = id_labor;
    }

    public int getId_tipo_labor() {
        return id_tipo_labor;
    }

    public void setId_tipo_labor(int id_tipo_labor) {
        this.id_tipo_labor = id_tipo_labor;
    }

    public Date getFecha_comienzo() {
        return fecha_comienzo;
    }

    public void setFecha_comienzo(Date fecha_comienzo) {
        this.fecha_comienzo = fecha_comienzo;
    }

    public double getCantidad_dosis_por_ha() {
        return cantidad_dosis_por_ha;
    }

    public void setCantidad_dosis_por_ha(double cantidad_dosis_por_ha) {
        this.cantidad_dosis_por_ha = cantidad_dosis_por_ha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getLitros_gasoil() {
        return litros_gasoil;
    }

    public void setLitros_gasoil(double litros_gasoil) {
        this.litros_gasoil = litros_gasoil;
    }
    
    
}
