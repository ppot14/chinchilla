package com.chinchilla.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Pepe
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController extends AbstractController{

private static Logger log = (Logger) LoggerFactory.getLogger(IndexController.class);
	
    //@RequestMapping("/index.html")
    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
        
         String ret = null;
         
         //ret = new ParcelasController().mapa(model);
         
         return ret!=null && !ret.equals("") ? ret : "inicio";
    }

}
