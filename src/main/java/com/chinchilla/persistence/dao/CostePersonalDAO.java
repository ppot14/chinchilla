package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.CostePersonal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("costePersonalDAO")
public class CostePersonalDAO extends MyBatisDAO<CostePersonal, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(CostePersonalDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public CostePersonalDAO() throws IOException {
        this(CostePersonal.class);
    }
    
    public CostePersonalDAO(Class<CostePersonal> type) throws IOException {
        super(type);
    }
    
//    public CostePersonalDAO(Class<CostePersonal> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
