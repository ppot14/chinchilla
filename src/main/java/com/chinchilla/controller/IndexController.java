package com.chinchilla.controller;

import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.component.Auditor;
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

        List<Labor> labores = laborDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labores", labores);
        
        model.addAllAttributes(modelMap);
        
//        if(true==true) throw new NullPointerException("BOOOMMMMM!!!!!");
        
        return "portal";
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
