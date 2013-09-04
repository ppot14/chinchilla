package com.chinchilla.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pepe
 */
@Controller("laboresController")
@RequestMapping("/labores")
public class LaboresController{
    
    private static Logger log = (Logger) LoggerFactory.getLogger(LaboresController.class);

	@RequestMapping("/tabla.html")
    public ModelAndView tabla(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
         log.info("Received request to show LaboresController tabla: labores-tabla");
        return new ModelAndView("labores-tabla");
    }

}
