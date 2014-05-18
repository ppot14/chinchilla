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
import com.chinchilla.persistence.objects.Electricidad;
import com.chinchilla.persistence.objects.Labor;
import com.chinchilla.persistence.objects.LaborMaquinaria;
import com.chinchilla.persistence.objects.LaborPersonal;
import com.chinchilla.persistence.objects.LaborProducto;
import com.chinchilla.persistence.objects.Maquinaria;
import com.chinchilla.persistence.objects.OrdenCompra;
import com.chinchilla.persistence.objects.Producto;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pepe
 */
public class UtilFormulas {
    
    private static final Logger log = (Logger) LoggerFactory.getLogger(UtilFormulas.class);
    
    //TODO redefinir constantes en la base de datos y otros recalcular;
    //Constantes maquinaria
    private static final double PRECIO_LITRO_ACEITE = 2.6;
    private static final double PRECIO_LITRO_GASOIL = 0.61;
    
    //Constantes personal
    private static final double CONTINGENCIAS_COMUNES = 0.1595;
    private static final double DESEMPLEO = 0.067;
    private static final double F_G_S = 0.001;
    private static final double FORMACION_PROFESIONAL = 0.0015;
    private static final double A_T_y_E_P = 0.026;
    private static final double PRECIO_KM = 0.25;
    private static final double PAGA_ANTIGUEDAD = 1423;
    private static final double VACACIONES = 683.1;
    private static final double HORAS_EXTRA = 120;
    private static final double PRECIO_HORAS_EXTRA = 12.56;
    
    //Constantes electricidad
    private static final double IVA = 0.21;
    private static final double POTENCIA_CONTRATADA = 10.392;
    private static final double DIAS = 75;
    private static final double IMPUESTO_ELECTRICIDA = 0.051127;
    
    public static double costeHoraMaquinaria(Maquinaria maq){
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
        
//        log.trace("costeHoraMaquinaria - totalAmortizacion: "+totalAmortizacion);
//        
//        log.trace("costeHoraMaquinaria - totalIntereses: "+totalIntereses);
//        
//        log.trace("costeHoraMaquinaria - totalReparaciones: "+totalReparaciones);
//        
//        log.trace("costeHoraMaquinaria - totalAlojamiento: "+totalAlojamiento);
//        
//        log.trace("costeHoraMaquinaria - totalPrimaSeguro: "+totalPrimaSeguro);
//        
//        log.trace("costeHoraMaquinaria - totalConsumoGasoleoElectricidad: "+totalConsumoGasoleoElectricidad);
//        
//        log.trace("costeHoraMaquinaria - totalAceitesGrasas: "+totalAceitesGrasas);
        
        costeHora = totalAceitesGrasas+
                    totalConsumoGasoleoElectricidad+
                totalPrimaSeguro+
                totalAlojamiento+
                totalReparaciones+
                totalIntereses+
                totalAmortizacion;
        
        log.trace("costeHoraMaquinaria "+maq.getNombre()+" costeHora: "+costeHora);
        
        return costeHora;
        
    }
    
    public static double costeLabor(List<OrdenCompra> registros, Labor labor){
        
        return costeLabor(registros, null, labor, null);
        
    }
    
    public static double costeLabor(List<OrdenCompra> registros, List<Electricidad> electricidad, Labor labor, List<Labor> labores){
        
        double costeTotalLabor;
        
        double costePersonalTotal = 0;
        
        for(LaborPersonal laborPersonal : labor.getLabor_personal()){
            
            costePersonalTotal += costeHoraPersonal(laborPersonal.getCoste_personal());
            
        }
        
        log.trace("costePersonalTotal: "+costePersonalTotal);
        
        double costeMaquinariaTotal = 0;
        
        for(LaborMaquinaria laborMaquinaria : labor.getLabor_maquinaria()){
            
            costeMaquinariaTotal += costeHoraMaquinaria(laborMaquinaria.getMaquinaria());
            
            //Only for Irrigations, it will include electricity cost
            if(laborMaquinaria.getMaquinaria().getId_coste_maquinaria() == 5000028 &&
                    electricidad!=null && !electricidad.isEmpty()){
                
                costeMaquinariaTotal += costeElectricidadPorFecha(electricidad, labor.getFecha_comienzo(), labores)/labor.getDuracion();
                
            }
            
        }
        
        log.trace("costeMaquinariaTotal: "+costeMaquinariaTotal);
        
        double costeProductoTotal = 0;
        
        for(LaborProducto laborProducto : labor.getLabor_producto()){
            
            costeProductoTotal += costeProducto(registros, labor.getFecha_comienzo(), laborProducto.getProducto())*
                                    laborProducto.getMultiplicador();
            
        }
        
        log.trace("costeProductoTotal: "+costeProductoTotal);
        
        double costeTotalGasoil = costeGasoil(registros, labor)*labor.getLitros_gasoil();
        
        log.trace("costeTotalGasoil: "+costeTotalGasoil);
        
        costeTotalLabor = costePersonalTotal*labor.getDuracion() + 
                        costeMaquinariaTotal*labor.getDuracion() + 
                        costeProductoTotal +
                        costeTotalGasoil +
                        labor.getCoste_fijo_total();
        
        log.trace("costeTotalLabor: "+costeTotalLabor);
        
        return costeTotalLabor;
    }
    
    public static double costeElectricidadPorFecha(List<Electricidad> electricidad, Date fecha_electricidad, List<Labor> labores){
        
        for(Electricidad elecItem : electricidad){
            
            Calendar c = Calendar.getInstance(); 
            c.setTime(elecItem.getFecha_fin()); 
            c.add(Calendar.DATE, 1);
            Date diaDespuesFechaFin = c.getTime();
            
            if(elecItem.getFecha_inicio().before( fecha_electricidad ) &&
                     fecha_electricidad.before(diaDespuesFechaFin)){
                
                double costeElectricidad = costeElectricidad(elecItem)/
                              horasRiego(elecItem.getFecha_inicio(),elecItem.getFecha_fin(),labores);//Dividir entre el total de horas de riego en el periodo
           
                log.trace("costeElectricidad: "+costeElectricidad+" fecha "+fecha_electricidad);
                
                return costeElectricidad;
                
            }
            
        }
        
        log.warn("Electricidad no encontrada para fecha "+fecha_electricidad);
        
        return 0;
        
    }
    
    public static double costeElectricidad(Electricidad elecItem){
        
        double consumoElectricidad = elecItem.getConsumo()*elecItem.getPrecio_kw();

        double totalPotencia = elecItem.getPrecio_potencia()*DIAS*POTENCIA_CONTRATADA;

        double totalImpuestos = (consumoElectricidad+totalPotencia)*IMPUESTO_ELECTRICIDA;

        double totalIva= (consumoElectricidad+totalImpuestos)*elecItem.getIva();
        
        return (totalIva + totalImpuestos +consumoElectricidad);
        
    }
    
    public static double horasRiego(Date desde, Date hasta, List<Labor> labores){
        
        double horasDeRiego = 0;
            
        Calendar c = Calendar.getInstance(); 
        c.setTime(hasta); 
        c.add(Calendar.DATE, 1);
        Date diaDespuesFechaFin = c.getTime();
        
        for(Labor l : labores){
            
            if(l.getFecha_comienzo().after(desde) &&
                l.getFecha_comienzo().before(diaDespuesFechaFin)){
                
                for(LaborMaquinaria lm : l.getLabor_maquinaria()){
                    
                    if(lm.getMaquinaria().getId_coste_maquinaria() == 5000028){
                        
                        horasDeRiego += l.getDuracion();
                        
                    }
                    
                }
                    
            }
            
        }
        
        log.trace("horasDeRiego: "+horasDeRiego+" del "+desde+" al "+hasta);
        
        return horasDeRiego;
    }
    
    public static double costeProducto(List<OrdenCompra> registros, Date referencia, Producto producto){
        
        Date fechaMasReciente = new Date(0);
        
        double costeProducto = 0;
        
        for(OrdenCompra ordenCompra : registros){
            
            if( ordenCompra.getId_elemento() == producto.getId_producto() && 
                    ordenCompra.getFecha().after(fechaMasReciente) &&
                    ordenCompra.getFecha().before(referencia) ){
                
                costeProducto = ordenCompra.getPrecio()!=0 ? 
                                ordenCompra.getPrecio() : 
                                ordenCompra.getTotal()/ordenCompra.getCantidad();
                
                fechaMasReciente = ordenCompra.getFecha();
                
            }
            
        }
        
        log.trace("costeProducto: "+costeProducto+", producto: "+producto.getNombre());
        
        return costeProducto;
        
    }
    
    public static double costeGasoil(List<OrdenCompra> registros, Labor labor){
        
        Date fechaLabor = labor.getFecha_comienzo();
        
        Date fechaMasReciente = new Date(0);
        
        double precioGasoil = 0;
        
        for(OrdenCompra ordenCompra : registros){
            
            if( ordenCompra.getId_elemento() == 3000084 && 
                    ordenCompra.getFecha().after(fechaMasReciente) &&
                    ordenCompra.getFecha().before(fechaLabor) ){
                
                precioGasoil = ordenCompra.getPrecio()!=0 ? 
                                ordenCompra.getPrecio() : 
                                ordenCompra.getTotal()/ordenCompra.getCantidad();
                
                fechaMasReciente = ordenCompra.getFecha();
                
            }
            
        }
        
        log.trace("precioGasoil: "+precioGasoil+", fechaLabor: "+fechaLabor);
        
        return precioGasoil;
        
    }
    
    public static double costeHoraPersonal(CostePersonal per){
        
        double costeHora, totalPersonal, totalSeguridadSocial, contingenciasComunes,
                desempleo, fgs, fp, atyep, km, pagasExtra, pagaAntiguedad, horasExtra,
                horasAnuales, salarioBase, vacaciones, plusDistancia;
        
        String tipo = per.getTipo();
        
        if("fijo".equalsIgnoreCase(tipo)){
            
            pagasExtra = per.getSalario_base()*90;
            
            pagaAntiguedad = PAGA_ANTIGUEDAD;
            
            horasExtra = HORAS_EXTRA * PRECIO_HORAS_EXTRA;
            
            vacaciones = VACACIONES;
            
            horasAnuales = per.getHoras_anuales();
            
            salarioBase = per.getSalario_base() * 365;
            
            totalPersonal = (pagasExtra + pagaAntiguedad + horasExtra + vacaciones + salarioBase)/horasAnuales;
            
        }else if("eventual".equalsIgnoreCase(tipo)){
            
            salarioBase = per.getSalario_base();
            
            plusDistancia = per.getPlus_distancia();
            
            km = PRECIO_KM * per.getKm();
            
            totalPersonal = (salarioBase + plusDistancia + km)/per.getHoras_dia();
            
        }else{
            
            totalPersonal = 0;
            
        }
        
        log.trace("costeHoraPersonal - "+per.getFuncion()+" totalPersonal: "+totalPersonal);
        
        contingenciasComunes = CONTINGENCIAS_COMUNES*per.getBase_ssp();
        
        desempleo = DESEMPLEO*per.getBase_ssp();
        
        fgs = F_G_S*per.getBase_ssp();
        
        fp = FORMACION_PROFESIONAL*per.getBase_ssp();
        
        atyep = A_T_y_E_P*per.getSalario_base();
        
        totalSeguridadSocial = contingenciasComunes + desempleo + fgs + fp + atyep;
        
        totalSeguridadSocial = totalSeguridadSocial / per.getHoras_dia();
        
        costeHora = totalPersonal + totalSeguridadSocial;
        
        log.trace("costeHoraPersonal - "+per.getFuncion()+" totalSeguridadSocial: "+totalSeguridadSocial);
        
        log.trace("costeHoraPersonal - "+per.getFuncion()+" costeHora: "+costeHora);
        
        return costeHora;
        
    }
    
}
