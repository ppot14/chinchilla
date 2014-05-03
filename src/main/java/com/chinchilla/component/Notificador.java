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
package com.chinchilla.component;

import com.chinchilla.component.Auditor;
import com.chinchilla.persistence.objects.Auditoria;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pepe
 */
public class Notificador extends Auditor{
    
    private static final Logger log = (Logger) LoggerFactory.getLogger(Notificador.class);
    
    @Override
    public Auditoria incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo){
        
        return incluirMensaje(modelMap, tipo, titulo, null);
        
    }
    
    @Override
    public Auditoria incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo, String mensaje){
        
        return incluirMensaje(modelMap, tipo, titulo, mensaje, -1);
        
    }
    
    @Override
    public Auditoria incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo, String mensaje, int id_objeto){
        
        Auditoria auditoria = super.incluirMensaje(modelMap, tipo, titulo, mensaje, id_objeto);
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Map<String, Object > notificacion  = new HashMap<String,Object>();   

        notificacion.put("fecha", df.format(auditoria.getFecha_evento()));
        
        notificacion.put("tipo", tipo);

        notificacion.put("titulo", titulo);

        notificacion.put("mensaje", (mensaje!=null)?mensaje:"");
        
        modelMap.remove("notificacion");
        
        modelMap.put("notificacion", notificacion);
        
        return auditoria;
        
    }
    
    public void incluirMensajeExito( Map<String, Object > modelMap, String titulo, String mensaje, int id_objeto){
        incluirMensaje( modelMap, Auditor.SUCCESS, titulo, mensaje, id_objeto);
    }
    
    public void incluirMensajeError( Map<String, Object > modelMap, String titulo, String mensaje, int id_objeto){
        incluirMensaje( modelMap, Auditor.ERROR, titulo, mensaje, id_objeto);
    }
    
    public void incluirMensajeAdvertencia( Map<String, Object > modelMap, String titulo, String mensaje, int id_objeto){
        incluirMensaje( modelMap, Auditor.WARNING, titulo, mensaje, id_objeto);
    }
    
    public void incluirMensajeInfo( Map<String, Object > modelMap, String titulo, String mensaje, int id_objeto){
        incluirMensaje( modelMap, Auditor.INFO, titulo, mensaje, id_objeto);
    }    
    
    public void incluirMensajeExito( Map<String, Object > modelMap, String titulo, String mensaje){
        incluirMensaje( modelMap, Auditor.SUCCESS, titulo, mensaje);
    }
    
    public void incluirMensajeError( Map<String, Object > modelMap, String titulo, String mensaje){
        incluirMensaje( modelMap, Auditor.ERROR, titulo, mensaje);
    }
    
    public void incluirMensajeAdvertencia( Map<String, Object > modelMap, String titulo, String mensaje){
        incluirMensaje( modelMap, Auditor.WARNING, titulo, mensaje);
    }
    
    public void incluirMensajeInfo( Map<String, Object > modelMap, String titulo, String mensaje){
        incluirMensaje( modelMap, Auditor.INFO, titulo, mensaje);
    }
    
    public void incluirMensajeExito( Map<String, Object > modelMap, String titulo){
        incluirMensaje( modelMap, Auditor.SUCCESS, titulo);
    }
    
    public void incluirMensajeError( Map<String, Object > modelMap, String titulo){
        incluirMensaje( modelMap, Auditor.ERROR, titulo);
    }
    
    public void incluirMensajeAdvertencia( Map<String, Object > modelMap, String titulo){
        incluirMensaje( modelMap, Auditor.WARNING, titulo);
    }
    
    public void incluirMensajeInfo( Map<String, Object > modelMap, String titulo){
        incluirMensaje( modelMap, Auditor.INFO, titulo);
    }
    
}
