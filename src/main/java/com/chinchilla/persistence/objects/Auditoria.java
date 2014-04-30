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
public class Auditoria implements Serializable{

    private int id_auditoria;
    private Date fecha_evento;
    private String tipo_evento;
    private int codigo;
    private String mensaje;
    private String descripcion;
    private String log;
    private int id_objeto;

    /**
     * @return the id_auditoria
     */
    public int getId_auditoria() {
        return id_auditoria;
    }

    /**
     * @param id_auditoria the id_auditoria to set
     */
    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    /**
     * @return the fecha_evento
     */
    public Date getFecha_evento() {
        return fecha_evento;
    }

    /**
     * @param fecha_evento the fecha_evento to set
     */
    public void setFecha_evento(Date fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    /**
     * @return the tipo_evento
     */
    public String getTipo_evento() {
        return tipo_evento;
    }

    /**
     * @param tipo_evento the tipo_evento to set
     */
    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
     * @return the log
     */
    public String getLog() {
        return log;
    }

    /**
     * @param log the log to set
     */
    public void setLog(String log) {
        this.log = log;
    }

    /**
     * @return the id_objeto
     */
    public int getId_objeto() {
        return id_objeto;
    }

    /**
     * @param id_objeto the id_objeto to set
     */
    public void setId_objeto(int id_objeto) {
        this.id_objeto = id_objeto;
    }

    @Override
    public String toString() {
        return "Auditoria{" + "id_auditoria=" + id_auditoria + ", fecha_evento=" + fecha_evento + ", tipo_evento=" + tipo_evento + ", codigo=" + codigo + ", mensaje=" + mensaje + ", descripcion=" + descripcion + ", log=" + log + ", id_objeto=" + id_objeto + '}';
    }
}
