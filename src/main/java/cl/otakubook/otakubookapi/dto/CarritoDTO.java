package cl.otakubook.otakubookapi.dto;

import cl.otakubook.otakubookapi.dto.request.DetalleCarritoRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {
  private Long idUsuario;
  private List<DetalleCarritoRequestDTO> detalles;
}
