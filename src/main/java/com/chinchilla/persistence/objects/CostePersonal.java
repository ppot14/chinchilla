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
import java.util.Date;

/**
 *
 * @author Pepe
 */
public class CostePersonal implements Serializable{
    private int id_coste_personal;
    private String tipo;
    private String funcion;
    private Double salario_base;
    private Double paga_extra;
    private Integer horas_anuales;
    private Double base_ssp;
    private Double desempleo_pc;
    private Double plus_distancia;
    private Double km;
    private Double horas_dia;
    private Date validez_inicio;
    private Date validez_fin;

    /**
     * @return the id_coste_personal
     */
    public int getId_coste_personal() {
        return id_coste_personal;
    }

    /**
     * @param id_coste_personal the id_coste_personal to set
     */
    public void setId_coste_personal(int id_coste_personal) {
        this.id_coste_personal = id_coste_personal;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the funcion
     */
    public String getFuncion() {
        return funcion;
    }

    /**
     * @param funcion the funcion to set
     */
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    /**
     * @return the salario_base
     */
    public Double getSalario_base() {
        return salario_base;
    }

    /**
     * @param salario_base the salario_base to set
     */
    public void setSalario_base(Double salario_base) {
        this.salario_base = salario_base;
    }

    /**
     * @return the paga_extra
     */
    public Double getPaga_extra() {
        return paga_extra;
    }

    /**
     * @param paga_extra the paga_extra to set
     */
    public void setPaga_extra(Double paga_extra) {
        this.paga_extra = paga_extra;
    }

    /**
     * @return the horas_anuales
     */
    public Integer getHoras_anuales() {
        return horas_anuales;
    }

    /**
     * @param horas_anuales the horas_anuales to set
     */
    public void setHoras_anuales(Integer horas_anuales) {
        this.horas_anuales = horas_anuales;
    }

    /**
     * @return the base_ssp
     */
    public Double getBase_ssp() {
        return base_ssp;
    }

    /**
     * @param base_ssp the base_ssp to set
     */
    public void setBase_ssp(Double base_ssp) {
        this.base_ssp = base_ssp;
    }

    /**
     * @return the desempleo_pc
     */
    public Double getDesempleo_pc() {
        return desempleo_pc;
    }

    /**
     * @param desempleo_pc the desempleo_pc to set
     */
    public void setDesempleo_pc(Double desempleo_pc) {
        this.desempleo_pc = desempleo_pc;
    }

    /**
     * @return the plus_distancia
     */
    public Double getPlus_distancia() {
        return plus_distancia;
    }

    /**
     * @param plus_distancia the plus_distancia to set
     */
    public void setPlus_distancia(Double plus_distancia) {
        this.plus_distancia = plus_distancia;
    }

    /**
     * @return the km
     */
    public Double getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(Double km) {
        this.km = km;
    }

    /**
     * @return the horas_dia
     */
    public Double getHoras_dia() {
        return horas_dia;
    }

    /**
     * @param horas_dia the horas_dia to set
     */
    public void setHoras_dia(Double horas_dia) {
        this.horas_dia = horas_dia;
    }

    /**
     * @return the validez_inicio
     */
    public Date getValidez_inicio() {
        return validez_inicio;
    }

    /**
     * @param validez_inicio the validez_inicio to set
     */
    public void setValidez_inicio(Date validez_inicio) {
        this.validez_inicio = validez_inicio;
    }

    /**
     * @return the validez_fin
     */
    public Date getValidez_fin() {
        return validez_fin;
    }

    /**
     * @param validez_fin the validez_fin to set
     */
    public void setValidez_fin(Date validez_fin) {
        this.validez_fin = validez_fin;
    }
    
    

    @Override
    public String toString() {
        return "CostePersonal{" + "id_coste_personal=" + id_coste_personal + ", tipo=" + tipo + ", funcion=" + funcion + ", salario_base=" + salario_base + ", paga_extra=" + paga_extra + ", horas_anuales=" + horas_anuales + ", base_ssp=" + base_ssp + ", desempleo_pc=" + desempleo_pc + ", plus_distancia=" + plus_distancia + ", km=" + km + ", horas_dia=" + horas_dia + ", validez_inicio=" + validez_inicio + ", validez_fin=" + validez_fin + '}';
    }
}
