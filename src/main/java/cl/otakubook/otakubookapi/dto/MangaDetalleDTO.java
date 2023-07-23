package cl.otakubook.otakubookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MangaDetalleDTO {
  private Long idManga;
  private String titulo;
  private int cantidad;
  private BigDecimal precio;
}
