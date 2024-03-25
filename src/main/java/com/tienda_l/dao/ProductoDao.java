package com.tienda_l.dao;

import com.tienda_l.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends JpaRepository <Producto, Long>{
   
    //Esta consulta ampliada utiliza método @Query
    public List<Producto> 
            findByPrecioBetweenOrderByDescripcion(
                    double precioInf, 
                    double precioSup);
            
    //Esta consulta utiliza lenguaje JPQL
    @Query(value = "SELECT p FROM Producto p "
            + "WHERE p.precio "
            + "BETWEEN :precioInf and :precioSup "
            + "ORDER BY p.descripcion ASC")
    public List<Producto> metodoJPQL(
            @Param("precioInf") double precioInf,
            @Param("precioSup") double precioSup);
    
    //Esta consulta utiliza lenguaje SQL nativo
    @Query(nativeQuery=true,
            value = "SELECT * FROM producto p "
            + "WHERE p.precio "
            + "BETWEEN :precioInf and :precioSup "
            + "ORDER BY p.descripcion ASC")
    public List<Producto> metodoNativo(
            @Param("precioInf") double precioInf,
            @Param("precioSup") double precioSup);
    
}














