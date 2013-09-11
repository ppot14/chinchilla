/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.objects;

import java.util.Date;

/**
 *
 * @author Pepe
 */
public class Produccion {
    
    private int id_produccion;
    private int id_cultivo;
    private int id_parcela;
    private Date fecha;
    private int kilos;
    private double precio_kilo;

    public int getId_produccion() {
        return id_produccion;
    }

    public void setId_produccion(int id_produccion) {
        this.id_produccion = id_produccion;
    }

    public int getId_cultivo() {
        return id_cultivo;
    }

    public void setId_cultivo(int id_cultivo) {
        this.id_cultivo = id_cultivo;
    }

    public int getId_parcela() {
        return id_parcela;
    }

    public void setId_parcela(int id_parcela) {
        this.id_parcela = id_parcela;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getKilos() {
        return kilos;
    }

    public void setKilos(int kilos) {
        this.kilos = kilos;
    }

    public double getPrecio_kilo() {
        return precio_kilo;
    }

    public void setPrecio_kilo(double precio_kilo) {
        this.precio_kilo = precio_kilo;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id_cultivo;
		result = prime * result + id_parcela;
		result = prime * result + id_produccion;
		result = prime * result + kilos;
		long temp;
		temp = Double.doubleToLongBits(precio_kilo);
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
		if (!(obj instanceof Produccion))
			return false;
		Produccion other = (Produccion) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id_cultivo != other.id_cultivo)
			return false;
		if (id_parcela != other.id_parcela)
			return false;
		if (id_produccion != other.id_produccion)
			return false;
		if (kilos != other.kilos)
			return false;
		if (Double.doubleToLongBits(precio_kilo) != Double
				.doubleToLongBits(other.precio_kilo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produccion [id_produccion=" + id_produccion + ", id_cultivo="
				+ id_cultivo + ", id_parcela=" + id_parcela + ", fecha="
				+ fecha + ", kilos=" + kilos + ", precio_kilo=" + precio_kilo
				+ "]";
	}
    
    
    
}
