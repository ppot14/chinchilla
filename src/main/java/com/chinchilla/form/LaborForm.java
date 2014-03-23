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
package com.chinchilla.form;

import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.LaborMaquinaria;
import com.chinchilla.persistence.objects.LaborParcela;
import com.chinchilla.persistence.objects.LaborPersonal;
import com.chinchilla.persistence.objects.LaborProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class LaborForm extends Labor{

    private String insertar_modificar_eliminar;
    
    private List<Integer> id_maquinarias;
    private List<Integer> id_productos;
    private List<Integer> id_costes_personal;
    private List<Integer> id_parcelas;
    
    public LaborForm(){
        super();
    }
    
    public LaborForm(Labor labor){
        super(labor);
    }

    /**
     * @return the insertar_modificar_eliminar
     */
    public String getInsertar_modificar_eliminar() {
        return insertar_modificar_eliminar;
    }

    /**
     * @param insertar_modificar_eliminar the insertar_modificar_eliminar to set
     */
    public void setInsertar_modificar_eliminar(String insertar_modificar_eliminar) {
        this.insertar_modificar_eliminar = insertar_modificar_eliminar;
    }

    /**
     * @return the id_maquinarias
     */
    public List<Integer> getId_maquinarias() {
        return id_maquinarias;
    }

    /**
     * @param id_maquinarias the id_maquinarias to set
     */
    public void setId_maquinarias(List<Integer> id_maquinarias) {
        this.id_maquinarias = id_maquinarias;
    }

    /**
     * @return the id_productos
     */
    public List<Integer> getId_productos() {
        return id_productos;
    }

    /**
     * @param id_productos the id_productos to set
     */
    public void setId_productos(List<Integer> id_productos) {
        this.id_productos = id_productos;
    }

    /**
     * @return the id_costes_personal
     */
    public List<Integer> getId_costes_personal() {
        return id_costes_personal;
    }

    /**
     * @param id_costes_personal the id_costes_personal to set
     */
    public void setId_costes_personal(List<Integer> id_costes_personal) {
        this.id_costes_personal = id_costes_personal;
    }

    /**
     * @return the id_parcelas
     */
    public List<Integer> getId_parcelas() {
        return id_parcelas;
    }

    /**
     * @param id_parcelas the id_parcelas to set
     */
    public void setId_parcelas(List<Integer> id_parcelas) {
        this.id_parcelas = id_parcelas;
    }
    
    public void setUpListIds(){
        id_maquinarias = new ArrayList<>();
        id_productos = new ArrayList<>();
        id_costes_personal = new ArrayList<>();
        id_parcelas = new ArrayList<>();
        
        for(LaborMaquinaria lm : getLabor_maquinaria()){
            id_maquinarias.add(lm.getMaquinaria().getId_coste_maquinaria());
        }
        
        for(LaborParcela lpa : getLabor_parcela()){
            id_parcelas.add(lpa.getParcela().getId_parcela());
        }
        
        for(LaborPersonal lpe : getLabor_personal()){
            id_costes_personal.add(lpe.getCoste_personal().getId_coste_personal());
        }
        
        for(LaborProducto lpr : getLabor_producto()){
            id_productos.add(lpr.getProducto().getId_producto());
        }
    }

    @Override
    public String toString() {
        return "LaborForm{" + "insertar_modificar_eliminar=" + insertar_modificar_eliminar + 
                ", id_maquinarias=" + id_maquinarias + 
                ", id_productos=" + id_productos + 
                ", id_costes_personal=" + id_costes_personal + 
                ", id_parcelas=" + id_parcelas + ", " + super.toString() + "}";
    }
}
