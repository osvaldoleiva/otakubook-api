package cl.otakubook.otakubookapi.repositories;

import cl.otakubook.otakubookapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Consultas personalizadas relacionadas con usuarios
}

