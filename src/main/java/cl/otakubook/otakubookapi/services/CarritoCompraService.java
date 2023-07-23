package cl.otakubook.otakubookapi.services;

import cl.otakubook.otakubookapi.dto.request.CarritoRequestDTO;
import cl.otakubook.otakubookapi.model.CarritoCompra;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarritoCompraService {

  CarritoCompra guardarCarritoCompra(CarritoCompra CarritoCompra);
  CarritoCompra obtenerCarritoCompraPorId(Long idCarritoCompra);
  List<CarritoCompra> obtenerTodosLosCarritoCompras();
  // Otros métodos de servicio relacionados con CarritoCompras

}
