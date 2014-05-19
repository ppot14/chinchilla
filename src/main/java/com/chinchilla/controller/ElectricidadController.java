package com.chinchilla.controller;

import com.chinchilla.component.Notificador;
import com.chinchilla.form.ElectricidadForm;
import com.chinchilla.persistence.objects.Electricidad;
import com.chinchilla.persistence.objects.Labor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Pepe
 */
@Controller("electricidadController")
@RequestMapping("/electricidad")
@SessionAttributes({"electricidad","labores"})
public class ElectricidadController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(ElectricidadController.class);
        
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return tabla(model); 
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {
        
       List<Electricidad> electricidad = electricidadDAO.getAll();

        List<Labor> labores = laborDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labores", labores);

        modelMap.put("electricidad", electricidad);
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show ElectricidadController tabla: electricidad-tabla");

        return "electricidad-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/electricidad.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormElectricidad(@RequestParam(value = "id") Integer id_electricidad, Model model) throws Exception {

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        Electricidad electricidadItem = null;
        
        if(id_electricidad>0){
        
            electricidadItem = electricidadDAO.get(id_electricidad);
        
        }else{
        
            electricidadItem = new Electricidad();
        
        }
        
        log.info("electricidadItem "+electricidadItem);

        modelMap.put("electricidadItem", electricidadItem);
        
        model.addAllAttributes(modelMap);

//        log.info("Received request to show tablaFormInsertarElectricidad form: electricidad-tabla-form-electricidad");
        
        return "electricidad-tabla-form-electricidad";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/electricidad.html",method = RequestMethod.POST)
   public String tablaFormProcesarElectricidad(
            @ModelAttribute("electricidad") ElectricidadForm model_electricidad,
           BindingResult result,
           SessionStatus status,
           Model model,
           HttpServletRequest request) throws Exception {
        
        long startTime = System.currentTimeMillis();
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        String tipoOperacion = model_electricidad.getInsertar_modificar_eliminar();
        
        Electricidad electricidadItem = new Electricidad(model_electricidad);
        
//        log.info(""+model_electricidad);
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = electricidadDAO.create(electricidadItem);
            
            if(created==1){
        
                notificador.incluirMensaje(modelMap, "success", "Electricidad añadida correctamente",null,electricidadItem.getId_electricidad());
                
            }else{
        
                notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo electricidad",null,electricidadItem.getId_electricidad());
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = electricidadDAO.update(electricidadItem);
            
            if(updated==1){
        
                notificador.incluirMensaje(modelMap, "success", "Electricidad modificada correctamente",null,electricidadItem.getId_electricidad());
                
            }else{
        
                notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando electricidad",null,electricidadItem.getId_electricidad());
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = electricidadDAO.delete(electricidadItem.getId_electricidad());
            
            if(deleted==1){
        
                notificador.incluirMensaje(modelMap, "success", "Electricidad eliminada correctamente",null,electricidadItem.getId_electricidad());
                
            }else{
        
                notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando electricidad",null,electricidadItem.getId_electricidad());
                
            }
            
        }else{
            
             notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<Electricidad> electricidad = electricidadDAO.getAll();

            List<Labor> labores = laborDAO.getAll();

            modelMap.put("labores", labores);

            modelMap.put("electricidad", electricidad);
        
        }
        
        model.addAllAttributes(modelMap);
        
//        log.info("Received request to show tablaFormProcesarElectricidad: electricidad-tabla");
       
        long endTime = System.currentTimeMillis();
       
        log.info(getClass()+".tablaFormProcesarElectricidad execution time: " + (endTime-startTime) + "ms");

        return "electricidad-tabla";
    }
}
