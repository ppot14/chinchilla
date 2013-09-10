package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.TipoLabor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("tipoLaborDAO")
public class TipoLaborDAO extends MyBatisDAO<TipoLabor, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(TipoLaborDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public TipoLaborDAO() throws IOException {
        this(TipoLabor.class);
    }
    
    public TipoLaborDAO(Class<TipoLabor> type) throws IOException {
        super(type);
    }
    
//    public TipoLaborDAO(Class<TipoLabor> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
