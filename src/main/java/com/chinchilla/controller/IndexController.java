package com.chinchilla.controller;

import com.chinchilla.persistence.objects.Labor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pepe
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(IndexController.class);
	
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
        
        return "portal";
    }
    
    // Error page
    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception exception, HttpServletRequest request) {
        
        Map<String,Object> model =  new HashMap<String,Object>();
        
        model.put("errorCode", 500 );
        model.put("errorMessage", exception.getMessage());
        
        ModelAndView modelView = new ModelAndView("error", model); 
        
        return modelView;
    }

}
