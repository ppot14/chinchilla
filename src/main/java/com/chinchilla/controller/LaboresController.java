package com.chinchilla.controller;

import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.Parcela;
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

/**
 *
 * @author Pepe
 */
@Controller("laboresController")
@RequestMapping("/labores")
//@SessionAttributes({"tiposLaboresMaquinaria"})
public class LaboresController extends AbstractController{
    
    private static Logger log = (Logger) LoggerFactory.getLogger(LaboresController.class);
     
    
    /*
     * Labores
     */
    @RequestMapping("/")
    public String index(Model model) throws Exception {
        return tabla(model);
    }
     
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        List<Labor> labores = laborDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        
        log.info("labores "+labores);

        modelMap.put("labores", labores);
        
        model.addAllAttributes(modelMap);
        
        return "labores-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/labor.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormLabor(@RequestParam(value = "id") Integer id_labor, Model model) throws Exception {

        Labor labor = null;
        
        if(id_labor.intValue()>0){
        
            labor = laborDAO.get(id_labor);
        
        }else{
        
            labor = new Labor();
        
        }
        
        log.info("labor "+labor);

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<CostePersonal> costesPersonal = costePersonalDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labor", labor);

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("costesPersonal", costesPersonal);
        
        model.addAllAttributes(modelMap);
        
        return "labores-tabla-form-labor";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/labor.html",method = RequestMethod.POST)
   public String tablaFormProcesarLabor(
            @ModelAttribute("model_labor") Labor model_labor,
            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar, 
            Model model) throws Exception {
        
        log.info(""+model_labor);
        
        log.info("tipoOperacion = "+insertar_modificar_eliminar);
        
        String tipoOperacion = insertar_modificar_eliminar;
        
        Labor labor = model_labor;
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
//            created = laborDAO.create(labor);
            
            if(created==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Labor añadida correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo Labor");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
//            updated = laborDAO.update(labor);
            
            if(updated==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Labor modificada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando Labor");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
//            deleted = laborDAO.delete(labor.getId_labor());
            
            if(deleted==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Labor eliminado correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando Labor");
                
            }
            
        }else{
            
             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<Labor> labores = laborDAO.getAll();

            modelMap.put("labores", labores);
        
        }
        
        model.addAllAttributes(modelMap);

        return "labores-tabla";
    }
    
//    /*
//     * Tipos Labores
//     */
//    @RequestMapping("/tipos/tabla.html")
//    public String tiposTabla(Model model) throws Exception {
//
//        List<TipoLabor> tiposLabores = tipoLaborDAO.getAll();
//
//        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
//        
//        log.info("tiposLabores "+tiposLabores);
//
//        modelMap.put("tiposLabores", tiposLabores);
//        
//        model.addAllAttributes(modelMap);
//
//        return "tipos-labores-tabla";
//    }
//    
//    @RequestMapping(value = "/tipos/tabla/form/tipoLabor.html",params = {"id"}, method=RequestMethod.GET)
//    public String tiposTablaFormTipoLabor(@RequestParam(value = "id") Integer id_tipo_labor, Model model) throws Exception {
//
//        TipoLabor tipoLabor = null;
//        
//        if(id_tipo_labor.intValue()>0){
//        
//            tipoLabor = tipoLaborDAO.get(id_tipo_labor);
//        
//        }else{
//        
//            tipoLabor = new TipoLabor();
//        
//        }
//        
//        log.info("tipoLabor "+tipoLabor);
//
//        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
//
//        modelMap.put("tipoLabor", tipoLabor);
//        
//        model.addAllAttributes(modelMap);
//        
//        return "tipos-labores-tabla-form-tipoLabor";
//    }
//    
//    @RequestMapping(value = "/tipos/tabla/form/procesar/tipoLabor.html",method = RequestMethod.POST)
//   public String tiposTablaFormProcesarTipoLabor(
//            @ModelAttribute("model_tipoLabor") TipoLabor model_tipoLabor,
//            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar, 
//            Model model) throws Exception {
//        
//        log.info(""+model_tipoLabor);
//        
//        log.info("tipoOperacion = "+insertar_modificar_eliminar);
//        
//        String tipoOperacion = insertar_modificar_eliminar;
//        
//        TipoLabor tipoLabor = model_tipoLabor;
//        
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        
//        int created = 0;
//        
//        int updated = 0;
//        
//        int deleted = 0;
//        
//        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
//            
//            created = tipoLaborDAO.create(tipoLabor);
//            
//            if(created==1){
//        
//                Notificador.incluirMensaje(modelMap, "success", "TipoLabor añadida correctamente");
//                
//            }else{
//        
//                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo tipoLabor");
//                
//            }
//            
//        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
//            
//            updated = tipoLaborDAO.update(tipoLabor);
//            
//            if(updated==1){
//        
//                Notificador.incluirMensaje(modelMap, "success", "TipoLabor modificada correctamente");
//                
//            }else{
//        
//                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando tipoLabor");
//                
//            }
//            
//        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
//            
//            deleted = tipoLaborDAO.delete(tipoLabor.getId_tipo_labor());
//            
//            if(deleted==1){
//        
//                Notificador.incluirMensaje(modelMap, "success", "TipoLabor eliminado correctamente");
//                
//            }else{
//        
//                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando tipoLabor");
//                
//            }
//            
//        }else{
//            
//             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
//                     "Ninguna accion sera realizada");
//            
//        }
//        
//        if(created>0 || updated>0 || deleted>0){
//
//            List<TipoLabor> tiposLabores = tipoLaborDAO.getAll();
//
//            modelMap.put("tiposLabores", tiposLabores);
//        
//        }
//        
//        model.addAllAttributes(modelMap);
//
//        return "tipos-labores-tabla";
//    }

}
