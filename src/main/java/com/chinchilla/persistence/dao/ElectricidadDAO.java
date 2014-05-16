package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Electricidad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("electricidadDAO")
public class ElectricidadDAO extends MyBatisDAO<Electricidad, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(ElectricidadDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public ElectricidadDAO() throws IOException {
        this(Electricidad.class);
    }
    
    public ElectricidadDAO(Class<Electricidad> type) throws IOException {
        super(type);
    }
    
//    public ElectricidadDAO(Class<Electricidad> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
