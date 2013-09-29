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

import java.io.Serializable;

/**
 *
 * @author Pepe
 */
public class Maquinaria implements Serializable{
    
    private int id_coste_maquinaria;
    private String nombre;
    private String tipo;
    private Double valor_compra;
    private Double valor_desecho;
    private Integer horas_trabajo;
    private Double interes;
    private Integer anyos_mas_1;
    private Double reparacion_variable;
    private Double alojamiento_variable;
    private Double prima_seguro;
    private Integer cv;
    private Double litros_cv_y_hora;
    private Integer horas_cambio_aceite;
    private Double litros_aceite;

    public int getId_coste_maquinaria() {
        return id_coste_maquinaria;
    }

    public void setId_coste_maquinaria(int id_coste_maquinaria) {
        this.id_coste_maquinaria = id_coste_maquinaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(Double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public Double getValor_desecho() {
        return valor_desecho;
    }

    public void setValor_desecho(Double valor_desecho) {
        this.valor_desecho = valor_desecho;
    }

    public Integer getHoras_trabajo() {
        return horas_trabajo;
    }

    public void setHoras_trabajo(Integer horas_trabajo) {
        this.horas_trabajo = horas_trabajo;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Integer getAnyos_mas_1() {
        return anyos_mas_1;
    }

    public void setAnyos_mas_1(Integer anyos_mas_1) {
        this.anyos_mas_1 = anyos_mas_1;
    }

    public Double getReparacion_variable() {
        return reparacion_variable;
    }

    public void setReparacion_variable(Double reparacion_variable) {
        this.reparacion_variable = reparacion_variable;
    }

    public Double getAlojamiento_variable() {
        return alojamiento_variable;
    }

    public void setAlojamiento_variable(Double alojamiento_variable) {
        this.alojamiento_variable = alojamiento_variable;
    }

    public Double getPrima_seguro() {
        return prima_seguro;
    }

    public void setPrima_seguro(Double prima_seguro) {
        this.prima_seguro = prima_seguro;
    }

    public Integer getCv() {
        return cv;
    }

    public void setCv(Integer cv) {
        this.cv = cv;
    }

    public Double getLitros_cv_y_hora() {
        return litros_cv_y_hora;
    }

    public void setLitros_cv_y_hora(Double litros_cv_y_hora) {
        this.litros_cv_y_hora = litros_cv_y_hora;
    }

    public Integer getHoras_cambio_aceite() {
        return horas_cambio_aceite;
    }

    public void setHoras_cambio_aceite(Integer horas_cambio_aceite) {
        this.horas_cambio_aceite = horas_cambio_aceite;
    }

    public Double getLitros_aceite() {
        return litros_aceite;
    }

    public void setLitros_aceite(Double litros_aceite) {
        this.litros_aceite = litros_aceite;
    }
    
    
    
}
