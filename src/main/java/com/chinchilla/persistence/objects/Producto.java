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
public class Producto implements Serializable{
    private	int	id_producto	;
private	String	grupo	;
private	String	tipo	;
private	String	nombre	;
private	String	descripcion	;
private	String	num_reg_ma	;
private	Integer	plazo_seguridad	;

    /**
     * @return the id_producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the num_reg_ma
     */
    public String getNum_reg_ma() {
        return num_reg_ma;
    }

    /**
     * @param num_reg_ma the num_reg_ma to set
     */
    public void setNum_reg_ma(String num_reg_ma) {
        this.num_reg_ma = num_reg_ma;
    }

    /**
     * @return the plazo_seguridad
     */
    public Integer getPlazo_seguridad() {
        return plazo_seguridad;
    }

    /**
     * @param plazo_seguridad the plazo_seguridad to set
     */
    public void setPlazo_seguridad(Integer plazo_seguridad) {
        this.plazo_seguridad = plazo_seguridad;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", grupo=" + grupo + ", tipo=" + tipo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", num_reg_ma=" + num_reg_ma + ", plazo_seguridad=" + plazo_seguridad + '}';
    }

}
