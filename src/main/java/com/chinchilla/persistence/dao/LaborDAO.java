package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.LaborMaquinaria;
import com.chinchilla.persistence.objects.LaborParcela;
import com.chinchilla.persistence.objects.LaborPersonal;
import com.chinchilla.persistence.objects.LaborProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("laborDAO")
public class LaborDAO extends MyBatisDAO<Labor, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(LaborDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public LaborDAO() throws IOException {
        this(Labor.class);
    }
    
    public LaborDAO(Class<Labor> type) throws IOException {
        super(type);
    }
    
//    public LaborDAO(Class<Labor> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
    
    public int createLaborMaquinaria(List<LaborMaquinaria> laborMaquinariaList) {

       long startTime = System.currentTimeMillis();

        Integer status = null;

        String query = NAMESPACE + DOT + this.getType().getSimpleName() + "Mappers" +  DOT +  PREFIX_INSERT_QUERY + this.getType().getSimpleName() + "Maquinaria" ;
        
        status = (Integer) getSqlSession().insert(query, laborMaquinariaList);
       
       log.debug("Result: " + status);
       
       long endTime = System.currentTimeMillis();
       
       log.info(query+" execution time: " + (endTime-startTime) + "ms");

        return status;
    }  
    
    public int deleteLaborMaquinaria(Integer id) {

       long startTime = System.currentTimeMillis();
       
       log.debug("Parameters: " + id);

        Integer status = null;
        
        String query = NAMESPACE + DOT + this.getType().getSimpleName() + "Mappers" +  DOT +  PREFIX_DELETE_QUERY + this.getType().getSimpleName() + "Maquinaria";

        status = getSqlSession().delete(query, id);
       
       log.debug("Result: " + status);
       
       long endTime = System.currentTimeMillis();
       
       log.info(query+" execution time: " + (endTime-startTime) + "ms");
       
        return status;

    }
    
    
    
    public int createLaborParcela(List<LaborParcela> laborParcelaList) {

       long startTime = System.currentTimeMillis();

        Integer status = null;

        String query = NAMESPACE + DOT + this.getType().getSimpleName() + "Mappers" +  DOT +  PREFIX_INSERT_QUERY + this.getType().getSimpleName() + "Parcela" ;
        
        status = (Integer) getSqlSession().insert(query, laborParcelaList);
       
       log.debug("Result: " + status);
       
       long endTime = System.currentTimeMillis();
       
       log.info(query+" execution time: " + (endTime-startTime) + "ms");

        return status;
    }  
    
    public int deleteLaborParcela(Integer id) {

       long startTime = System.currentTimeMillis();
       
       log.debug("Parameters: " + id);

        Integer status = null;
        
        String query = NAMESPACE + DOT + this.getType().getSimpleName() + "Mappers" +  DOT +  PREFIX_DELETE_QUERY + this.getType().getSimpleName() + "Parcela";

        status = getSqlSession().delete(query, id);
       
       log.debug("Result: " + status);
       
       long endTime = System.currentTimeMillis();
       
       log.info(query+" execution time: " + (endTime-startTime) + "ms");
       
        return status;

    }
    
    
    
    public int createLaborPersonal(List<LaborPersonal> laborPersonalList) {

       long startTime = System.currentTimeMillis();

        Integer status = null;

        String query = NAMESPACE + DOT + this.getType().getSimpleName() + "Mappers" +  DOT +  PREFIX_INSERT_QUERY + this.getType().getSimpleName() + "Personal" ;
        
        status = (Integer) getSqlSession().insert(query, laborPersonalList);
       
       log.debug("Result: " + status);
       
       long endTime = System.currentTimeMillis();
       
       log.info(query+" execution time: " + (endTime-startTime) + "ms");

        return status;
    }  
    
    public int deleteLaborPersonal(Integer id) {

       long startTime = System.currentTimeMillis();
       
       log.debug("Parameters: " + id);

        Integer status = null;
        
        String query = NAMESPACE + DOT + this.getType().getSimpleName() + "Mappers" +  DOT +  PREFIX_DELETE_QUERY + this.getType().getSimpleName() + "Personal";

        status = getSqlSession().delete(query, id);
       
       log.debug("Result: " + status);
       
       long endTime = System.currentTimeMillis();
       
       log.info(query+" execution time: " + (endTime-startTime) + "ms");
       
        return status;

    }
    
    
    
    public int createLaborProducto(List<LaborProducto> laborProductoList) {

       long startTime = System.currentTimeMillis();

        Integer status = null;

        String query = NAMESPACE + DOT + this.getType().getSimpleName() + "Mappers" +  DOT +  PREFIX_INSERT_QUERY + this.getType().getSimpleName() + "Producto" ;
        
        status = (Integer) getSqlSession().insert(query, laborProductoList);
       
       log.debug("Result: " + status);
       
       long endTime = System.currentTimeMillis();
       
       log.info(query+" execution time: " + (endTime-startTime) + "ms");

        return status;
    }  
    
    public int deleteLaborProducto(Integer id) {

       long startTime = System.currentTimeMillis();
       
       log.debug("Parameters: " + id);

        Integer status = null;
        
        String query = NAMESPACE + DOT + this.getType().getSimpleName() + "Mappers" +  DOT +  PREFIX_DELETE_QUERY + this.getType().getSimpleName() + "Producto";

        status = getSqlSession().delete(query, id);
       
       log.debug("Result: " + status);
       
       long endTime = System.currentTimeMillis();
       
       log.info(query+" execution time: " + (endTime-startTime) + "ms");
       
        return status;

    }
    
    
}
