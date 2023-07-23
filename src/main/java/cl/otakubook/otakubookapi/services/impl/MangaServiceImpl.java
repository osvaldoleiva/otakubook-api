package cl.otakubook.otakubookapi.services.impl;

import cl.otakubook.otakubookapi.model.Manga;
import cl.otakubook.otakubookapi.repositories.MangaRepository;
import cl.otakubook.otakubookapi.services.MangaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

  private final MangaRepository mangaRepository;

  public MangaServiceImpl(MangaRepository mangaRepository) {
    this.mangaRepository = mangaRepository;
  }

  @Override
  public Manga guardarManga(Manga Manga) {
    return mangaRepository.save(Manga);
  }

  @Override
  public Manga obtenerMangaPorId(Long idManga) {
    return mangaRepository.findById(idManga).orElse(null);
  }

  @Override
  public List<Manga> obtenerTodosLosMangas() {
    return mangaRepository.findAll();
  }

  @Override
  public Manga obtenerMangaPorTitulo(String nombre) {
    return mangaRepository.findByTitulo(nombre);
  }

  @Override
  public Manga obtenerMangaDelMes(String mes) {
    if (mes.equals("enero")) {
      return mangaRepository.findByTitulo("Berserk");
    }
    if (mes.equals("febrero")) {
      return mangaRepository.findByTitulo("One Piece");
    }
    if (mes.equals("marzo")) {
      return mangaRepository.findByTitulo("Naruto");
    }
    if (mes.equals("abril")) {
      return mangaRepository.findByTitulo("Dragon Ball");
    }
    if (mes.equals("mayo")) {
      return mangaRepository.findByTitulo("Shingeki no Kyojin");
    }
    if (mes.equals("junio")) {
      return mangaRepository.findByTitulo("JoJo's Bizarre Adventure");
    }
    if (mes.equals("julio")) {
      return mangaRepository.findByTitulo("Black Clover");
    }
    if (mes.equals("agosto")) {
      return mangaRepository.findByTitulo("Boku no Hero Academia");
    }
    if (mes.equals("septiembre")) {
      return mangaRepository.findByTitulo("Death Note");
    }
    if (mes.equals("octubre")) {
      return mangaRepository.findByTitulo("Fullmetal Alchemist");
    }
    if (mes.equals("noviembre")) {
      return mangaRepository.findByTitulo("Hunter x Hunter");
    }
    if (mes.equals("diciembre")) {
      return mangaRepository.findByTitulo("Gintama");
    }
    return null;
  }

  @Override
  public void cargarMangasDelMes() {
    //carga 12 mangas en la base de datos con los titulos de los mangas del mes utilizando builder
    mangaRepository.save(Manga.builder()
            .titulo("Berserk")
            .autor("Kentaro Miura")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    //completa los siguientes mangas siguiendo la estructura de arriba
    mangaRepository.save(Manga.builder()
            .titulo("One Piece")
            .autor("Eiichiro Oda")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Naruto")
            .autor("Masashi Kishimoto")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Shingeki no Kyojin")
            .autor("Hajime Isayama")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Jojos Bizarre Adventure")
            .autor("Hiroyuki Araki")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Black Clover")
            .autor("Yuki Tabata")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Boku no Hero Academia")
            .autor("Kohei Horikoshi")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Death Note")
            .autor("Tsugumi Ohba y Takeshi Obata")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Fullmetal Alchemist")
            .autor("Hiromu Arakawa")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Hunter x Hunter")
            .autor("Yoshihiro Togashi")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());
    mangaRepository.save(Manga.builder()
            .titulo("Gintama")
            .autor("Hideaki Sorachi")
            .descripcion("")
            .precio(BigDecimal.valueOf(10000))
            .stock(100)
            .build());

  }

}
