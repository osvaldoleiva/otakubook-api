package cl.otakubook.otakubookapi.services.impl;

import cl.otakubook.otakubookapi.model.Cuenta;
import cl.otakubook.otakubookapi.repositories.CuentaRepository;
import cl.otakubook.otakubookapi.services.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Cuenta guardarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta obtenerCuentaPorId(Long idCuenta) {
        return cuentaRepository.findById(idCuenta).orElse(null);
    }

    @Override
    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaRepository.findAll();
    }
}
