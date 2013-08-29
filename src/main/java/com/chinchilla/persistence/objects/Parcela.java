package com.chinchilla.persistence.objects;

/**
 * A simple DTO (Data Transfer Object) class that provides the mapping of data
 * to a table similar to this: table: status columns: status_id
 * (INT),status_name (VARCHAR)
 */
public class Parcela {

    private int id_parcela;
    private String nombre;
    private String nombre_corto;
    private String zona;
    private Double extension;
    private String cultivo_fijo;

    

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 67 * hash + (this.nombre_corto != null ? this.nombre_corto.hashCode() : 0);
        hash = 67 * hash + (this.zona != null ? this.zona.hashCode() : 0);
        hash = 67 * hash + (this.extension != null ? this.extension.hashCode() : 0);
        hash = 67 * hash + (this.cultivo_fijo != null ? this.cultivo_fijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parcela other = (Parcela) obj;
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        if ((this.nombre_corto == null) ? (other.nombre_corto != null) : !this.nombre_corto.equals(other.nombre_corto)) {
            return false;
        }
        if ((this.zona == null) ? (other.zona != null) : !this.zona.equals(other.zona)) {
            return false;
        }
        if (this.extension != other.extension && (this.extension == null || !this.extension.equals(other.extension))) {
            return false;
        }
        if ((this.cultivo_fijo == null) ? (other.cultivo_fijo != null) : !this.cultivo_fijo.equals(other.cultivo_fijo)) {
            return false;
        }
        return true;
    }
    
    
}
