package com.chinchilla.controller;

import com.chinchilla.form.OrdenCompraForm;
import com.chinchilla.persistence.objects.OrdenCompra;
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
    public String tablaFormRegistro(@RequestParam(value = "id") Integer id_orden_compra, Model model) throws Exception {

        OrdenCompra ordenCompra = null;
        
        Map<Integer, String> elementos = new LinkedHashMap<Integer, String>();
        
        List<Producto> productos = productoDAO.getAll();
        
       List<OrdenCompra> ordenesCompra = ordenCompraDAO.getAll();
        
        //TODO incluir electricidad a elementos
        
        for(Producto p : productos){
            elementos.put(p.getId_producto(), p.getTipo()+" - "+p.getNombre());
        }
        
        if(id_orden_compra.intValue()>0){
        
            ordenCompra = ordenCompraDAO.get(id_orden_compra);
        
        }else{
        
            ordenCompra = new OrdenCompra();
        
        }

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("registro", new OrdenCompraForm(ordenCompra));
        
        modelMap.put("elementos", elementos);

        modelMap.put("ordenesCompra", ordenesCompra);
        
        model.addAllAttributes(modelMap);
        
        return "ordenes-compra-tabla-form-orden-compra";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/registro.html",method = RequestMethod.POST)
   public String tablaFormProcesarRegistro(
            @ModelAttribute("registro") OrdenCompraForm registroForm,
           BindingResult result,
           SessionStatus status,
           Model model) throws Exception {
        
        String tipoOperacion = registroForm.getInsertar_modificar_eliminar();
        
        OrdenCompra ordenCompra = new OrdenCompra(registroForm);
        
        Map<String, Object> modelMap = new HashMap<>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            created = ordenCompraDAO.create(ordenCompra);
            
            if(created==1){
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Registro añadido correctamente");
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido añadiendo registro");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            updated = ordenCompraDAO.update(ordenCompra);
            
            if(updated==1){
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Registro modificado correctamente");
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido modificando registro");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            deleted = ordenCompraDAO.delete(ordenCompra.getId_orden_compra());
            
            if(deleted==1){
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Producción eliminada correctamente");
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido eliminando ordenCompra");
                
            }
            
        }else{
            
             notificador.incluirMensaje(modelMap, Notificador.INFO, "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<OrdenCompra> ordenCompras = ordenCompraDAO.getAll();

            modelMap.put("ordenesCompra", ordenCompras);
        
        }
        
        model.addAllAttributes(modelMap);

        return "ordenes-compra-tabla";
    }
}
