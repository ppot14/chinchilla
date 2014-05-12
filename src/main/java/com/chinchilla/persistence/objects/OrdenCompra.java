/*
 * The MIT License
 *
 * Copyright 2014 Pepe.
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
import java.util.Date;

/**
 *
 * @author Pepe
 */
public class OrdenCompra implements Serializable{
    
    private int id_orden_compra;
    private int id_elemento;
    private String num_factura;
    private double cantidad;
    private double precio;
    private double total;
    private String marca;
    private String proveedor;
    private Date fecha;
    private Date fecha_albaran;
    private String medida;
    private String nota;
    
    public OrdenCompra(){
        
    }
    
    public OrdenCompra(OrdenCompra oc){
        id_orden_compra = oc.getId_orden_compra();
        id_elemento = oc.getId_elemento();
        num_factura = oc.getNum_factura();
        cantidad = oc.getCantidad();
        precio = oc.getPrecio();
        total = oc.getTotal();
        marca = oc.getMarca();
        proveedor = oc.getProveedor();
        fecha = oc.getFecha();
        fecha_albaran = oc.getFecha_albaran();
        medida = oc.getMedida();
        nota = oc.getNota();
    }

    /**
     * @return the id_orden_compra
     */
    public int getId_orden_compra() {
        return id_orden_compra;
    }

    /**
     * @param id_orden_compra the id_orden_compra to set
     */
    public void setId_orden_compra(int id_orden_compra) {
        this.id_orden_compra = id_orden_compra;
    }

    /**
     * @return the id_elemento
     */
    public int getId_elemento() {
        return id_elemento;
    }

    /**
     * @param id_elemento the id_elemento to set
     */
    public void setId_elemento(int id_elemento) {
        this.id_elemento = id_elemento;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the proveedor
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the medida
     */
    public String getMedida() {
        return medida;
    }

    /**
     * @param medida the medida to set
     */
    public void setMedida(String medida) {
        this.medida = medida;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the fecha_albaran
     */
    public Date getFecha_albaran() {
        return fecha_albaran;
    }

    /**
     * @param fecha_albaran the fecha_albaran to set
     */
    public void setFecha_albaran(Date fecha_albaran) {
        this.fecha_albaran = fecha_albaran;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * @return the num_factura
     */
    public String getNum_factura() {
        return num_factura;
    }

    /**
     * @param num_factura the num_factura to set
     */
    public void setNum_factura(String num_factura) {
        this.num_factura = num_factura;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" + "id_orden_compra=" + id_orden_compra + 
                ", id_elemento=" + id_elemento + 
                ", num_factura=" + num_factura + 
                ", cantidad=" + cantidad + 
                ", precio=" + precio + 
                ", total=" + total + 
                ", marca=" + marca + 
                ", proveedor=" + proveedor + 
                ", fecha=" + fecha + 
                ", fecha_albaran=" + fecha_albaran +
                ", nota=" + nota + '}';
    }
}
