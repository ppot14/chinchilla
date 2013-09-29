package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Maquinaria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("maquinariaDAO")
public class MaquinariaDAO extends MyBatisDAO<Maquinaria, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(MaquinariaDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public MaquinariaDAO() throws IOException {
        this(Maquinaria.class);
    }
    
    public MaquinariaDAO(Class<Maquinaria> type) throws IOException {
        super(type);
    }
    
//    public MaquinariaDAO(Class<Maquinaria> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
