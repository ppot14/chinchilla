package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Parcela;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("parcelaDAO")
public class ParcelaDAO extends MyBatisDAO<Parcela, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(ParcelaDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public ParcelaDAO() throws IOException {
        this(Parcela.class);
    }
    
    public ParcelaDAO(Class<Parcela> type) throws IOException {
        super(type);
    }
    
//    public ParcelaDAO(Class<Parcela> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
