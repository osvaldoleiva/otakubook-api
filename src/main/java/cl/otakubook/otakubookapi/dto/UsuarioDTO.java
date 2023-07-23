package cl.otakubook.otakubookapi.dto;

import cl.otakubook.otakubookapi.enums.TipoUsuario;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDTO {

  @NotNull(message = "El nombre no puede estar vacio")
  private String nombre;

  @NotNull(message = "El email no puede estar vacio")
  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Debe ser una dirección de correo válida")
  private String email;

  @NotBlank(message = "La contraseña no puede estar vacia")
  private String contraseña;

  @NotNull(message = "El tipo de usuario no debe ser nulo")
  private TipoUsuario tipoUsuario;

}
