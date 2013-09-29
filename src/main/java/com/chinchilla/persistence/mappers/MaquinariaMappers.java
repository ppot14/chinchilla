/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Maquinaria;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface MaquinariaMappers {

    Maquinaria getMaquinaria(Integer id_coste_maquinaria);

    ArrayList getAllMaquinaria();

    Maquinaria getMaquinariaPorNombre();

    int createMaquinaria(Maquinaria maquinaria);

    int updateMaquinaria(Maquinaria maquinaria);

    int deleteMaquinaria(Integer id_coste_maquinaria);
}
