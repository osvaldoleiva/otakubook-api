package cl.otakubook.otakubookapi.services;

import cl.otakubook.otakubookapi.model.Categoria;

import java.util.List;

public interface CategoriaService {

  Categoria guardarCategoria(Categoria Categoria);
  Categoria obtenerCategoriaPorId(int idCategoria);
  List<Categoria> obtenerTodosLosCategorias();
  // Otros métodos de servicio relacionados con Categorias

}
