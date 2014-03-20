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

import com.chinchilla.form.LaborForm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class Labor implements Serializable{

    private int id_labor;
    private String grupo;
    private String nombre;
    private Date fecha_comienzo;
    private double cantidad_dosis_por_ha;
    private double duracion;
    private double litros_gasoil;
    private List<LaborMaquinaria> labor_maquinaria;
    private List<LaborProducto> labor_producto;
    private List<LaborPersonal> labor_personal;
    private List<LaborParcela> labor_parcela;
    
    public Labor() {
    }

    public Labor(Labor labor) {
        id_labor = labor.getId_labor();
        grupo = labor.getGrupo();
        nombre = labor.getNombre();
        fecha_comienzo = labor.getFecha_comienzo();
        cantidad_dosis_por_ha = labor.getCantidad_dosis_por_ha();
        duracion = labor.getDuracion();
        litros_gasoil = labor.getLitros_gasoil();
        labor_maquinaria = labor.getLabor_maquinaria();
        labor_producto = labor.getLabor_producto();
        labor_personal = labor.getLabor_personal();
        labor_parcela = labor.getLabor_parcela();
    }

    public int getId_labor() {
        return id_labor;
    }

    public void setId_labor(int id_labor) {
        this.id_labor = id_labor;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cantidad_dosis_por_ha);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(duracion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((fecha_comienzo == null) ? 0 : fecha_comienzo.hashCode());
		result = prime * result + id_labor;
		temp = Double.doubleToLongBits(litros_gasoil);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!(obj instanceof Labor))
			return false;
		Labor other = (Labor) obj;
		if (Double.doubleToLongBits(cantidad_dosis_por_ha) != Double
				.doubleToLongBits(other.cantidad_dosis_por_ha))
			return false;
		if (Double.doubleToLongBits(duracion) != Double
				.doubleToLongBits(other.duracion))
			return false;
		if (fecha_comienzo == null) {
			if (other.fecha_comienzo != null)
				return false;
		} else if (!fecha_comienzo.equals(other.fecha_comienzo))
			return false;
		if (id_labor != other.id_labor)
			return false;
		if (Double.doubleToLongBits(litros_gasoil) != Double
				.doubleToLongBits(other.litros_gasoil))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Labor{id_labor=" + id_labor 
                                + ", fecha_comienzo=" + fecha_comienzo
				+ ", cantidad_dosis_por_ha=" + cantidad_dosis_por_ha
				+ ", duracion=" + duracion 
                                + ", litros_gasoil=" + litros_gasoil
				+ ", labor_maquinaria=" + labor_maquinaria 
                                + ", labor_producto=" + labor_producto
				+ ", labor_personal=" + labor_personal 
				+ ", labor_parcela=" + labor_parcela 
				+ "}";
	}
    
    /**
     * @return the labor_maquinaria
     */
    public List<LaborMaquinaria> getLabor_maquinaria() {
        return labor_maquinaria;
    }

    /**
     * @param labor_maquinaria the labor_maquinaria to set
     */
    public void setLabor_maquinaria(List<LaborMaquinaria> labor_maquinaria) {
        this.labor_maquinaria = labor_maquinaria;
    }

    /**
     * @return the labor_producto
     */
    public List<LaborProducto> getLabor_producto() {
        return labor_producto;
    }

    /**
     * @param labor_producto the labor_producto to set
     */
    public void setLabor_producto(List<LaborProducto> labor_producto) {
        this.labor_producto = labor_producto;
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
     * @return the labor_personal
     */
    public List<LaborPersonal> getLabor_personal() {
        return labor_personal;
    }

    /**
     * @param labor_personal the labor_personal to set
     */
    public void setLabor_personal(List<LaborPersonal> labor_personal) {
        this.labor_personal = labor_personal;
    }

    /**
     * @return the labor_parcela
     */
    public List<LaborParcela> getLabor_parcela() {
        return labor_parcela;
    }

    /**
     * @param labor_parcela the labor_parcela to set
     */
    public void setLabor_parcela(List<LaborParcela> labor_parcela) {
        this.labor_parcela = labor_parcela;
    }
    
}
