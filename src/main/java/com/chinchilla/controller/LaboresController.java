package com.chinchilla.controller;

import com.chinchilla.form.LaborForm;
import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.LaborMaquinaria;
import com.chinchilla.persistence.objects.LaborParcela;
import com.chinchilla.persistence.objects.LaborPersonal;
import com.chinchilla.persistence.objects.LaborProducto;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.Producto;
import com.chinchilla.util.Notificador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

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

        modelMap.put("labores", labores);
        
        model.addAllAttributes(modelMap);
        
        return "labores-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/labor.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormLabor(@RequestParam(value = "id") Integer id_labor, Model model) throws Exception {

        LaborForm labor = null;
        
        if(id_labor.intValue()>0){
        
            labor = (LaborForm)laborDAO.get(id_labor);
            
            labor.setUpListIds();
        
        }else{
        
            labor = new LaborForm();
        
        }
        
        log.info("labor "+labor);

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Maquinaria> maquinaria = maquinariaDAO.getAll();
        
        List<Producto> productos = productoDAO.getAll();
        
        List<CostePersonal> costesPersonal = costePersonalDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labor", labor);

        modelMap.put("parcelas", parcelas);

        modelMap.put("maquinaria", maquinaria);

        modelMap.put("productos", productos);
        
        modelMap.put("costesPersonal", costesPersonal);
        
        model.addAllAttributes(modelMap);
        
        return "labores-tabla-form-labor";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/labor.html",method = RequestMethod.POST)
   public String tablaFormProcesarLabor(
            @ModelAttribute("labor") LaborForm model_labor,
           BindingResult result,
           SessionStatus status,
           Model model) throws Exception {
        
        log.info(""+model_labor);
        
        String tipoOperacion = model_labor.getInsertar_modificar_eliminar();
        
        Labor labor = new Labor(model_labor);
        
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

}
