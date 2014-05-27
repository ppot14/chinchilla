package com.chinchilla.controller;

import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.component.Auditor;
import com.chinchilla.persistence.objects.Auditoria;
import com.chinchilla.persistence.objects.Coordenada;
import com.chinchilla.persistence.objects.Meteorologia;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.Produccion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pepe
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(IndexController.class);
    
    @Autowired
    @Qualifier("auditor")
    Auditor auditor;
	
    @RequestMapping("/")
    public String index(Model model) throws Exception {
         
         return "inicio";
    }
    
    @RequestMapping("/portal.html")
    public String portal(Model model) throws Exception {
        
        long startTime = System.currentTimeMillis();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        List<Labor> labores = laborDAO.getAll();

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Coordenada> coordenadas = coordenadaDAO.getAll();

        List<Produccion> producciones = produccionDAO.getAll();

        List<Meteorologia> meteo = meteorologiaDAO.getAll();
        
        Collections.sort(meteo);

        modelMap.put("labores", labores);

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("coordenadas", coordenadas);

        modelMap.put("producciones", producciones);

        modelMap.put("meteo", meteo);
        
        model.addAllAttributes(modelMap);
       
        long endTime = System.currentTimeMillis();
       
        log.info(getClass()+".portal execution time: " + (endTime-startTime) + "ms");
        
        return "portal";
    }
    
    @RequestMapping("/configuracion.html")
    public String configuracion(Model model) throws Exception {

        List<Auditoria> auditoria = auditoriaDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("auditoria", auditoria);
        
        model.addAllAttributes(modelMap);
        
        return "configuracion";
    }
    
    // Error page
    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception exception, HttpServletRequest request) {
        
        Map<String,Object> model =  new HashMap<String,Object>();
        
        model.put("errorCode", 500 );
        model.put("errorTitle", "Error desconocido cargando la página");
        model.put("errorMessage", exception.getMessage());
        model.put("errorLog", ExceptionUtils.getStackTrace(exception));
        
        ModelAndView modelView = new ModelAndView("error", model); 
        
        auditor.incluirMensaje(model, "success", "Error desconocido cargando la página", exception.getMessage(), -1, exception);
        
        return modelView;
    }

}
