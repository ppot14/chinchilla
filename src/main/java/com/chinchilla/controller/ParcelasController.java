package com.chinchilla.controller;

import com.chinchilla.form.LaborForm;
import com.chinchilla.form.ProduccionForm;
import com.chinchilla.persistence.objects.Coordenada;
import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Cultivo;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.Produccion;
import com.chinchilla.persistence.objects.Producto;
import com.chinchilla.service.LaborService;
import com.chinchilla.service.ProduccionService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Pepe
 */
@Controller("parcelasController")
@RequestMapping("/parcelas")
//@SessionAttributes({"labor"})
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

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("coordenadas", coordenadas);
        
        model.addAllAttributes(modelMap);

        return "parcelas-mapa";
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        mapa(model);

        return "parcelas-tabla";
    }
    
    @RequestMapping(value = "/mapa/labores/tabla.html",params = {"id"}, method=RequestMethod.GET)
    public String mapaLaboresTabla(@RequestParam(value = "id") Integer id_parcela, Model model) throws Exception {
        
        mapa(model);
        
        List<Labor> labores = laborDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labores", labores);
        
        List<Parcela> parcelas = (List<Parcela>) modelMap.get("parcelas");
       
        log.info("parcelas: " + parcelas);
        
        Map<String,Object> aoAdvancedFilter = new HashMap<String,Object>();
        
        //TODO
        ApplicationContext context = new ClassPathXmlApplicationContext("**/spring-servlet.xml");
 
        Locale locale = LocaleContextHolder.getLocale();
        
	String column = context.getMessage("parcela", null, locale);
        
        if(column!=null && !"".equals(column) && parcelas!=null){
            
            for (Parcela temp : parcelas){
                if(temp.getId_parcela() == id_parcela){
                    aoAdvancedFilter.put("sTitle", column);
                    Map<String,String> oOperation = new HashMap<String,String>();
                    oOperation.put("sOperation", "equal");
                    oOperation.put("sValue1", temp.getNombre());
                    List<Map<String,String>> aoOperations = new ArrayList<Map<String,String>>();
                    aoOperations.add(oOperation);
                    aoAdvancedFilter.put("aoOperations", aoOperations);
                    break;
                }
            }

            modelMap.put("aoAdvancedFilter", aoAdvancedFilter);
        
        }
        
        model.addAllAttributes(modelMap);
        
        return "parcelas-tabla-labores";
    }
    
    @RequestMapping(value = "/mapa/producciones/tabla.html",params = {"id"}, method=RequestMethod.GET)
    public String mapaProduccionesTabla(@RequestParam(value = "id") Integer id_parcela, Model model) throws Exception {
        
        mapa(model);

        List<Produccion> producciones = produccionDAO.getAll();

        List<Cultivo> cultivos = cultivoDAO.getAll();

        List<Parcela> parcelas = parcelaDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("producciones", producciones);
        modelMap.put("cultivos", cultivos);
        modelMap.put("parcelas", parcelas);
        
        model.addAllAttributes(modelMap);
        
        return "parcelas-tabla-producciones";
        
    }
    
    @RequestMapping(value = "/mapa/form/labor.html",params = {"id"}, method=RequestMethod.GET)
    public String mapaFormLabor(@RequestParam(value = "id") Integer id_parcela, Model model) throws Exception {
        
        mapa(model);        
        
        LaborForm labor = new LaborForm();
        
        labor.setId_parcelas(new ArrayList<Integer>());
        
        labor.getId_parcelas().add(id_parcela);

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        
        List<Maquinaria> maquinaria = maquinariaDAO.getAll();
        
        List<Producto> productos = productoDAO.getAll();
        
        List<CostePersonal> costesPersonal = costePersonalDAO.getAll();

        modelMap.put("maquinaria", maquinaria);

        modelMap.put("productos", productos);
        
        modelMap.put("costesPersonal", costesPersonal);

        modelMap.put("labor", labor);
        
        model.addAllAttributes(modelMap);
         
        return "parcelas-mapa-form-labor";
         
     }
    
    @RequestMapping(value = "/mapa/form/produccion.html",params = {"id"}, method=RequestMethod.GET)
    public String mapaFormProduccion(@RequestParam(value = "id") Integer id_parcela, Model model) throws Exception {  
        
        mapa(model);     

        ProduccionForm produccion = new ProduccionForm();
        
        produccion.setId_parcela(id_parcela);

        List<Cultivo> cultivos = cultivoDAO.getAll();

        List<Parcela> parcelas = parcelaDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        modelMap.put("produccion", produccion);
        modelMap.put("cultivos", cultivos);
        modelMap.put("parcelas", parcelas);
        
        model.addAllAttributes(modelMap);  
        
        return "parcelas-mapa-form-produccion";
    }
     
     @RequestMapping(value = "/mapa/form/procesar/labor.html", method=RequestMethod.POST)
    public String mapaFormProcesarLabor(
            @ModelAttribute("labor") LaborForm model_labor,
           BindingResult result,
           SessionStatus status,
           Model model,
           HttpServletRequest request) throws Exception {
        
        long startTime = System.currentTimeMillis();
        
        mapa(model);
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        boolean success = LaborService.insertaModificarEliminarLabor(laborDAO, model_labor, modelMap);

        model.addAllAttributes(modelMap);
       
        long endTime = System.currentTimeMillis();
       
        log.info(getClass()+".mapaFormProcesarLabor execution time: " + (endTime-startTime) + "ms");

        return "parcelas-mapa";
         
     }
    
    @RequestMapping(value = "/mapa/form/procesar/produccion.html", method=RequestMethod.POST)
    public String mapaFormProcesarProduccion(
            @ModelAttribute("produccion") ProduccionForm model_produccion,
           BindingResult result,
           SessionStatus status,
           Model model,
           HttpServletRequest request) throws Exception {
        
        mapa(model);
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        boolean success = ProduccionService.insertaModificarEliminarProduccion(produccionDAO, model_produccion, modelMap);

        model.addAllAttributes(modelMap);

        return "parcelas-mapa";
        
    }
}
