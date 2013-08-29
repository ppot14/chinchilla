/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Parcela;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface ParcelaMappers {

    Parcela getParcela(Integer id_parcela);

    ArrayList getAllParcela();

    Parcela getParcelaPorNombre();

    int createParcela(Parcela parcela);

    int updateParcela(Parcela parcela);

    int deleteParcela(Integer id_parcela);
}
