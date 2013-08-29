/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.incubadora;

import com.chinchilla.persistence.MyBatisDAO;
import com.chinchilla.persistence.connection.TunnelingSSH;
import com.chinchilla.persistence.dao.ParcelaDAO;
import com.chinchilla.persistence.objects.Parcela;
import com.jcraft.jsch.JSchException;
import java.io.IOException;
import java.util.List;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 *
 * @author Pepe
 */
public class Pruebas {
    
    
    /**
     *
     * @param args
     */
    public static void main(String[] args)  {

            TunnelingSSH tunnel = null;
            
        try {
            Pruebas pruebas = new Pruebas();

            MyBatisDAO nuevaConexion = new ParcelaDAO(Parcela.class);

            List lista = nuevaConexion.getAll();

            for (Object o : lista) {
                if (o instanceof Parcela) {
                    Parcela p = (Parcela) o;
                    System.out.println(p);
                }
            }

        } catch (IOException ex) {
            System.out.println( ex);
//        } catch (ConfigurationException ex) {
//            System.out.println( ex);
//        } catch (JSchException ex) {
//            System.out.println( ex);
        } finally{
            tunnel.disconnectionSSH();
        }
    }

    private Configuration getProperties() throws IOException, ConfigurationException {
        
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        
        path = path.replace("%20", " ");
        
//        File file = new File(path+"config.properties");
        
//        InputStream is= this.getClass().getClassLoader().getResourceAsStream("config.properties");
//        FileInputStream is= new FileInputStream(file);
//        Properties pro = new Properties();
//        pro.load(is);

        Configuration config = new PropertiesConfiguration(path+"config.properties");
        

        return config;

    }
}
