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
package com.chinchilla.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pepe
 */
public class Notificador {
    
    public static final String SUCCESS = "success";
    
    public static final String ERROR = "error";
    
    public static final String WARNING = "warn";
    
    public static final String INFO = "info";
    
    
    
    public static void incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo){
        
        incluirMensaje(modelMap, tipo, titulo, "Sin informacion");
        
    }
    
    public static void incluirMensaje( Map<String, Object > modelMap,
            String tipo, String titulo, String mensaje){
        
        Map<String, Object > notificacion  = new HashMap<String,Object>();
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Date today = Calendar.getInstance().getTime();    

        notificacion.put("fecha", df.format(today));
        
        notificacion.put("tipo", tipo);

        notificacion.put("titulo", titulo);

        notificacion.put("mensaje", mensaje);
        
        modelMap.remove("notificacion");
        
        modelMap.put("notificacion", notificacion);
        
    }
    
    public static void incluirMensajeExito( Map<String, Object > modelMap, String titulo, String mensaje){
        incluirMensaje( modelMap, Notificador.SUCCESS, titulo, mensaje);
    }
    
    public static void incluirMensajeError( Map<String, Object > modelMap, String titulo, String mensaje){
        incluirMensaje( modelMap, Notificador.ERROR, titulo, mensaje);
    }
    
    public static void incluirMensajeAdvertencia( Map<String, Object > modelMap, String titulo, String mensaje){
        incluirMensaje( modelMap, Notificador.WARNING, titulo, mensaje);
    }
    
    public static void incluirMensajeInfo( Map<String, Object > modelMap, String titulo, String mensaje){
        incluirMensaje( modelMap, Notificador.INFO, titulo, mensaje);
    }
    
    public static void incluirMensajeExito( Map<String, Object > modelMap, String titulo){
        incluirMensaje( modelMap, Notificador.SUCCESS, titulo);
    }
    
    public static void incluirMensajeError( Map<String, Object > modelMap, String titulo){
        incluirMensaje( modelMap, Notificador.ERROR, titulo);
    }
    
    public static void incluirMensajeAdvertencia( Map<String, Object > modelMap, String titulo){
        incluirMensaje( modelMap, Notificador.WARNING, titulo);
    }
    
    public static void incluirMensajeInfo( Map<String, Object > modelMap, String titulo){
        incluirMensaje( modelMap, Notificador.INFO, titulo);
    }
    
}
