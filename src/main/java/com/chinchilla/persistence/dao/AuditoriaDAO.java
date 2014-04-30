package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Auditoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository
public class AuditoriaDAO extends MyBatisDAO<Auditoria, Auditoria> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(AuditoriaDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public AuditoriaDAO() throws IOException {
        this(Auditoria.class);
    }
    
    public AuditoriaDAO(Class<Auditoria> type) throws IOException {
        super(type);
    }
    
//    public ParcelaDAO(Class<Parcela> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
