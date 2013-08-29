package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Cultivo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("cultivoDAO")
public class CultivoDAO extends MyBatisDAO<Cultivo, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(CultivoDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public CultivoDAO() throws IOException {
        this(Cultivo.class);
    }
    
    public CultivoDAO(Class<Cultivo> type) throws IOException {
        super(type);
    }
    
//    public CultivoDAO(Class<Cultivo> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
