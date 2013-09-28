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

import com.chinchilla.persistence.objects.Produccion;

/**
 *
 * @author Pepe
 */
public class ProduccionForm extends Produccion{
    
    private String insertar_modificar_eliminar;

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
    
    

    @Override
    public String toString() {
        return "ProduccionForm{" + "insertar_modificar_eliminar=" + insertar_modificar_eliminar + ", " + super.toString() + "}";
    }
    
}
