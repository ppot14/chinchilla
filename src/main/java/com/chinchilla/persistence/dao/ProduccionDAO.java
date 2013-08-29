package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Produccion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("produccionDAO")
public class ProduccionDAO extends MyBatisDAO<Produccion, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(ProduccionDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public ProduccionDAO() throws IOException {
        this(Produccion.class);
    }
    
    public ProduccionDAO(Class<Produccion> type) throws IOException {
        super(type);
    }
    
//    public ProduccionDAO(Class<Produccion> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
