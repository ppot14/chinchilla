/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence;

import com.chinchilla.persistence.dao.ParcelaDAO;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Pepe
 */
@ContextConfiguration("classpath:spring-ibatis.xml")
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class TestParcela extends AbstractTransactionalJUnit4SpringContextTests{

    private static Logger log = (Logger) LoggerFactory.getLogger(TestParcela.class);
    
     @Autowired
     @Qualifier("parcelaDAO")
    private MyBatisDAO parcela;
//    private static TunnelingSSH tunel;

    public TestParcela() {
        super();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Autowired
  @Qualifier("dataSource")
    @Override
  public void setDataSource(DataSource dataSource) {
    super.setDataSource(dataSource);
  }    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    @Ignore
    public void get() {
        Object result = parcela.get(new Integer(2000086));
        assertNotNull(result);
    }
}
