package cl.otakubook.otakubookapi.services;

import cl.otakubook.otakubookapi.model.Cuenta;

import java.util.List;

public interface CuentaService {
    Cuenta guardarCuenta(Cuenta cuenta);
    Cuenta obtenerCuentaPorId(Long idCuenta);
    List<Cuenta> obtenerTodasLasCuentas();
    // Otros métodos de servicio relacionados con cuentas
}
