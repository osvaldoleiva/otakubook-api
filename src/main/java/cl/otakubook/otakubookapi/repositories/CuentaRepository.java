package cl.otakubook.otakubookapi.repositories;

import cl.otakubook.otakubookapi.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
