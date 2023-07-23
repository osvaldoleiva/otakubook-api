package cl.otakubook.otakubookapi.controllers;

import cl.otakubook.otakubookapi.dto.MangaDTO;
import cl.otakubook.otakubookapi.dto.response.MangaResponseDTO;
import cl.otakubook.otakubookapi.model.Manga;
import cl.otakubook.otakubookapi.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/manga")
public class MangaController {

  private final MangaService mangaService;

  @Autowired
  public MangaController(MangaService mangaService) {
      this.mangaService = mangaService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Manga>> getAllMangas() {
      List<Manga> mangas = mangaService.obtenerTodosLosMangas();
      return new ResponseEntity<>(mangas, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Manga> getMangaById(@PathVariable Long id) {
      Manga manga = mangaService.obtenerMangaPorId(id);
      if (manga == null) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(manga, HttpStatus.OK);
  }

  @GetMapping("/nombre/{nombre}")
  public ResponseEntity<Manga> getMangaByNombre(@PathVariable String nombre) {
      Manga manga = mangaService.obtenerMangaPorTitulo(nombre);
      if (manga == null) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(manga, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MangaResponseDTO> agregarManga(@RequestBody MangaDTO mangaDTO) {
      Manga manga = new Manga();
      manga.setTitulo(mangaDTO.getTitulo());
      manga.setAutor(mangaDTO.getAutor());
      manga.setDescripcion(mangaDTO.getDescripcion());
      manga.setPrecio(mangaDTO.getPrecio());
      manga.setStock(mangaDTO.getStock());

      Manga mangaGuardado = mangaService.guardarManga(manga);

      MangaResponseDTO respuestaDTO = new MangaResponseDTO(mangaGuardado.getIdManga(), mangaGuardado.getTitulo());
      return new ResponseEntity<>(respuestaDTO, HttpStatus.CREATED);
  }

  @GetMapping("/manga-mes/{mes}")
  public ResponseEntity<Manga> getMangaDelMes(@PathVariable String mes) {
      Manga manga = mangaService.obtenerMangaDelMes(mes);
      if (manga == null) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(manga, HttpStatus.OK);
  }

  @PostMapping("/cargar-mangas-mes")
  public ResponseEntity<Void> cargarMangasDelMes() {
      mangaService.cargarMangasDelMes();
      return new ResponseEntity<>(HttpStatus.OK);
  }

}
