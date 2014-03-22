/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Meteorologia;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface MeteorologiaMappers {
    
    Meteorologia getMeteorologia(Integer meteorologia);

    ArrayList getAllMeteorologia();

    Meteorologia getFilteredMeteorologia();

    int createMeteorologia(Meteorologia meteorologia);

    int updateMeteorologia(Meteorologia meteorologia);

    int deleteMeteorologia(Integer meteorologia);
    
}
