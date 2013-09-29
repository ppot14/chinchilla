package com.chinchilla.controller;

import com.chinchilla.persistence.objects.CostePersonal;
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
@Controller("personalController")
@RequestMapping("/personal")
@SessionAttributes({"costePersonal"})
public class PersonalController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(PersonalController.class);
    
        
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return tabla(model); 
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {
        
        return tablaCostes(model); 
    }
    
    @RequestMapping("/costes/tabla.html")
    public String tablaCostes(Model model) throws Exception {

        List<CostePersonal> costesPersonal = costePersonalDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("costesPersonal", costesPersonal);
        
        model.addAllAttributes(modelMap);

        return "coste-personal-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/costePersonal.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormCostePersonal(@RequestParam(value = "id") Integer id_coste_personal, Model model) throws Exception {

        CostePersonal costePersonal = null;
        
        if(id_coste_personal.intValue()>0){
        
            costePersonal = costePersonalDAO.get(id_coste_personal);
        
        }else{
        
            costePersonal = new CostePersonal();
        
        }
        
        log.info("costePersonal "+costePersonal);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("costePersonal", costePersonal);
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show tablaFormInsertarCostePersonal form: costePersonal-tabla-form-costePersonal");
        
        return "personal-tabla-form-coste-personal";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/costePersonal.html",method = RequestMethod.POST)
   public String tablaFormProcesarCostePersonal(
            @ModelAttribute("costePersonal_form") CostePersonal costePersonal_form, 
            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar,
            Model model) throws Exception {
        
        log.info(""+costePersonal_form);
        
        String tipoOperacion = insertar_modificar_eliminar;
        
        CostePersonal costePersonal = costePersonal_form;
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = costePersonalDAO.create(costePersonal);
            
            if(created==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción añadida correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo costePersonal");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = costePersonalDAO.update(costePersonal);
            
            if(updated==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción modificada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando costePersonal");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = costePersonalDAO.delete(costePersonal.getId_coste_personal());
            
            if(deleted==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción eliminada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando costePersonal");
                
            }
            
        }else{
            
             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<CostePersonal> costesPersonal = costePersonalDAO.getAll();

            modelMap.put("costesPersonal", costesPersonal);
        
        }
        
        model.addAllAttributes(modelMap);
        
        log.info("Received request to show tablaFormProcesarCostePersonal: costePersonal-tabla");

        return "coste-personal-tabla";
    }
}
