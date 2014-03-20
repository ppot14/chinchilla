package com.chinchilla.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

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
    public String portal(Model model, BindingResult result, SessionStatus status) throws Throwable {
        
        if(true==true)
            throw new Throwable("BOOOOOMMMMMMMM!!!!!!!!!!!!!!!!!");
        
        return "portal";
    }
    
    // Error page
    @ExceptionHandler(Throwable.class)
    public String error(HttpServletRequest request, Throwable throwable, Model model) {
        
        model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
        Throwable temp = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String errorMessage = null;
        if (throwable != null) {
            errorMessage = temp.getMessage();
        }
        model.addAttribute("errorMessage", errorMessage);
        
        return "error";
    }

}
