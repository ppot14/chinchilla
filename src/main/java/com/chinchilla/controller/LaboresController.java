package com.chinchilla.controller;

import com.chinchilla.form.LaborForm;
import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Electricidad;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.OrdenCompra;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.Producto;
import com.chinchilla.service.LaborService;
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
@Controller("laboresController")
@RequestMapping("/labores")
//@SessionAttributes({"tiposLaboresMaquinaria"})
public class LaboresController extends AbstractController{
    
    private static Logger log = (Logger) LoggerFactory.getLogger(LaboresController.class);
     
    
    /*
     * Labores
     */
    @RequestMapping("/")
    public String index(Model model) throws Exception {
        return tabla(model);
    }
     
    @RequestMapping("/tabla.html")
    public String tabla(Model model) throws Exception {

        List<Labor> labores = laborDAO.getAll();
        
       List<OrdenCompra> ordenesCompra = ordenCompraDAO.getAll();
        
       List<Electricidad> electricidad = electricidadDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labores", labores);

        modelMap.put("ordenesCompra", ordenesCompra);

        modelMap.put("electricidad", electricidad);
        
        model.addAllAttributes(modelMap);
        
        return "labores-tabla";
    }
    
    @RequestMapping(value = "/tabla/form/labor.html",params = {"id"}, method=RequestMethod.GET)
    public String tablaFormLabor(@RequestParam(value = "id") Integer id_labor, Model model) throws Exception {

        LaborForm labor = null;
        
        if(id_labor.intValue()>0){

            labor = new LaborForm(laborDAO.get(id_labor));
            
            labor.setUpListIds();
        
        }else{
        
            labor = new LaborForm();
        
        }
        
        log.info("labor "+labor);

        List<Parcela> parcelas = parcelaDAO.getAll();
        
        List<Maquinaria> maquinaria = maquinariaDAO.getAll();
        
        List<Producto> productos = productoDAO.getAll();
        
        List<CostePersonal> costesPersonal = costePersonalDAO.getAll();

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labor", labor);

        modelMap.put("parcelas", parcelas);

        modelMap.put("maquinaria", maquinaria);

        modelMap.put("productos", productos);
        
        modelMap.put("costesPersonal", costesPersonal);
        
        model.addAllAttributes(modelMap);
        
        return "labores-tabla-form-labor";
    }
    
    @RequestMapping(value = "/tabla/form/procesar/labor.html",method = RequestMethod.POST)
   public String tablaFormProcesarLabor(
            @ModelAttribute("labor") LaborForm model_labor,
           BindingResult result,
           SessionStatus status,
           Model model,
           HttpServletRequest request) throws Exception {
        
        long startTime = System.currentTimeMillis();
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        boolean success = laborService.insertaModificarEliminarLabor(model_labor, modelMap);

        model.addAllAttributes(modelMap);
        
        tabla(model);
       
        long endTime = System.currentTimeMillis();
       
        log.info(getClass()+".tablaFormProcesarLabor execution time: " + (endTime-startTime) + "ms");

        return "labores-tabla";
    }

}
