package cl.otakubook.otakubookapi.dto.request;

import cl.otakubook.otakubookapi.dto.MangaDetalleDTO;
import cl.otakubook.otakubookapi.model.DetalleCarrito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarritoRequestDTO {
  private Long idUsuario;
  private Long idCarrito;
  private List<DetalleCarrito> mangasAgregados;
}
