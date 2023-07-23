package cl.otakubook.otakubookapi.repositories;

import cl.otakubook.otakubookapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
