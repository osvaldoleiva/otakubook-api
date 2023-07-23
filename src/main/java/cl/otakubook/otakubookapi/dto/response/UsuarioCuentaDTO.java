package cl.otakubook.otakubookapi.dto.response;

import cl.otakubook.otakubookapi.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioCuentaDTO {

  private Long idUsuario;
  private String nombre;
  private String email;
  private TipoUsuario tipoUsuario;
  private Long idCuenta;
  private double saldo;


}
