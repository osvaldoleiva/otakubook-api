package cl.otakubook.otakubookapi.services.impl;

import cl.otakubook.otakubookapi.dto.request.CarritoRequestDTO;
import cl.otakubook.otakubookapi.model.CarritoCompra;
import cl.otakubook.otakubookapi.model.Manga;
import cl.otakubook.otakubookapi.repositories.CarritoCompraRepository;
import cl.otakubook.otakubookapi.services.CarritoCompraService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarritoCompraServiceImpl implements CarritoCompraService {

  private final CarritoCompraRepository carritoCompraRepository;

  public CarritoCompraServiceImpl(CarritoCompraRepository carritoCompraRepository) {
    this.carritoCompraRepository = carritoCompraRepository;
  }

  @Override
  public CarritoCompra guardarCarritoCompra(CarritoCompra carritoCompra) {
    return carritoCompraRepository.save(carritoCompra);
  }

  @Override
  public CarritoCompra obtenerCarritoCompraPorId(Long idCarritoCompra) {
    return carritoCompraRepository.findById(idCarritoCompra).orElse(null);
  }

  @Override
  public List<CarritoCompra> obtenerTodosLosCarritoCompras() {
    return carritoCompraRepository.findAll();
  }


}
