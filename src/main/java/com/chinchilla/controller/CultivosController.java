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
package com.chinchilla.controller;

import com.chinchilla.persistence.objects.Cultivo;
import com.chinchilla.util.Notificador;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Pepe
 */
@Controller("cultivosController")
@RequestMapping("/cultivos")
@SessionAttributes({"cultivos"})
public class CultivosController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(CultivosController.class);
    
     
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return tabla(model); 
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        List<Cultivo> cultivos = cultivoDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        
        log.info("cultivos "+cultivos);

        modelMap.put("cultivos", cultivos);
        
        model.addAllAttributes(modelMap);

        return "cultivos-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/cultivo.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormProduccion(@RequestParam(value = "id") Integer id_cultivo, Model model) throws Exception {

        Cultivo cultivo = null;
        
        if(id_cultivo.intValue()>0){
        
            cultivo = cultivoDAO.get(id_cultivo);
        
        }else{
        
            cultivo = new Cultivo();
        
        }
        
        log.info("cultivo "+cultivo);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("cultivo", cultivo);
        
        model.addAllAttributes(modelMap);
        
        return "cultivos-tabla-form-cultivo";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/cultivo.html",method = RequestMethod.POST)
   public String tablaFormProcesarCultivo(
            @ModelAttribute("model_cultivo") Cultivo model_cultivo,
            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar, 
            Model model) throws Exception {
        
        log.info(""+model_cultivo);
        
        log.info("tipoOperacion = "+insertar_modificar_eliminar);
        
        String tipoOperacion = insertar_modificar_eliminar;
        
        Cultivo cultivo = model_cultivo;
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = cultivoDAO.create(cultivo);
            
            if(created==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Cultivo añadida correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo cultivo");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = cultivoDAO.update(cultivo);
            
            if(updated==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Cultivo modificada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando cultivo");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = cultivoDAO.delete(cultivo.getId_cultivo());
            
            if(deleted==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Cultivo eliminado correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando cultivo");
                
            }
            
        }else{
            
             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<Cultivo> cultivos = cultivoDAO.getAll();

            modelMap.put("cultivos", cultivos);
        
        }
        
        model.addAllAttributes(modelMap);

        return "cultivos-tabla";
    }
    
}
