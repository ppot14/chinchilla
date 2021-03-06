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
public class LaborParcela  implements Serializable{
    
//private TipoLabor tipoLabor;
 private int id_labor;
private Parcela parcela;
private Integer posicion_formula;

//    /**
//     * @return the tipoLabor
//     */
//    public TipoLabor getTipoLabor() {
//        return tipoLabor;
//    }
//
//    /**
//     * @param tipoLabor the tipoLabor to set
//     */
//    public void setTipoLabor(TipoLabor tipoLabor) {
//        this.tipoLabor = tipoLabor;
//    }

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
     * @return the parcela
     */
    public Parcela getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    @Override
    public String toString() {
        return "LaborParcela{" + "id_labor=" + id_labor + ", parcela=" + parcela + ", posicion_formula=" + posicion_formula + '}';
    }


    
}
