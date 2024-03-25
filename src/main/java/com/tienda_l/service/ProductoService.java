package com.tienda_l.service;

import com.tienda_l.domain.Producto;
import java.util.List;

public interface ProductoService {

    //Se obtiene un arraylist de objetos tipo Producto
    public List<Producto> getProductos(boolean activos);

    //Se obtiene un objeto Producto a partir del 
    //idProducto que nos pasan
    public Producto getProducto(Producto producto);

    //se hace lo siguiente:
    //  Si idProducto tiene un valor se actualiza
    //  Si idCategori NO tiene un valor se inserta
    public void saveProducto(Producto producto);

    //Se elimina un registro de la tabla producto 
    //a partir del idProducto que nos pasan
    public void deleteProducto(Producto producto);

    //Esta consulta ampliada utiliza método @Query
    public List<Producto> metodoQuery(double precioInf, double precioSup);

    //Esta consulta ampliada utiliza método lenguaje JPQL
    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    //Esta consulta ampliada utiliza método lenguaje SQL
    public List<Producto> metodoNativo(double precioInf, double precioSup);

}
