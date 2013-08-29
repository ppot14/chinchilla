package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Coordenada;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository
public class CoordenadaDAO extends MyBatisDAO<Coordenada, Coordenada> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(CoordenadaDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public CoordenadaDAO() throws IOException {
        this(Coordenada.class);
    }
    
    public CoordenadaDAO(Class<Coordenada> type) throws IOException {
        super(type);
    }
    
//    public ParcelaDAO(Class<Parcela> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
