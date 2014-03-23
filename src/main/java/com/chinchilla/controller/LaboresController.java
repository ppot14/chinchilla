package com.chinchilla.controller;

import com.chinchilla.form.LaborForm;
import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.LaborMaquinaria;
import com.chinchilla.persistence.objects.LaborParcela;
import com.chinchilla.persistence.objects.LaborPersonal;
import com.chinchilla.persistence.objects.LaborProducto;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.Parcela;
import com.chinchilla.persistence.objects.Producto;
import com.chinchilla.util.Notificador;
import java.util.ArrayList;
import java.util.HashMap;
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

        Map<String, Object> modelMap = new LinkedHashMap<String, Object>();

        modelMap.put("labores", labores);
        
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
           Model model) throws Exception {
        
        long startTime = System.currentTimeMillis();
        
        log.info(""+model_labor);
        
        String tipoOperacion = model_labor.getInsertar_modificar_eliminar();
        
//        Labor labor = new Labor(model_labor);
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        int created = 0;
        
        int updated = 0;
        
        int deleted = 0;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            if(createLabor(model_labor)){
            
                created++;
        
                Notificador.incluirMensaje(modelMap, "success", "Labor añadida correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido añadiendo Labor");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            Labor labor = new Labor(model_labor);
        
            log.debug("labor labor.getId_labor "+labor.getId_labor());
       
            int modified = laborDAO.update(labor);
            
            log.info("modified "+modified);
            
            boolean deletedContenidoLabor = deleteContenidoLabor(model_labor);
            
            boolean createdContenidoLabor = createContenidoLabor(model_labor);
            
            log.info("deletedContenidoLabor "+deletedContenidoLabor);
            
            log.info("createdContenidoLabor "+createdContenidoLabor);
            
            if(modified==1 && deletedContenidoLabor && createdContenidoLabor){
            
                updated++;
        
                Notificador.incluirMensaje(modelMap, "success", "Labor modificada correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido modificando Labor");
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            if(deleteLabor(model_labor)){
            
                deleted++;
        
                Notificador.incluirMensaje(modelMap, "success", "Labor eliminado correctamente");
                
            }else{
        
                Notificador.incluirMensaje(modelMap, "error", "Error desconocido eliminando Labor");
                
            }
            
        }else{
            
             Notificador.incluirMensaje(modelMap, "info", "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        if(created>0 || updated>0 || deleted>0){

            List<Labor> labores = laborDAO.getAll();

            modelMap.put("labores", labores);
        
        }
        
        model.addAllAttributes(modelMap);
       
       long endTime = System.currentTimeMillis();
       
       log.info(getClass()+".tablaFormProcesarLabor execution time: " + (endTime-startTime) + "ms");

        return "labores-tabla";
    }
    
   private boolean createLabor(LaborForm model_labor){
       
        Labor labor = new Labor(model_labor);
        
        log.debug("labor labor.getId_labor "+model_labor.getId_labor());
       
        int created = laborDAO.create(labor);
        
        model_labor.setId_labor(labor.getId_labor());
        
        log.debug("create labor.getId_labor "+model_labor.getId_labor());

        log.info("created "+created);
        
        boolean createdContenidoLaborTemp = createContenidoLabor(model_labor);
        
        return (created==1 && createdContenidoLaborTemp);
   }    
   
   private boolean createContenidoLabor(LaborForm model_labor){
        
        int createdLaborMaquinaria=0;
        int createLaborParcela=0;
        int createLaborPersonal=0;
        int createLaborProducto=0;

        if(model_labor.getId_maquinarias()!=null&&!model_labor.getId_maquinarias().isEmpty()){

            List<LaborMaquinaria> laborMaquinariaList = new ArrayList<LaborMaquinaria>(model_labor.getId_maquinarias().size());

            for(int i = 0; i < model_labor.getId_maquinarias().size(); i++){
                LaborMaquinaria o = new LaborMaquinaria();
                Maquinaria u = new Maquinaria();
                u.setId_coste_maquinaria(model_labor.getId_maquinarias().get(i));
                o.setId_labor(model_labor.getId_labor());
                o.setMaquinaria(u);
                o.setPosicion_formula(i+1);
                laborMaquinariaList.add(o);
            }
            
            createdLaborMaquinaria = laborDAO.createLaborMaquinaria(laborMaquinariaList);
        }
        if(model_labor.getId_parcelas()!=null&&!model_labor.getId_parcelas().isEmpty()){
            
            List<LaborParcela> laborParcelaList = new ArrayList<LaborParcela>(model_labor.getId_parcelas().size());
            
            for(int i = 0; i < model_labor.getId_parcelas().size(); i++){
                LaborParcela o = new LaborParcela();
                Parcela u = new Parcela();
                u.setId_parcela(model_labor.getId_parcelas().get(i));
                o.setId_labor(model_labor.getId_labor());
                o.setParcela(u);
                o.setPosicion_formula(i+1);
                laborParcelaList.add(o);
            }
            
            createLaborParcela = laborDAO.createLaborParcela(laborParcelaList);
        }
        if(model_labor.getId_costes_personal()!=null&&!model_labor.getId_costes_personal().isEmpty()){
            
            List<LaborPersonal> laborPersonalList = new ArrayList<LaborPersonal>(model_labor.getId_costes_personal().size());

            for(int i = 0; i < model_labor.getId_costes_personal().size(); i++){
                LaborPersonal o = new LaborPersonal();
                CostePersonal u = new CostePersonal();
                u.setId_coste_personal(model_labor.getId_costes_personal().get(i));
                o.setId_labor(model_labor.getId_labor());
                o.setCoste_personal(u);
                o.setPosicion_formula(i+1);
                laborPersonalList.add(o);
            }
            
            createLaborPersonal = laborDAO.createLaborPersonal(laborPersonalList);
        }
        if(model_labor.getId_productos()!=null&&!model_labor.getId_productos().isEmpty()){
            
            List<LaborProducto> laborProductoList = new ArrayList<LaborProducto>(model_labor.getId_productos().size());

            for(int i = 0; i < model_labor.getId_productos().size(); i++){
                LaborProducto o = new LaborProducto();
                Producto u = new Producto();
                u.setId_producto(model_labor.getId_productos().get(i));
                o.setId_labor(model_labor.getId_labor());
                o.setProducto(u);
                o.setPosicion_formula(i+1);
                laborProductoList.add(o);
            }
            
            createLaborProducto = laborDAO.createLaborProducto(laborProductoList);
        }

        log.info("createdLaborMaquinaria "+createdLaborMaquinaria);
        log.info("createLaborParcela "+createLaborParcela);
        log.info("createLaborPersonal "+createLaborPersonal);
        log.info("createLaborProducto "+createLaborProducto);
        
        return ((model_labor.getId_maquinarias()==null || model_labor.getId_maquinarias().size()==createdLaborMaquinaria) &&
                (model_labor.getId_parcelas()==null || model_labor.getId_parcelas().size()==createLaborParcela) &&
                (model_labor.getId_costes_personal()==null || model_labor.getId_costes_personal().size()==createLaborPersonal) &&
                (model_labor.getId_productos()==null || model_labor.getId_productos().size()==createLaborProducto));
   }
   
   private boolean deleteLabor(LaborForm model_labor){
       
        Labor labor = new Labor(model_labor);
       
        int deleted = laborDAO.delete(labor.getId_labor());
        
        log.info("deleted labor "+deleted);

        boolean deletedContenidoLaborTemp = deleteContenidoLabor(model_labor);

        return (deleted==1 && deletedContenidoLaborTemp);
   }
   
   private boolean deleteContenidoLabor(LaborForm model_labor){

        int deleteLaborMaquinaria =0;
        int deleteLaborParcela =0;
        int deleteLaborPersonal =0;
        int deleteLaborProducto =0;

        if(model_labor.getId_maquinarias()!=null&&!model_labor.getId_maquinarias().isEmpty())
          deleteLaborMaquinaria = laborDAO.deleteLaborMaquinaria(model_labor.getId_labor());
        if(model_labor.getId_parcelas()!=null&&!model_labor.getId_parcelas().isEmpty())
          deleteLaborParcela = laborDAO.deleteLaborParcela(model_labor.getId_labor());
        if(model_labor.getId_costes_personal()!=null&&!model_labor.getId_costes_personal().isEmpty())
          deleteLaborPersonal = laborDAO.deleteLaborPersonal(model_labor.getId_labor());
        if(model_labor.getId_productos()!=null&&!model_labor.getId_productos().isEmpty())
          deleteLaborProducto = laborDAO.deleteLaborProducto(model_labor.getId_labor());

        log.info("deleteLaborMaquinaria "+deleteLaborMaquinaria);
        log.info("deleteLaborParcela "+deleteLaborParcela);
        log.info("deleteLaborPersonal "+deleteLaborPersonal);
        log.info("deleteLaborProducto "+deleteLaborProducto);

        return deleteLaborMaquinaria>-1 && deleteLaborParcela>-1 && deleteLaborPersonal>-1 && deleteLaborProducto>-1;
   }

}
