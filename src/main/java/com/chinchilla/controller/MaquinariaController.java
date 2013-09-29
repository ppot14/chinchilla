package com.chinchilla.controller;

import com.chinchilla.persistence.objects.Maquinaria;
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
@Controller("maquinariaController")
@RequestMapping("/maquinaria")
@SessionAttributes({"maquinaria_i"})
public class MaquinariaController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(MaquinariaController.class);
    
        
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return tabla(model); 
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        List<Maquinaria> maquinaria = maquinariaDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("maquinaria", maquinaria);
        
        model.addAllAttributes(modelMap);

        return "maquinaria-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/maquinaria.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormMaquinaria(@RequestParam(value = "id") Integer id_coste_maquinaria, Model model) throws Exception {

        Maquinaria maquinaria_i = null;
        
        if(id_coste_maquinaria.intValue()>0){
        
            maquinaria_i = maquinariaDAO.get(id_coste_maquinaria);
        
        }else{
        
            maquinaria_i = new Maquinaria();
        
        }
        
        log.info("maquinaria_i "+maquinaria_i);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("maquinaria_i", maquinaria_i);
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show tablaFormInsertarMaquinaria form: maquinaria-tabla-form-maquinaria");
        
        return "maquinaria-tabla-form-maquinaria";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/maquinaria.html",method = RequestMethod.POST)
   public String tablaFormProcesarMaquinaria(
            @ModelAttribute("maquinaria_form") Maquinaria maquinaria_form, 
            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar,
            Model model) throws Exception {
        
        log.info(""+maquinaria_form);
        
        String tipoOperacion = insertar_modificar_eliminar;
        
        Maquinaria maquinaria_i = maquinaria_form;
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = maquinariaDAO.create(maquinaria_i);
            
            if(created==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción añadida correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo maquinaria");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = maquinariaDAO.update(maquinaria_i);
            
            if(updated==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción modificada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando maquinaria");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = maquinariaDAO.delete(maquinaria_i.getId_coste_maquinaria());
            
            if(deleted==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción eliminada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando maquinaria");
                
            }
            
        }else{
            
             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<Maquinaria> maquinaria = maquinariaDAO.getAll();

            modelMap.put("maquinaria", maquinaria);
        
        }
        
        model.addAllAttributes(modelMap);
        
        log.info("Received request to show tablaFormProcesarMaquinaria: maquinaria-tabla");

        return "maquinaria-tabla";
    }
}
