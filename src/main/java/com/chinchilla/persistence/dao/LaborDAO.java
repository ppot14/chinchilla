package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Labor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
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
}
