package com.chinchilla.controller;

import com.chinchilla.persistence.objects.OrdenCompra;
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
@Controller("ordenCompraController")
@RequestMapping("/registros")
@SessionAttributes({"registro"})
public class OrdenCompraController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(OrdenCompraController.class);
        
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return tabla(model); 
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {
        
       List<OrdenCompra> ordenesCompra = ordenCompraDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("ordenesCompra", ordenesCompra);
        
        model.addAllAttributes(modelMap);

        return "ordenes-compra-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/registro.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormProducto(@RequestParam(value = "id") Integer id_orden_compra, Model model) throws Exception {

        OrdenCompra ordenCompra = null;
        
        if(id_orden_compra.intValue()>0){
        
            ordenCompra = ordenCompraDAO.get(id_orden_compra);
        
        }else{
        
            ordenCompra = new OrdenCompra();
        
        }
        
        log.info("registro "+ordenCompra);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("registro", ordenCompra);
        
        model.addAllAttributes(modelMap);
        
        return "ordenes-compra-tabla-form-orden-compra";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/ordenCompra.html",method = RequestMethod.POST)
   public String tablaFormProcesarProducto(
            @ModelAttribute("model_ordenCompra") OrdenCompra model_ordenCompra, 
            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar, Model model) throws Exception {
        
        log.info(""+model_ordenCompra);
        
        String tipoOperacion = insertar_modificar_eliminar;
        
        OrdenCompra ordenCompra = model_ordenCompra;
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = ordenCompraDAO.create(ordenCompra);
            
            if(created==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción añadida correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo ordenCompra");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = ordenCompraDAO.update(ordenCompra);
            
            if(updated==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción modificada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando ordenCompra");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = ordenCompraDAO.delete(ordenCompra.getId_orden_compra());
            
            if(deleted==1){
        
                Notificador.incluirMensaje(modelMap, "success", "Producción eliminada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando ordenCompra");
                
            }
            
        }else{
            
             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<OrdenCompra> ordenCompras = ordenCompraDAO.getAll();

            modelMap.put("ordenCompras", ordenCompras);
        
        }
        
        model.addAllAttributes(modelMap);
        
        log.info("Received request to show tablaFormProcesarProducto: ordenCompras-tabla");

        return "ordenCompras-tabla";
    }
}
