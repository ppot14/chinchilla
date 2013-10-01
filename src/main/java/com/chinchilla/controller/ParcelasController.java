package com.chinchilla.controller;

import com.chinchilla.form.LaborForm;
import com.chinchilla.persistence.objects.Coordenada;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.TipoLabor;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pepe
 */
@Controller("parcelasController")
@RequestMapping("/parcelas")
//@SessionAttributes({"parcelas_json","coordenadas_json"})
public class ParcelasController extends AbstractController{

    private static Logger log = (Logger) LoggerFactory.getLogger(ParcelasController.class);
    
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

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("coordenadas", coordenadas);
        
        model.addAllAttributes(modelMap);

        log.info("Received request to show ParcelasController mapa: parcelas-mapa");

        return "parcelas-mapa";
    }
    
     @RequestMapping(value = "/mapa/form/labor.html",params = {"id"}, method=RequestMethod.GET)
    public ModelAndView mapaFormLabor(@RequestParam(value = "id") Integer id_parcela) throws Exception {
         
         Parcela parcela = parcelaDAO.get(id_parcela);
         
         List<TipoLabor> tipoLabores = tipoLaborDAO.getAll();
         
         Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
         
         modelMap.put("parcela", parcela);
         
         modelMap.put("tipoLabores", tipoLabores);
         
        log.info("parcela "+parcela);
         
        log.info("tipoLabores "+tipoLabores);

        log.info("Received request to show ParcelasController mapa: parcelas-mapa-form-labor");
         
        return new ModelAndView("parcelas-mapa-form-labor", modelMap);
         
     }
     
     @RequestMapping(value = "/mapa/form/insertar/labor.html",params = {"id"}, method=RequestMethod.POST)
    public ModelAndView mapaFormInsertarLabor(
		@ModelAttribute("LaborForm") LaborForm laborForm ) throws Exception {
         
         
         
         Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        log.info("Received request to insert/modify ParcelasController mapa: parcelas-mapa-form-labor");
         
        return new ModelAndView("parcelas-mapa", modelMap);
         
     }
}
