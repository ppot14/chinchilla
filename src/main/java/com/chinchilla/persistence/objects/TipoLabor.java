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
import java.util.List;

/**
 *
 * @author Pepe
 */
public class TipoLabor implements Serializable{
    
    private int id_tipo_labor;
    private String tipo;
    private String nombre;
    private String descripcion;
    private int id_formula;
    private List<TipoLaborMaquinaria> tipo_labor_maquinaria;
    private List<TipoLaborProducto> tipo_labor_producto;
    

    public int getId_tipo_labor() {
        return id_tipo_labor;
    }

    public void setId_tipo_labor(int id_tipo_labor) {
        this.id_tipo_labor = id_tipo_labor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_formula() {
        return id_formula;
    }

    public void setId_formula(int id_formula) {
        this.id_formula = id_formula;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id_formula;
		result = prime * result + id_tipo_labor;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoLabor))
			return false;
		TipoLabor other = (TipoLabor) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id_formula != other.id_formula)
			return false;
		if (id_tipo_labor != other.id_tipo_labor)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoLabor [id_tipo_labor=" + id_tipo_labor + ", tipo=" + tipo
				+ ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", id_formula=" + id_formula 
				+ ", tipo_labor_maquinaria=" + tipo_labor_maquinaria 
				+ ", tipo_labor_producto=" + tipo_labor_producto +  "]";
	}

    /**
     * @return the tipo_labor_maquinaria
     */
    public List<TipoLaborMaquinaria> getTipo_labor_maquinaria() {
        return tipo_labor_maquinaria;
    }

    /**
     * @param tipo_labor_maquinaria the tipo_labor_maquinaria to set
     */
    public void setTipo_labor_maquinaria(List<TipoLaborMaquinaria> tipo_labor_maquinaria) {
        this.tipo_labor_maquinaria = tipo_labor_maquinaria;
    }

    /**
     * @return the tipo_labor_producto
     */
    public List<TipoLaborProducto> getTipo_labor_producto() {
        return tipo_labor_producto;
    }

    /**
     * @param tipo_labor_producto the tipo_labor_producto to set
     */
    public void setTipo_labor_producto(List<TipoLaborProducto> tipo_labor_producto) {
        this.tipo_labor_producto = tipo_labor_producto;
    }
    
    
}
