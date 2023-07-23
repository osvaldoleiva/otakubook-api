package cl.otakubook.otakubookapi.services.impl;

import cl.otakubook.otakubookapi.model.Categoria;
import cl.otakubook.otakubookapi.repositories.CategoriaRepository;
import cl.otakubook.otakubookapi.services.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

  private final CategoriaRepository categoriaRepository;

  public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
  }

  @Override
  public Categoria guardarCategoria(Categoria Categoria) {
    return categoriaRepository.save(Categoria);
  }

  @Override
  public Categoria obtenerCategoriaPorId(int idCategoria) {
    return categoriaRepository.findById(idCategoria).orElse(null);
  }

  @Override
  public List<Categoria> obtenerTodosLosCategorias() {
    return categoriaRepository.findAll();
  }
  // Implementación de métodos de servicio relacionados con categorías
}
