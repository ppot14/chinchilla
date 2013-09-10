/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.TipoLabor;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface TipoLaborMappers {

    TipoLabor getTipoLabor(Integer id_tipo_labor);

    ArrayList getAllTipoLabor();

    TipoLabor getTipoLaborPorNombre();

    int createTipoLabor(TipoLabor labor);

    int updateTipoLabor(TipoLabor labor);

    int deleteTipoLabor(Integer id_tipo_labor);
}
