/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.LaborMaquinaria;
import com.chinchilla.persistence.objects.LaborParcela;
import com.chinchilla.persistence.objects.LaborPersonal;
import com.chinchilla.persistence.objects.LaborProducto;
import com.chinchilla.persistence.objects.Parcela;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public interface LaborMappers {

    Labor getLabor(Integer id_labor);

    ArrayList getAllLabor();

    Labor getLaborPorNombre();

    int createLabor(Labor labor);

    int updateLabor(Labor labor);

    int deleteLabor(Integer id_labor);
    
    ArrayList getLaborFilteredByParcela(Integer id_parcela);

    int createLaborMaquinaria(List<LaborMaquinaria> laborMaquinariaList);

    int deleteLaborMaquinaria(Integer id_labor);

    int createLaborPersonal(List<LaborPersonal> laborPersonalList);

    int deleteLaborPersonal(Integer id_labor);

    int createLaborParcela(List<LaborParcela> laborParcelaList);

    int deleteLaborParcela(Integer id_labor);

    int createLaborProducto(List<LaborProducto> laborProductoList);

    int deleteLaborProducto(Integer id_labor);
}
