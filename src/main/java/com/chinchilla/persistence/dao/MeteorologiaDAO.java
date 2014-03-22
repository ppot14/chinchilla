package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Meteorologia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("meteorologiaDAO")
public class MeteorologiaDAO extends MyBatisDAO<Meteorologia, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(MeteorologiaDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public MeteorologiaDAO() throws IOException {
        this(Meteorologia.class);
    }
    
    public MeteorologiaDAO(Class<Meteorologia> type) throws IOException {
        super(type);
    }
    
//    public MeteorologiaDAO(Class<Meteorologia> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
