package com.chinchilla.persistence.connection;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pepe
 */
public class TunnelingSSH {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(TunnelingSSH.class);

    private Session session;
    
    private JSch jsch;
    
    private String sshUser;
    private String sshPassword;
    private String sshHost;
    private int sshPort;
    private int sshLocalPort;
    private String sshRemoteHost;
    private int sshRemotePort;
    private int sshTimeOut;
    
    private boolean sshDbEnabled;

    public TunnelingSSH() {
    }

    public TunnelingSSH(String ssh_user, String ssh_password, String ssh_host, int ssh_port, int ssh_local_port, String ssh_remote_host, int ssh_remote_port, int ssh_time_out) {
        
        this.sshUser = ssh_user;
        this.sshPassword = ssh_password;
        this.sshHost = ssh_host;
        this.sshPort = ssh_port;
        this.sshLocalPort = ssh_local_port;
        this.sshRemoteHost = ssh_remote_host;
        this.sshRemotePort = ssh_remote_port;
        this.sshTimeOut = ssh_time_out;
        
        this.jsch = new JSch();
        
    }

    public static TunnelingSSH createInstance(String ssh_user, String ssh_password, String ssh_host, int ssh_port, int ssh_local_port, String ssh_remote_host, int ssh_remote_port, int ssh_time_out) {
        
        TunnelingSSH tunnelingSSH = new TunnelingSSH(ssh_user, ssh_password, ssh_host, ssh_port, ssh_local_port, ssh_remote_host, ssh_remote_port, ssh_time_out);

        return tunnelingSSH;
        
    }

    public void connectionSSH() throws JSchException, IOException {
        
        if(isSshDbEnabled()){
        
            log.info("Inicializando conexion SSH...");

            if(getSession()==null||!getSession().isConnected()){

                log.info("Sesion activada? "+(getSession()!=null));

                log.info("SSH HOST: "+getSshHost());

                log.info("SSH PORT: "+getSshPort());

                log.info("SSH USER: "+getSshUser());

                if(this.jsch ==null) {

                    this.jsch = new JSch();

                }

                setSession(getJsch().getSession(getSshUser(), getSshHost(), getSshPort()));

                getSession().setPassword(getSshPassword());

                log.info("Sesion activada? "+(getSession()!=null));

                final Properties config = new Properties();

                config.put("StrictHostKeyChecking", "no");

                getSession().setConfig(config);

                getSession().connect();

                //session.connect(time_out);

                log.info("Estableciendo reenvio de puerto...");

                boolean portforwardingreutilizado = false;

                if(getSession().getPortForwardingL()!=null&&getSession().getPortForwardingL().length>1){

                    for(String portforwadings : getSession().getPortForwardingL()){

                        log.debug("Buscando reenvio de puerto: "+portforwadings);

                        if(portforwadings.contains(String.valueOf(getSshLocalPort()))){

                            portforwardingreutilizado=true;

                            log.debug("Reutilizano reenvio de puerto: "+portforwadings);

                            break;

                        }

                    }

                }

                if(!portforwardingreutilizado){

                    log.info("SSH Local port: "+getSshLocalPort());

                    log.info("SSH Remote host: "+getSshRemoteHost());

                    log.info("SSH Remote port: "+getSshRemotePort());

                    getSession().setPortForwardingL(getSshLocalPort(), getSshRemoteHost(), getSshRemotePort());

                }

                log.info("Conexion SSH establecida");

            }else{

                log.info("Reutilizando conexion SSH establecida anteriormente");

            }

        }else{
            
            log.info("Tunneling SSH desactivado");
            
        }

    }

    public void disconnectionSSH() {
        
        if(isSshDbEnabled()){
        
            log.info("Inicializando desconexion SSH...");

            if (getSession() != null) {

                log.info("Eliminando reenvio de puerto: "+getSshLocalPort());

                try {

                    getSession().delPortForwardingL(getSshLocalPort());

                } catch (JSchException ex) {

                    log.error("No se pudo eliminar el reenvio de puerto local: "+getSshLocalPort());

                }

                getSession().disconnect();

            }

            log.info("Desconexion SSH realizada con exito");
        
        }
    }

    /**
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * @return the jsch
     */
    public JSch getJsch() {
        return jsch;
    }

    /**
     * @param jsch the jsch to set
     */
    public void setJsch(JSch jsch) {
        this.jsch = jsch;
    }

    /**
     * @return the sshUser
     */
    public String getSshUser() {
        return sshUser;
    }

    /**
     * @param sshUser the sshUser to set
     */
    public void setSshUser(String sshUser) {
        this.sshUser = sshUser;
    }

    /**
     * @return the sshPassword
     */
    public String getSshPassword() {
        return sshPassword;
    }

    /**
     * @param sshPassword the sshPassword to set
     */
    public void setSshPassword(String sshPassword) {
        this.sshPassword = sshPassword;
    }

    /**
     * @return the sshHost
     */
    public String getSshHost() {
        return sshHost;
    }

    /**
     * @param sshHost the sshHost to set
     */
    public void setSshHost(String sshHost) {
        this.sshHost = sshHost;
    }

    /**
     * @return the sshPort
     */
    public int getSshPort() {
        return sshPort;
    }

    /**
     * @param sshPort the sshPort to set
     */
    public void setSshPort(int sshPort) {
        this.sshPort = sshPort;
    }

    /**
     * @return the sshLocalPort
     */
    public int getSshLocalPort() {
        return sshLocalPort;
    }

    /**
     * @param sshLocalPort the sshLocalPort to set
     */
    public void setSshLocalPort(int sshLocalPort) {
        this.sshLocalPort = sshLocalPort;
    }

    /**
     * @return the sshRemoteHost
     */
    public String getSshRemoteHost() {
        return sshRemoteHost;
    }

    /**
     * @param sshRemoteHost the sshRemoteHost to set
     */
    public void setSshRemoteHost(String sshRemoteHost) {
        this.sshRemoteHost = sshRemoteHost;
    }

    /**
     * @return the sshRemotePort
     */
    public int getSshRemotePort() {
        return sshRemotePort;
    }

    /**
     * @param sshRemotePort the sshRemotePort to set
     */
    public void setSshRemotePort(int sshRemotePort) {
        this.sshRemotePort = sshRemotePort;
    }

    /**
     * @return the timeOut
     */
    public int getSshTimeOut() {
        return sshTimeOut;
    }

    /**
     * @param timeOut the timeOut to set
     */
    public void setSshTimeOut(int sshTimeOut) {
        this.sshTimeOut = sshTimeOut;
    }

    /**
     * @return the sshDbEnabled
     */
    public boolean isSshDbEnabled() {
        return sshDbEnabled;
    }

    /**
     * @param sshDbEnabled the sshDbEnabled to set
     */
    public void setSshDbEnabled(boolean sshDbEnabled) {
        this.sshDbEnabled = sshDbEnabled;
    }
}
