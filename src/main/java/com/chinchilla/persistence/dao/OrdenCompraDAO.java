package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.OrdenCompra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("ordenCompraDAO")
public class OrdenCompraDAO extends MyBatisDAO<OrdenCompra, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(OrdenCompraDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public OrdenCompraDAO() throws IOException {
        this(OrdenCompra.class);
    }
    
    public OrdenCompraDAO(Class<OrdenCompra> type) throws IOException {
        super(type);
    }
    
//    public CostePersonalDAO(Class<CostePersonal> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
