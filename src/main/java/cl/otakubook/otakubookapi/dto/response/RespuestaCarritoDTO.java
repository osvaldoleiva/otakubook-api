package cl.otakubook.otakubookapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaCarritoDTO {
    private int idCarrito;
    private Long idUsuario;
    private List<Long> idMangas;
    private int cantidad;
}

