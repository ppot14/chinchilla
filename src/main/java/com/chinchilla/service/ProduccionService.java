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

package com.chinchilla.service;

import com.chinchilla.component.Notificador;
import com.chinchilla.form.ProduccionForm;
import com.chinchilla.persistence.dao.ProduccionDAO;
import com.chinchilla.persistence.objects.Produccion;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pepe
 */
@Service("produccionService")
public class ProduccionService extends AbstractService{
    
    private static Logger log = (Logger) LoggerFactory.getLogger(ProduccionService.class);
    
    @Autowired
    @Qualifier("produccionDAO")
    protected ProduccionDAO produccionDAO; 
    
    public boolean insertaModificarEliminarProduccion(ProduccionForm produccionForm, Map<String, Object> modelMap){
        
        String tipoOperacion = produccionForm.getInsertar_modificar_eliminar();
        
        Produccion produccion = new Produccion(produccionForm);
        
        boolean success = false;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            if(produccionDAO.create(produccion)==1){
                
                success = true;
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Producción añadida correctamente",null);
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido añadiendo produccion",null);
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            if(produccionDAO.update(produccion)==1){
                
                success = true;
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Producción modificada correctamente",null,produccion.getId_produccion());
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido modificando produccion",null,produccion.getId_produccion());
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            if(produccionDAO.delete(produccion.getId_produccion())==1){
                
                success = true;
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Producción eliminada correctamente",null,produccion.getId_produccion());
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido eliminando produccion",null,produccion.getId_produccion());
                
            }
            
        }else{
            
             notificador.incluirMensaje(modelMap, Notificador.INFO, "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        return success;
        
    }
    
}
