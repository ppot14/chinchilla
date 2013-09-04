package com.chinchilla.controller;

import com.chinchilla.persistence.dao.CoordenadaDAO;
import com.chinchilla.persistence.dao.ParcelaDAO;
import com.chinchilla.persistence.objects.Coordenada;
import com.chinchilla.persistence.objects.Parcela;
import com.google.gson.Gson;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pepe
 */
@Controller("parcelasController")
@RequestMapping("/parcelas")
public class ParcelasController{

    private static Logger log = (Logger) LoggerFactory.getLogger(ParcelasController.class);

    @Autowired
    @Qualifier("parcelaDAO")
    private ParcelaDAO parcelaDAO;
    
    @Autowired
    @Qualifier("coordenadaDAO")
    private CoordenadaDAO coordenadaDAO;    
    
    @RequestMapping("/")
    public String index(Model model) throws Exception {

        return mapa(model); 
    }
    
    @RequestMapping("/mapa.html")
    public String mapa(Model model) throws Exception {

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Coordenada> coordenadas = coordenadaDAO.getAll();
        
        Gson gson = new Gson();  
        
        //log.info("result "+parcelas);
        
        log.info("result-gson "+gson.toJson(parcelas));
        
        log.info("result-gson "+gson.toJson(coordenadas));

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        //modelMap.put("parcelas", parcelas);

        modelMap.put("parcelas_json", gson.toJson(parcelas));
        
        modelMap.put("coordenadas_json", gson.toJson(coordenadas));
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show ParcelasController mapa: parcelas-mapa");

        return "parcelas-mapa";
    }
    
     @RequestMapping(value = "/mapa/form/insertar/labor.html",params = {"id"})
    public ModelAndView mapaFormInsertarLabor(@RequestParam(value = "id") Integer id_parcela, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
         
         Parcela parcela = parcelaDAO.get(id_parcela);
         
         Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
         
         modelMap.put("parcela-"+id_parcela, parcela);
         
        return new ModelAndView("parcelas-mapa-form-insertar-labor", modelMap);
         
     }
}
