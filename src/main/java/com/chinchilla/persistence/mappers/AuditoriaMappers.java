/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Auditoria;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface AuditoriaMappers {
    
    Auditoria getAuditoria(Integer id_auditoria);

    ArrayList getAllAuditoria();

    Auditoria getFilteredAuditoria();

    int createAuditoria(Auditoria auditoria);

    int updateAuditoria(Auditoria auditoria);

    int deleteAuditoria(Integer id_auditoria);
    
}
