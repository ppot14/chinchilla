/*
 * The MIT License
 *
 * Copyright 2013 Pepe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions -
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.chinchilla.util;

import com.chinchilla.persistence.objects.CostePersonal;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.Personal;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pepe
 */
public class UtilFormulas {
    
    private static Logger log = (Logger) LoggerFactory.getLogger(UtilFormulas.class);
    
    //TODO redefinir constantes en la base de datos y otros recalcular;
    private static double PRECIO_LITRO_ACEITE = 2.6;
    private static double PRECIO_LITRO_GASOIL = 0.61;
    private static double CONTINGENCIAS_COMUNES = 0.1595;
    private static double DESEMPLEO = 0.067;
    private static double F_G_S = 0.001;
    private static double FORMACION_PROFESIONAL = 0.0015;
    private static double A_T_y_E_P = 0.026;
    private static double PRECIO_KM = 0.25;
    private static double PAGA_ANTIGUEDAD = 1423;
    private static double VACACIONES = 683.1;
    private static double HORAS_EXTRA = 120;
    private static double PRECIO_HORAS_EXTRA = 12.56;
    
    public double costeHoraMaquinaria(Maquinaria maq){
        double costeHora, totalAmortizacion, totalIntereses, totalReparaciones, totalAlojamiento, 
                totalPrimaSeguro, totalConsumoGasoleoElectricidad, totalAceitesGrasas;
        
        totalAceitesGrasas = (maq.getLitros_aceite()*PRECIO_LITRO_ACEITE)
                               /maq.getHoras_cambio_aceite();
        
        totalConsumoGasoleoElectricidad = maq.getLitros_cv_y_hora()*maq.getCv()
                                        *PRECIO_LITRO_GASOIL;
        
        totalPrimaSeguro = (maq.getPrima_seguro()*(maq.getAnyos_mas_1()-1))
                            /maq.getHoras_trabajo();
        
        totalAlojamiento =  (maq.getAlojamiento_variable()*maq.getValor_compra()*(maq.getAnyos_mas_1()-1))
                            /maq.getHoras_trabajo();
        
        totalReparaciones =  maq.getReparacion_variable()*maq.getValor_compra()
                            /maq.getHoras_trabajo();
        
        totalIntereses =  ((maq.getValor_compra()/2)*maq.getInteres()*maq.getAnyos_mas_1())
                            /maq.getHoras_trabajo();
        
        totalAmortizacion = (maq.getValor_compra()-maq.getValor_desecho())
                            /maq.getHoras_trabajo();
        
        log.trace("costeHoraMaquinaria - totalAmortizacion: "+totalAmortizacion);
        
        log.trace("costeHoraMaquinaria - totalIntereses: "+totalIntereses);
        
        log.trace("costeHoraMaquinaria - totalReparaciones: "+totalReparaciones);
        
        log.trace("costeHoraMaquinaria - totalAlojamiento: "+totalAlojamiento);
        
        log.trace("costeHoraMaquinaria - totalPrimaSeguro: "+totalPrimaSeguro);
        
        log.trace("costeHoraMaquinaria - totalConsumoGasoleoElectricidad: "+totalConsumoGasoleoElectricidad);
        
        log.trace("costeHoraMaquinaria - totalAceitesGrasas: "+totalAceitesGrasas);
        
        costeHora = totalAceitesGrasas+
                    totalConsumoGasoleoElectricidad+
                totalPrimaSeguro+
                totalAlojamiento+
                totalReparaciones+
                totalIntereses+
                totalAmortizacion;
        
        log.trace("costeHoraMaquinaria - costeHora: "+costeHora);
        
        return costeHora;
        
    }
    
    public static double precioGasoil(Date fecha, List registros, List<Labor> labores){
        
        double precioGasoil = 0;
        
        
        
        return precioGasoil;
        
    }
    
    public double costeHoraMaquinaria(CostePersonal per){
        
        double costeHora, totalPersonal, totalSeguridadSocial, contingenciasComunes,
                desempleo, fgs, fp, atyep, km, pagasExtra, pagaAntiguedad, horasExtra,
                horasAnuales, salarioBase, vacaciones, plusDistancia;
        
        String tipo = per.getTipo();
        
        if(tipo.equalsIgnoreCase("fijo")){
            
            pagasExtra = per.getPaga_extra()*90;
            
            pagaAntiguedad = PAGA_ANTIGUEDAD;
            
            horasExtra = HORAS_EXTRA * PRECIO_HORAS_EXTRA;
            
            vacaciones = VACACIONES;
            
            horasAnuales = per.getHoras_anuales();
            
            salarioBase = per.getSalario_base() * 365;
            
            totalPersonal = pagasExtra + pagaAntiguedad + horasExtra + vacaciones +
                            horasAnuales + salarioBase;
            
        }else if(tipo.equalsIgnoreCase("eventual")){
            
            salarioBase = per.getSalario_base();
            
            plusDistancia = per.getPlus_distancia();
            
            km = PRECIO_KM * per.getKm();
            
            totalPersonal = (salarioBase + plusDistancia + km)/per.getHoras_dia();
            
        }else{
            
            totalPersonal = 0;
            
        }
        
        contingenciasComunes = CONTINGENCIAS_COMUNES*per.getBase_ssp();
        
        desempleo = DESEMPLEO*per.getBase_ssp();
        
        fgs = F_G_S*per.getBase_ssp();
        
        fp = FORMACION_PROFESIONAL*per.getBase_ssp();
        
        atyep = A_T_y_E_P*per.getSalario_base();
        
        totalSeguridadSocial = contingenciasComunes + desempleo + fgs + fp + atyep;
        
        totalSeguridadSocial = totalSeguridadSocial / per.getHoras_dia();
        
        costeHora = totalPersonal + totalSeguridadSocial;
        
        return costeHora;
        
    }
    
}
