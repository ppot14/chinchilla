package com.chinchilla.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pepe
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController{

private static Logger log = (Logger) LoggerFactory.getLogger(IndexController.class);
	
    //@RequestMapping("/index.html")
    @RequestMapping(method=RequestMethod.GET)
    public String index(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
         log.info("Received request to show IndexController index: parcelas-mapa");
        return "inicio";
    }

}
