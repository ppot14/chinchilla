package com.chinchilla.controller;

import com.chinchilla.persistence.dao.CultivoDAO;
import com.chinchilla.persistence.dao.ParcelaDAO;
import com.chinchilla.persistence.dao.ProduccionDAO;
import com.chinchilla.persistence.objects.Cultivo;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.Produccion;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pepe
 */
@Controller("produccionesController")
@RequestMapping("/producciones")
public class ProduccionesController{

    private static Logger log = (Logger) LoggerFactory.getLogger(ProduccionesController.class);

    @Autowired
    @Qualifier("produccionDAO")
    private ProduccionDAO produccionDAO;   
    
    @Autowired
    @Qualifier("cultivoDAO")
    private CultivoDAO cultivoDAO;  
    
    @Autowired
    @Qualifier("parcelaDAO")
    private ParcelaDAO parcelaDAO;          
        
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        return tabla(hsr, hsr1); 
    }
    
    @RequestMapping("/tabla.html")
    public ModelAndView tabla(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        List<Produccion> producciones = produccionDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("producciones", producciones);

        log.info("Received request to show ProduccionesController tabla: producciones-tabla");

        return new ModelAndView("content/tabla-producciones", modelMap);
    }
    
    @RequestMapping("/tabla/form/insertar/produccion.html")
    public ModelAndView tablaFormInsertarProduccion(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        Produccion produccion = new Produccion();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("produccion", produccion);

        log.info("Received request to show tablaFormInsertarProduccion form: producciones-tabla-form-insertar-produccion");
        
        return new ModelAndView("right/form-insertar-produccion");
    }
    
    @RequestMapping(value = "/tabla/form/insertar/produccion.html",params = {"id"})
    public ModelAndView tablaFormInsertarProduccion(@RequestParam(value = "id") String id_produccion,HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        log.info("Received request to show tablaFormInsertarProduccion form: redirect to tablaFormModificarProduccion");
        
        return tablaFormModificarProduccion(id_produccion, hsr, hsr1);
    }
    
//    @RequestMapping(value = "/tabla/form/modificar/produccion.html",params = {"id"}, method=RequestMethod.GET)
//    public void tablaFormModificarProduccion() {}
    
    @RequestMapping(value = "/tabla/form/modificar/produccion.html",params = {"id"}, method=RequestMethod.GET)
    public ModelAndView tablaFormModificarProduccion(@RequestParam(value = "id") String id_produccion,HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        log.info("Received request to show tablaFormModificarProduccion form");

        List<Produccion> producciones = produccionDAO.getAll();
        
        List<Cultivo> cultivos = cultivoDAO.getAll();
        
        List<Parcela> parcelas = parcelaDAO.getAll();
        
        Produccion produccion = produccionDAO.get(Integer.parseInt(id_produccion));

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("cultivos", cultivos);
        
        modelMap.put("producciones", producciones);

        modelMap.put("produccion", produccion);

        log.info("Response to producciones-tabla-form-modificar-produccion");
        
        return new ModelAndView("right/form-insertar-produccion", modelMap);
    }
    
    @RequestMapping(value = "/tabla/form/procesar/produccion.html",method = RequestMethod.POST)
   public ModelAndView tablaFormProcesarProduccion(HttpServletRequest hsr, HttpServletResponse hsr1, 
   @ ModelAttribute("model_produccion") 
            Produccion model_produccion) throws Exception {
        
        int created = produccionDAO.create(model_produccion);
        
        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        
        Map<String, Object > notificacion = new HashMap<String,Object>();

        notificacion.put("FECHA", new Date());
        
        if(created==1){
        
            notificacion.put("TIPO", "INFO");

            notificacion.put("MENSAJE", "Producción creada con exito");
            
        }else{
            
            notificacion.put("TIPO", "ERROR");

            notificacion.put("MENSAJE", "Error al crear producción");
            
        }

        modelMap.put("notificacion", notificacion);
        
        log.info("Received request to show tablaFormProcesarProduccion: producciones-tabla");

        return new ModelAndView("content/tabla-producciones", modelMap);
    }
}
