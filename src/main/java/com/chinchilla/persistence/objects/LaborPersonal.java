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
public class LaborPersonal implements Serializable{
    
 private int id_labor;
private CostePersonal coste_personal;
private Personal personal;
private Double multiplicador;
private Double constante;
private Integer posicion_formula;

    /**
     * @return the id_labor
     */
    public int getId_labor() {
        return id_labor;
    }

    /**
     * @param id_labor the id_labor to set
     */
    public void setId_labor(int id_labor) {
        this.id_labor = id_labor;
    }

    /**
     * @return the coste_personal
     */
    public CostePersonal getCoste_personal() {
        return coste_personal;
    }

    /**
     * @param coste_personal the coste_personal to set
     */
    public void setCoste_personal(CostePersonal coste_personal) {
        this.coste_personal = coste_personal;
    }

    /**
     * @return the personal
     */
    public Personal getPersonal() {
        return personal;
    }

    /**
     * @param personal the personal to set
     */
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    /**
     * @return the multiplicador
     */
    public Double getMultiplicador() {
        return multiplicador;
    }

    /**
     * @param multiplicador the multiplicador to set
     */
    public void setMultiplicador(Double multiplicador) {
        this.multiplicador = multiplicador;
    }

    /**
     * @return the constante
     */
    public Double getConstante() {
        return constante;
    }

    /**
     * @param constante the constante to set
     */
    public void setConstante(Double constante) {
        this.constante = constante;
    }

    /**
     * @return the posicion_formula
     */
    public Integer getPosicion_formula() {
        return posicion_formula;
    }

    /**
     * @param posicion_formula the posicion_formula to set
     */
    public void setPosicion_formula(Integer posicion_formula) {
        this.posicion_formula = posicion_formula;
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LaborPersonal{id_labor=" + id_labor 
				+ ", multiplicador=" + multiplicador 
                                + ", constante=" + constante
				+ ", posicion_formula=" + posicion_formula 
				+ ", coste_personal=" + coste_personal 
				+ ", personal=" + personal 
                                + "}";
	}
}
