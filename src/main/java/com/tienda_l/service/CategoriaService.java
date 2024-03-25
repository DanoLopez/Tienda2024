package com.tienda_l.service;

import com.tienda_l.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Se obtiene un arraylist de objetos tipo Categoria
    public List<Categoria> getCategorias(boolean activos);
    
    //Se obtiene un objeto Categoria a partir del 
    //idCategoria que nos pasan
    public Categoria getCategoria(Categoria categoria);
    
    //se hace lo siguiente:
    //  Si idCategoria tiene un valor se actualiza
    //  Si idCategori NO tiene un valor se inserta
    public void saveCategoria(Categoria categoria);
    
    //Se elimina un registro de la tabla categoria 
    //a partir del idCategoria que nos pasan
    public void deleteCategoria(Categoria categoria);
    
}
