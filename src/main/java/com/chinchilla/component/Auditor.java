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

package com.chinchilla.component;

import com.chinchilla.persistence.dao.AuditoriaDAO;
import com.chinchilla.persistence.objects.Auditoria;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Pepe
 */
@Component("auditor")
public class Auditor {
    
    private static final Logger log = (Logger) LoggerFactory.getLogger(Auditor.class);
    
    public static final String SUCCESS = "success";
    
    public static final String ERROR = "error";
    
    public static final String WARNING = "warn";
    
    public static final String INFO = "info";
    
    @Autowired
    @Qualifier("auditoriaDAO")
    protected AuditoriaDAO auditoriaDAO; 
    
    public Auditoria incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo){
        
        return incluirMensaje(modelMap, tipo, titulo, null);
        
    }
    
    public Auditoria incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo, String mensaje){
        
        return incluirMensaje(modelMap, tipo, titulo, mensaje, -1, null);
        
    }
    
    public Auditoria incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo, String mensaje, int id_objeto){
        
        return incluirMensaje(modelMap, tipo, titulo, mensaje, id_objeto, null);
        
    }
    
    public Auditoria incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo, String mensaje, int id_objeto, Exception e){
        
        Date today = Calendar.getInstance().getTime(); 
        
        Auditoria auditoria = new Auditoria();
        
        auditoria.setFecha_evento(today);
        
        auditoria.setTipo_evento(tipo);
        
        auditoria.setMensaje(titulo);
        
        if(mensaje!=null) auditoria.setDescripcion(mensaje);
        
        if(id_objeto!=-1) auditoria.setId_objeto(id_objeto);
        
        if(e!=null) auditoria.setLog(ExceptionUtils.getStackTrace(e));
        
        int result = auditoriaDAO.create(auditoria);
        
        if(result!=1){
            
            log.error("Auditor no pudo crear la entrada en la base de datos");
            
            return auditoria;
            
        }else{
        
            return auditoria;
            
        }
    
    }
    
}
