package cl.otakubook.otakubookapi.services.impl;

import cl.otakubook.otakubookapi.dto.UsuarioDTO;
import cl.otakubook.otakubookapi.dto.response.UsuarioCuentaDTO;
import cl.otakubook.otakubookapi.model.Cuenta;
import cl.otakubook.otakubookapi.model.Usuario;
import cl.otakubook.otakubookapi.repositories.CuentaRepository;
import cl.otakubook.otakubookapi.repositories.UsuarioRepository;
import cl.otakubook.otakubookapi.services.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final CuentaRepository cuentaRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, CuentaRepository cuentaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public UsuarioCuentaDTO guardarUsuarioConCuenta(UsuarioDTO usuarioDTO) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(usuarioDTO.getNombre());
        nuevoUsuario.setEmail(usuarioDTO.getEmail());
        nuevoUsuario.setContraseña(usuarioDTO.getContraseña());
        nuevoUsuario.setTipoUsuario(usuarioDTO.getTipoUsuario());

        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);

        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setIdUsuario(usuarioGuardado.getIdUsuario()); // Asociamos la nueva cuenta con el usuario guardado
        nuevaCuenta.setSaldo(0); // O cualquier valor predeterminado que desees para el saldo inicial

        cuentaRepository.save(nuevaCuenta);

        // Crear y retornar el DTO de respuesta con la información del usuario y la cuenta
        UsuarioCuentaDTO respuestaUsuarioDTO = new UsuarioCuentaDTO(
                usuarioGuardado.getIdUsuario(),
                usuarioGuardado.getNombre(),
                usuarioGuardado.getEmail(),
                usuarioGuardado.getTipoUsuario(),
                nuevaCuenta.getIdCuenta(),
                nuevaCuenta.getSaldo()
        );

        return respuestaUsuarioDTO;
    }
}
