package com.chinchilla.controller;

import com.chinchilla.form.LaborForm;
import com.chinchilla.persistence.objects.Coordenada;
import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.Parcela;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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

//        log.info("Received request to show ParcelasController mapa: parcelas-mapa");

        return "parcelas-mapa";
    }
    
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Coordenada> coordenadas = coordenadaDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("coordenadas", coordenadas);
        
        model.addAllAttributes(modelMap);

//        log.info("Received request to show ParcelasController tabla: parcelas-tabla");

        return "parcelas-tabla";
    }
    
     @RequestMapping(value = "/mapa/form/labor.html",params = {"id"}, method=RequestMethod.GET)
    public String mapaFormLabor(@RequestParam(value = "id") Integer id_parcela, Model model) throws Exception {
         
        LaborForm labor = new LaborForm();
        
        labor.setId_parcelas(new ArrayList<Integer>());
        
        labor.getId_parcelas().add(id_parcela);
        
        log.info("labor "+labor);

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Maquinaria> maquinaria = maquinariaDAO.getAll();
        
        List<Producto> productos = productoDAO.getAll();
        
        List<CostePersonal> costesPersonal = costePersonalDAO.getAll();
        
        List<Coordenada> coordenadas = coordenadaDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labor", labor);

        modelMap.put("parcelas", parcelas);

        modelMap.put("maquinaria", maquinaria);

        modelMap.put("productos", productos);
        
        modelMap.put("costesPersonal", costesPersonal);
        
        modelMap.put("coordenadas", coordenadas);
        
        model.addAllAttributes(modelMap);
         
        return "parcelas-mapa-form-labor";
         
     }
     
     @RequestMapping(value = "/mapa/form/procesar/labor.html", method=RequestMethod.POST)
    public String mapaFormProcesarLabor(
            @ModelAttribute("labor") Labor labor ,
            @ModelAttribute("parcelas") Map<String,String> parcelas ,
            @ModelAttribute("personal") Map<String,String> personal ,
            @ModelAttribute("insertar_modificar_eliminar") String insertar_modificar_eliminar,
            Model model) throws Exception {
         
        log.info("labor "+labor);

        log.info("parcelas "+parcelas);

        log.info("personal "+personal);

        log.info("insertar_modificar_eliminar "+insertar_modificar_eliminar);
         
         Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
        
        model.addAllAttributes(modelMap);

//        log.info("Received request to insert/modify ParcelasController mapa: parcelas-mapa-form-labor");
         
        return "parcelas-mapa";
         
     }
     
    @RequestMapping(value = "/mapa/tabla/labores.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaLabor(@RequestParam(value = "id") Integer id_parcela, Model model) throws Exception {
                
        List<Labor> labores = laborDAO.getFilteredById(Parcela.class, id_parcela);
         
//         List<TipoLabor> tipoLabores = tipoLaborDAO.getAll();

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Coordenada> coordenadas = coordenadaDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labores", labores);

        modelMap.put("parcelas", parcelas);
        
        modelMap.put("coordenadas", coordenadas);
         
//         modelMap.put("tipoLabores", tipoLabores);
        
        model.addAllAttributes(modelMap);
        
        return "parcelas-tabla-labores";
    }
}
