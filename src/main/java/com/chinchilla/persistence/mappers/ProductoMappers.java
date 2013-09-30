/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Producto;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface ProductoMappers {

    Producto getProducto(Integer id_producto);

    ArrayList getAllProducto();

    Producto getProductoPorNombre();

    int createProducto(Producto producto);

    int updateProducto(Producto producto);

    int deleteProducto(Integer id_producto);
}
