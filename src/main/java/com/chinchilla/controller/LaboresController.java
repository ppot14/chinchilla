package com.chinchilla.controller;

import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.TipoLabor;
import com.chinchilla.persistence.objects.TipoLaborMaquinaria;
import com.chinchilla.util.Notificador;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pepe
 */
@Controller("laboresController")
@RequestMapping("/labores")
//@SessionAttributes({"tiposLaboresMaquinaria"})
public class LaboresController extends AbstractController{
    
    private static Logger log = (Logger) LoggerFactory.getLogger(LaboresController.class);
     
    @RequestMapping("/")
    public String index(Model model) throws Exception {
        return tabla(model);
    }
     
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        List<Labor> labores = laborDAO.getAll();

        List<TipoLabor> tiposLabores = tipoLaborDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        
        log.info("labores "+labores);

        modelMap.put("labores", labores);
        
        log.info("tiposLabores "+tiposLabores);

        modelMap.put("tiposLabores", tiposLabores);
        
        model.addAllAttributes(modelMap);
        
        return "labores-tabla";
    }
    
    @RequestMapping("/tipos/tabla.html")
    public String tiposTabla(Model model) throws Exception {

        List<TipoLabor> tiposLabores = tipoLaborDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        
        log.info("tiposLabores "+tiposLabores);

        modelMap.put("tiposLabores", tiposLabores);
        
        model.addAllAttributes(modelMap);

        return "tipos-labores-tabla";
    }
    
    @RequestMapping(value = "/tipos/tabla/form/tipoLabor.html",params = {"id"}, method=RequestMethod.GET)
    public String tiposTablaFormProduccion(@RequestParam(value = "id") Integer id_tipo_labor, Model model) throws Exception {

        TipoLabor tipoLabor = null;
        
        if(id_tipo_labor.intValue()>0){
        
            tipoLabor = tipoLaborDAO.get(id_tipo_labor);
        
        }else{
        
            tipoLabor = new TipoLabor();
        
        }
        
        log.info("tipoLabor "+tipoLabor);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("tipoLabor", tipoLabor);
        
        model.addAllAttributes(modelMap);
        
        return "tipos-labores-tabla-form-tipoLabor";
    }
    
    @RequestMapping(value = "/tipos/tabla/form/procesar/tipoLabor.html",method = RequestMethod.POST)
   public String tiposTablaFormProcesarTipoLabor(
            @ModelAttribute("model_tipoLabor") TipoLabor model_tipoLabor,
            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar, 
            Model model) throws Exception {
        
        log.info(""+model_tipoLabor);
        
        log.info("tipoOperacion = "+insertar_modificar_eliminar);
        
        String tipoOperacion = insertar_modificar_eliminar;
        
        TipoLabor tipoLabor = model_tipoLabor;
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = tipoLaborDAO.create(tipoLabor);
            
            if(created==1){
        
                Notificador.incluirMensaje(modelMap, "success", "TipoLabor añadida correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo tipoLabor");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = tipoLaborDAO.update(tipoLabor);
            
            if(updated==1){
        
                Notificador.incluirMensaje(modelMap, "success", "TipoLabor modificada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando tipoLabor");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = tipoLaborDAO.delete(tipoLabor.getId_tipo_labor());
            
            if(deleted==1){
        
                Notificador.incluirMensaje(modelMap, "success", "TipoLabor eliminado correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando tipoLabor");
                
            }
            
        }else{
            
             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<TipoLabor> tiposLabores = tipoLaborDAO.getAll();

            modelMap.put("tiposLabores", tiposLabores);
        
        }
        
        model.addAllAttributes(modelMap);

        return "tipos-labores-tabla";
    }

}
