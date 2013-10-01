package com.chinchilla.persistence.objects;

import java.io.Serializable;

/**
 * A simple DTO (Data Transfer Object) class that provides the mapping of data
 * to a table similar to this: table: status columns: status_id
 * (INT),status_name (VARCHAR)
 */
public class Parcela implements Serializable{

    private int id_parcela;
    private String nombre;
    private String nombre_corto;
    private String zona;
    private Double extension;
    private String cultivo_fijo;
    private String color;
    

    /**
     * @return the id_parcela
     */
    public int getId_parcela() {
        return id_parcela;
    }

    /**
     * @param id_parcela the id_parcela to set
     */
    public void setId_parcela(int id_parcela) {
        this.id_parcela = id_parcela;
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
     * @return the nombre_corto
     */
    public String getNombre_corto() {
        return nombre_corto;
    }

    /**
     * @param nombre_corto the nombre_corto to set
     */
    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
    }

    /**
     * @return the extension
     */
    public Double getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(Double extension) {
        this.extension = extension;
    }

    /**
     * @return the cultivo_fijo
     */
    public String getCultivo_fijo() {
        return cultivo_fijo;
    }

    /**
     * @param cultivo_fijo the cultivo_fijo to set
     */
    public void setCultivo_fijo(String cultivo_fijo) {
        this.cultivo_fijo = cultivo_fijo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((cultivo_fijo == null) ? 0 : cultivo_fijo.hashCode());
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + id_parcela;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((nombre_corto == null) ? 0 : nombre_corto.hashCode());
		result = prime * result + ((zona == null) ? 0 : zona.hashCode());
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
		if (!(obj instanceof Parcela))
			return false;
		Parcela other = (Parcela) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (cultivo_fijo == null) {
			if (other.cultivo_fijo != null)
				return false;
		} else if (!cultivo_fijo.equals(other.cultivo_fijo))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (id_parcela != other.id_parcela)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombre_corto == null) {
			if (other.nombre_corto != null)
				return false;
		} else if (!nombre_corto.equals(other.nombre_corto))
			return false;
		if (zona == null) {
			if (other.zona != null)
				return false;
		} else if (!zona.equals(other.zona))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parcela [id_parcela=" + id_parcela + ", nombre=" + nombre
				+ ", nombre_corto=" + nombre_corto + ", zona=" + zona
				+ ", extension=" + extension + ", cultivo_fijo=" + cultivo_fijo
				+ ", color=" + color + "]";
	}
    
    
}
