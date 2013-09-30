package com.chinchilla.persistence.dao;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.objects.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * Simple example DAO which uses the MyBatisDAO Helper Framework
 */
@Repository("productoDAO")
public class ProductoDAO extends MyBatisDAO<Producto, Integer> {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(ProductoDAO.class);

    //Don't forget to define the default custom constructor when implementing a new 
    //child DAO class, and set the class type accordingly 
    public ProductoDAO() throws IOException {
        this(Producto.class);
    }
    
    public ProductoDAO(Class<Producto> type) throws IOException {
        super(type);
    }
    
//    public ProductoDAO(Class<Producto> type, SqlSessionFactory containerSessionFactory) {
//        super(type, containerSessionFactory);
//    }
}
