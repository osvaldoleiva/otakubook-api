package cl.otakubook.otakubookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CrearCuentaDTO {

  private int idUsuario;
  private double saldo;

  public int getIdUsuario() {
      return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
      this.idUsuario = idUsuario;
  }

  public double getSaldo() {
      return saldo;
  }

  public void setSaldo(double saldo) {
      this.saldo = saldo;
  }

}
