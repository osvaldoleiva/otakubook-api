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
public class MangaDTO {

  private String titulo;
  private String autor;
  private String descripcion;
  private BigDecimal precio;
  private int stock;
}
