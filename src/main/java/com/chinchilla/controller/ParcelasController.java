package com.chinchilla.controller;

import com.chinchilla.form.LaborForm;
import com.chinchilla.form.ProduccionForm;
import com.chinchilla.persistence.objects.Coordenada;
import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Cultivo;
import com.chinchilla.persistence.objects.Electricidad;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.OrdenCompra;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.Produccion;
import com.chinchilla.persistence.objects.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        
        long startTime = System.currentTimeMillis();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Coordenada> coordenadas = coordenadaDAO.getAll();
        
        List<Labor> labores = laborDAO.getAll();
        
       List<Electricidad> electricidad = electricidadDAO.getAll();
        
       List<OrdenCompra> ordenesCompra = ordenCompraDAO.getAll();

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("coordenadas", coordenadas);

        modelMap.put("ordenesCompra", ordenesCompra);

        modelMap.put("electricidad", electricidad);

        modelMap.put("labores", labores);
        
        model.addAllAttributes(modelMap);
       
        long endTime = System.currentTimeMillis();
       
        log.info(getClass()+".mapa execution time: " + (endTime-startTime) + "ms");

        return "parcelas-mapa";
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        mapa(model);

        return "parcelas-tabla";
    }
    
    @RequestMapping(value = "/mapa/labores/tabla.html",params = {"id"}, method=RequestMethod.GET)
    public String mapaLaboresTabla(@RequestParam(value = "id") Integer id_parcela, Model model) throws Exception {

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        
        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Coordenada> coordenadas = coordenadaDAO.getAll();
        
        List<Labor> labores = laborDAO.getAll();
        
       List<Electricidad> electricidad = electricidadDAO.getAll();
        
       List<OrdenCompra> ordenesCompra = ordenCompraDAO.getAll();

        modelMap.put("ordenesCompra", ordenesCompra);

        modelMap.put("electricidad", electricidad);

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("coordenadas", coordenadas);

        modelMap.put("labores", labores);
        
        List<Map<String,Object>> aoAdvancedFilter = new ArrayList<Map<String,Object>>();
        
        if(parcelas!=null){
            
            for (Parcela temp : parcelas){
                if(temp.getId_parcela() == id_parcela){
                    Map<String,Object> oAdvancedFilter = new HashMap<String,Object>();
//                    aoAdvancedFilter.put("sTitle", column);
                    oAdvancedFilter.put("sTitleKey", "parcela");
                    Map<String,String> oOperation = new HashMap<String,String>();
                    oOperation.put("sOperation", "equals");
                    oOperation.put("sValue1", temp.getNombre());
                    List<Map<String,String>> aoOperations = new ArrayList<Map<String,String>>();
                    aoOperations.add(oOperation);
                    oAdvancedFilter.put("aoOperations", aoOperations);
                    aoAdvancedFilter.add(oAdvancedFilter);
                    break;
                }
            }

            modelMap.put("aoAdvancedFilter", aoAdvancedFilter);
            
            log.debug("aoAdvancedFilter: " + aoAdvancedFilter);
        
        }
        
        model.addAllAttributes(modelMap);
        
        return "parcelas-tabla-labores";
    }
    
    @RequestMapping(value = "/mapa/producciones/tabla.html",params = {"id"}, method=RequestMethod.GET)
    public String mapaProduccionesTabla(@RequestParam(value = "id") Integer id_parcela, Model model) throws Exception {
        
        
        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Coordenada> coordenadas = coordenadaDAO.getAll();
        
        List<Labor> labores = laborDAO.getAll();

        List<Produccion> producciones = produccionDAO.getAll();

        List<Cultivo> cultivos = cultivoDAO.getAll();
        
       List<OrdenCompra> ordenesCompra = ordenCompraDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("coordenadas", coordenadas);

        modelMap.put("labores", labores);

        modelMap.put("producciones", producciones);
        
        modelMap.put("cultivos", cultivos);

        modelMap.put("ordenesCompra", ordenesCompra);
        
        List<Map<String,Object>> aoAdvancedFilter = new ArrayList<Map<String,Object>>();
        
        if(parcelas!=null){
            
            for (Parcela temp : parcelas){
                if(temp.getId_parcela() == id_parcela){
                    Map<String,Object> oAdvancedFilter = new HashMap<String,Object>();
//                    aoAdvancedFilter.put("sTitle", column);
                    oAdvancedFilter.put("sTitleKey", "parcela");
                    Map<String,String> oOperation = new HashMap<String,String>();
                    oOperation.put("sOperation", "equals");
                    oOperation.put("sValue1", temp.getZona()+" - "+temp.getNombre());
                    List<Map<String,String>> aoOperations = new ArrayList<Map<String,String>>();
                    aoOperations.add(oOperation);
                    oAdvancedFilter.put("aoOperations", aoOperations);
                    aoAdvancedFilter.add(oAdvancedFilter);
                    break;
                }
            }

            modelMap.put("aoAdvancedFilter", aoAdvancedFilter);
            
            log.debug("aoAdvancedFilter: " + aoAdvancedFilter);
        
        }
        
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
        
        boolean success = laborService.insertaModificarEliminarLabor(model_labor, modelMap);

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
        
        boolean success = produccionService.insertaModificarEliminarProduccion(model_produccion, modelMap);

        model.addAllAttributes(modelMap);

        return "parcelas-mapa";
        
    }
}
