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
import java.util.ArrayList;
//import com.chinchilla.persistence.objects.TipoLabor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@SessionAttributes({"labor"})
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
     
//     @RequestMapping(value = "/mapa/form/procesar/labor.html", method=RequestMethod.POST)
//    public String mapaFormProcesarLabor(
//            @ModelAttribute("labor") LaborForm model_labor,
//           BindingResult result,
//           SessionStatus status,
//           Model model) throws Exception {
//        
//        LaboresController laboresController = new LaboresController();
//         
//        laboresController.tablaFormProcesarLabor(model_labor,result,status,model);
//         
//        return mapa(model);
//         
//     }
}
