package cl.otakubook.otakubookapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleCarritoRequestDTO {

  private Long idManga;
  private int cantidad;

}
