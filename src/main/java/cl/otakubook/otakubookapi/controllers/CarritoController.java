package cl.otakubook.otakubookapi.controllers;

import cl.otakubook.otakubookapi.dto.CarritoDTO;
import cl.otakubook.otakubookapi.dto.MangaDetalleDTO;
import cl.otakubook.otakubookapi.dto.request.DetalleCarritoRequestDTO;
import cl.otakubook.otakubookapi.dto.response.CarritoRespuestaDTO;
import cl.otakubook.otakubookapi.model.CarritoCompra;
import cl.otakubook.otakubookapi.model.DetalleCarrito;
import cl.otakubook.otakubookapi.model.Manga;
import cl.otakubook.otakubookapi.model.Usuario;
import cl.otakubook.otakubookapi.services.CarritoCompraService;
import cl.otakubook.otakubookapi.services.MangaService;
import cl.otakubook.otakubookapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    private final CarritoCompraService carritoService;

    private final MangaService mangaService;

    private final UsuarioService usuarioService;

    @Autowired
    public CarritoController(CarritoCompraService carritoService, MangaService mangaService, UsuarioService usuarioService) {
        this.carritoService = carritoService;
        this.mangaService = mangaService;
        this.usuarioService = usuarioService;
    }

    @Transactional
    @PostMapping("/agregar-mangas")
    public ResponseEntity<?> agregarMangasAlCarrito(@RequestBody CarritoDTO carritoDTO) {
        Long idUsuario = carritoDTO.getIdUsuario();
        List<DetalleCarritoRequestDTO> detallesDTO = carritoDTO.getDetalles();

        Usuario usuario = usuarioService.obtenerUsuarioPorId(idUsuario);
        if (usuario == null) {
            return new ResponseEntity<>("El usuario con el ID proporcionado no existe", HttpStatus.BAD_REQUEST);
        }

        CarritoCompra carrito = new CarritoCompra();
        carrito.setIdUsuario(usuario.getIdUsuario());

        List<DetalleCarrito> detallesCarrito = new ArrayList<>();
        for (DetalleCarritoRequestDTO detalleDTO : detallesDTO) {
            Manga manga = mangaService.obtenerMangaPorId(detalleDTO.getIdManga());
            if (manga == null) {
                return new ResponseEntity<>("El manga con el ID " + detalleDTO.getIdManga() + " no existe", HttpStatus.BAD_REQUEST);
            }
            DetalleCarrito detalleCarrito = new DetalleCarrito();
            detalleCarrito.setCarrito(carrito);
            detalleCarrito.setManga(manga);
            detalleCarrito.setCantidad(detalleDTO.getCantidad());
            detallesCarrito.add(detalleCarrito);
        }

        // Calcular el total del valor de los mangas agregados al carrito
        BigDecimal totalValorMangas = BigDecimal.ZERO;
        for (DetalleCarritoRequestDTO detalleDTO : detallesDTO) {
            Manga manga = mangaService.obtenerMangaPorId(detalleDTO.getIdManga());
            if (manga != null) {
                totalValorMangas = totalValorMangas.add(manga.getPrecio().multiply(BigDecimal.valueOf(detalleDTO.getCantidad())));
            }
        }

        carrito.setDetalles(detallesCarrito);

        carritoService.guardarCarritoCompra(carrito);

        // Crear la lista de MangaDetalleDTO con los mangas agregados al carrito
        List<MangaDetalleDTO> mangasAgregadosDTO = new ArrayList<>();
        for (DetalleCarrito detalleCarrito : carrito.getDetalles()) {
            Manga manga = detalleCarrito.getManga();
            if (manga != null) {
                MangaDetalleDTO mangaDetalleDTO = new MangaDetalleDTO(manga.getIdManga(), manga.getTitulo(), detalleCarrito.getCantidad(), manga.getPrecio());
                mangasAgregadosDTO.add(mangaDetalleDTO);
            }
        }

        CarritoRespuestaDTO respuestaDTO = new CarritoRespuestaDTO(carrito.getIdCarrito(), mangasAgregadosDTO, totalValorMangas);
        return new ResponseEntity<>(respuestaDTO, HttpStatus.CREATED);
    }


}