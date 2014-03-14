/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.OrdenCompra;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface OrdenCompraMappers {

    OrdenCompra getOrdenCompra(Integer id_orden_compra);

    ArrayList getAllOrdenCompra();

    OrdenCompra getOrdenCompraPorNombre();

    int createOrdenCompra(OrdenCompra coste_personal);

    int updateOrdenCompra(OrdenCompra coste_personal);

    int deleteOrdenCompra(Integer id_orden_compra);
}
