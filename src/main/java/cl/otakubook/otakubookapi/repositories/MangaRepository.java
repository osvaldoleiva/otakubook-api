package cl.otakubook.otakubookapi.repositories;

import cl.otakubook.otakubookapi.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Long> {

  Manga findByTitulo(String titulo);

}
