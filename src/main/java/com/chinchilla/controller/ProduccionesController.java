package com.chinchilla.controller;

import com.chinchilla.form.ProduccionForm;
import com.chinchilla.persistence.objects.Cultivo;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.Produccion;
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
@Controller("produccionesController")
@RequestMapping("/producciones")
@SessionAttributes({"produccion"})
public class ProduccionesController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(ProduccionesController.class);
        
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return tabla(model); 
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        List<Produccion> producciones = produccionDAO.getAll();

        List<Cultivo> cultivos = cultivoDAO.getAll();

        List<Parcela> parcelas = parcelaDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("producciones", producciones);
        modelMap.put("cultivos", cultivos);
        modelMap.put("parcelas", parcelas);
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show ProduccionesController tabla: producciones-tabla");

        return "producciones-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/produccion.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormProduccion(@RequestParam(value = "id") Integer id_produccion, Model model) throws Exception {

        Produccion produccion = null;
        
        if(id_produccion.intValue()>0){
        
            produccion = produccionDAO.get(id_produccion);
        
        }else{
        
            produccion = new Produccion();
        
        }
        
        log.info("produccion "+produccion);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("produccion", produccion);
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show tablaFormInsertarProduccion form: producciones-tabla-form-produccion");
        
        return "producciones-tabla-form-produccion";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/produccion.html",method = RequestMethod.POST)
   public String tablaFormProcesarProduccion(
            @ ModelAttribute("model_produccion") ProduccionForm model_produccion, Model model) throws Exception {
        
        log.info(""+model_produccion);
        
        String tipoOperacion = model_produccion.getInsertar_modificar_eliminar();
        
        Produccion produccion = new Produccion((Produccion)model_produccion);
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = produccionDAO.create(produccion);
            
            if(created==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción añadida correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo produccion");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = produccionDAO.update(produccion);
            
            if(updated==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción modificada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando produccion");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = produccionDAO.delete(produccion.getId_produccion());
            
            if(deleted==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción eliminada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando produccion");
                
            }
            
        }else{
            
             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<Produccion> producciones = produccionDAO.getAll();

            modelMap.put("producciones", producciones);
        
        }
        
        model.addAllAttributes(modelMap);
        
        log.info("Received request to show tablaFormProcesarProduccion: producciones-tabla");

        return "producciones-tabla";
    }
}
