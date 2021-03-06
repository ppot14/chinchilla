/*
 * The MIT License
 *
 * Copyright 2014 Pepe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.chinchilla.service;

import com.chinchilla.component.Notificador;
import com.chinchilla.form.LaborForm;
import com.chinchilla.persistence.dao.LaborDAO;
import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.LaborMaquinaria;
import com.chinchilla.persistence.objects.LaborParcela;
import com.chinchilla.persistence.objects.LaborPersonal;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.Parcela;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pepe
 */
@Service("laborService")
public class LaborService extends AbstractService{
    
    private static Logger log = (Logger) LoggerFactory.getLogger(LaborService.class);
    
    @Autowired
    @Qualifier("laborDAO")
    protected LaborDAO laborDAO; 
    
    public boolean insertaModificarEliminarLabor(LaborForm laborForm, Map<String, Object> modelMap){
        
        log.debug("insertaModificarEliminarLabor: "+laborForm);
        
        String tipoOperacion = laborForm.getInsertar_modificar_eliminar();
        
        boolean success = false;
        
        if(tipoOperacion!=null&&tipoOperacion.equals("insertar")){
            
            if(createLabor(laborForm)){
                
                success = true;
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Labor añadida correctamente",null);
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido añadiendo Labor",null);
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("modificar")){
            
            Labor labor = new Labor(laborForm);
        
            log.debug("labor labor.getId_labor "+labor.getId_labor());
       
            int modified = laborDAO.update(labor);
            
            log.debug("modified "+modified);
            
            boolean deletedContenidoLabor = deleteContenidoLabor(laborForm);
            
            boolean createdContenidoLabor = createContenidoLabor(laborForm);
            
            log.debug("deletedContenidoLabor "+deletedContenidoLabor);
            
            log.debug("createdContenidoLabor "+createdContenidoLabor);
            
            if(modified==1 && deletedContenidoLabor && createdContenidoLabor){
            
                success = true;
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Labor modificada correctamente",null,labor.getId_labor());
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido modificando Labor",null,labor.getId_labor());
                
            }
            
        }else if(tipoOperacion!=null&&tipoOperacion.equals("eliminar")){
            
            if(deleteLabor(laborForm)){
            
                success = true;
        
                notificador.incluirMensaje(modelMap, Notificador.SUCCESS, "Labor eliminado correctamente",null,laborForm.getId_labor());
                
            }else{
        
                notificador.incluirMensaje(modelMap, Notificador.ERROR, "Error desconocido eliminando Labor",null,laborForm.getId_labor());
                
            }
            
        }else{
            
             notificador.incluirMensaje(modelMap, Notificador.INFO, "No se ha podido identificar la operacion",
                     "Ninguna accion sera realizada");
            
        }
        
        return success;
        
    }
    
    private boolean createLabor(LaborForm model_labor){
       
        Labor labor = new Labor(model_labor);
        
        log.debug("labor labor.getId_labor "+model_labor.getId_labor());
       
        int created = laborDAO.create(labor);
        
        model_labor.setId_labor(labor.getId_labor());
        
        log.debug("create labor.getId_labor "+model_labor.getId_labor());

        log.debug("created "+created);
        
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
        if(model_labor.getLabor_producto()!=null&&!model_labor.getLabor_producto().isEmpty()){
            
//            List<LaborProducto> laborProductoList;
            
            log.debug("getLabor_producto: "+model_labor.getLabor_producto());
            
//            log.debug("getId_productos: "+model_labor.getId_productos());
            
//            if(model_labor.getLabor_producto()!=null && !model_labor.getLabor_producto().isEmpty()){
                
//            } else{
            
//                laborProductoList = new ArrayList<LaborProducto>(model_labor.getId_productos().size());
//
                for(int i = 0; i < model_labor.getLabor_producto().size(); i++){
                    model_labor.getLabor_producto().get(i).setId_labor(model_labor.getId_labor());
                    model_labor.getLabor_producto().get(i).setPosicion_formula(i+1);
                }
            
//            }
            
            createLaborProducto = laborDAO.createLaborProducto(model_labor.getLabor_producto());
        }

        log.debug("createdLaborMaquinaria "+createdLaborMaquinaria);
        log.debug("createLaborParcela "+createLaborParcela);
        log.debug("createLaborPersonal "+createLaborPersonal);
        log.debug("createLaborProducto "+createLaborProducto);
        
        return ((model_labor.getId_maquinarias()==null || model_labor.getId_maquinarias().size()==createdLaborMaquinaria) &&
                (model_labor.getId_parcelas()==null || model_labor.getId_parcelas().size()==createLaborParcela) &&
                (model_labor.getId_costes_personal()==null || model_labor.getId_costes_personal().size()==createLaborPersonal) &&
                (model_labor.getLabor_producto()==null || model_labor.getLabor_producto().size()==createLaborProducto));
   }
   
   private boolean deleteLabor(LaborForm model_labor){
       
        Labor labor = new Labor(model_labor);
       
        int deleted = laborDAO.delete(labor.getId_labor());
        
        log.debug("deleted labor "+deleted);

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
        if(model_labor.getLabor_producto()!=null&&!model_labor.getLabor_producto().isEmpty())
          deleteLaborProducto = laborDAO.deleteLaborProducto(model_labor.getId_labor());

        log.debug("deleteLaborMaquinaria "+deleteLaborMaquinaria);
        log.debug("deleteLaborParcela "+deleteLaborParcela);
        log.debug("deleteLaborPersonal "+deleteLaborPersonal);
        log.debug("deleteLaborProducto "+deleteLaborProducto);

        return deleteLaborMaquinaria>-1 && deleteLaborParcela>-1 && deleteLaborPersonal>-1 && deleteLaborProducto>-1;
   }
    
}
