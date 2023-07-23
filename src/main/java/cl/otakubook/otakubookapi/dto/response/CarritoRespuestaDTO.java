package cl.otakubook.otakubookapi.dto.response;

import cl.otakubook.otakubookapi.dto.MangaDetalleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarritoRespuestaDTO {

  private Long idCarrito;
  private List<MangaDetalleDTO> mangasAgregados;
  private BigDecimal totalValor;


}
