package cl.otakubook.otakubookapi.services;

import cl.otakubook.otakubookapi.model.Manga;

import java.util.List;

public interface MangaService {

  Manga guardarManga(Manga Manga);
  Manga obtenerMangaPorId(Long idManga);
  List<Manga> obtenerTodosLosMangas();
  // Otros métodos de servicio relacionados con Mangas

  Manga obtenerMangaPorTitulo(String nombre);

  Manga obtenerMangaDelMes(String mes);

  void cargarMangasDelMes();

}
