package com.chinchilla.controller;

import com.chinchilla.persistence.objects.Meteorologia;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pepe
 */
@Controller("meteorologiaController")
@RequestMapping("/meteorologia")
public class MeteorologiaController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(MeteorologiaController.class);
        
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return calendario(model); 
    }
    
    @RequestMapping("/calendario.html")
    public String calendario(Model model) throws Exception {
        
        long startTime = System.currentTimeMillis();

        List<Meteorologia> meteo = meteorologiaDAO.getAll();
        
        Collections.sort(meteo);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("meteo", meteo);
        
        model.addAllAttributes(modelMap);
       
        long endTime = System.currentTimeMillis();
       
        log.info(getClass()+".calendario execution time: " + (endTime-startTime) + "ms");

        return "meteorologia-calendario";
    }
    
}
