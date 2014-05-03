package com.chinchilla.controller;

import com.chinchilla.persistence.objects.Producto;
import com.chinchilla.component.Notificador;
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
@Controller("productosController")
@RequestMapping("/productos")
@SessionAttributes({"producto"})
public class ProductosController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(ProductosController.class);
        
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return tabla(model); 
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {
        
       List<Producto> productos = productoDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("productos", productos);
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show ProductoesController tabla: productos-tabla");

        return "productos-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/producto.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormProducto(@RequestParam(value = "id") Integer id_producto, Model model) throws Exception {

        Producto producto = null;
        
        if(id_producto.intValue()>0){
        
            producto = productoDAO.get(id_producto);
        
        }else{
        
            producto = new Producto();
        
        }
        
        log.info("producto "+producto);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("producto", producto);
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show tablaFormInsertarProducto form: productos-tabla-form-producto");
        
        return "productos-tabla-form-producto";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/producto.html",method = RequestMethod.POST)
   public String tablaFormProcesarProducto(
            @ ModelAttribute("model_producto") Producto model_producto, 
            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar, Model model) throws Exception {
        
        log.info(""+model_producto);
        
        String tipoOperacion = insertar_modificar_eliminar;
        
        Producto producto = model_producto;
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = productoDAO.create(producto);
            
            if(created==1){
        
                notificador.incluirMensaje(modelMap, "success", "Producción añadida correctamente");
                
            }else{
        
                notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo producto");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = productoDAO.update(producto);
            
            if(updated==1){
        
                notificador.incluirMensaje(modelMap, "success", "Producción modificada correctamente");
                
            }else{
        
                notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando producto");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = productoDAO.delete(producto.getId_producto());
            
            if(deleted==1){
        
                notificador.incluirMensaje(modelMap, "success", "Producción eliminada correctamente");
                
            }else{
        
                notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando producto");
                
            }
            
        }else{
            
             notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<Producto> productos = productoDAO.getAll();

            modelMap.put("productos", productos);
        
        }
        
        model.addAllAttributes(modelMap);
        
        log.info("Received request to show tablaFormProcesarProducto: productos-tabla");

        return "productos-tabla";
    }
}
