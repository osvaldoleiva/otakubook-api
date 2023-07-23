package cl.otakubook.otakubookapi.services;

import cl.otakubook.otakubookapi.dto.UsuarioDTO;
import cl.otakubook.otakubookapi.dto.response.UsuarioCuentaDTO;
import cl.otakubook.otakubookapi.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Long idUsuario);
    List<Usuario> obtenerTodosLosUsuarios();

    UsuarioCuentaDTO guardarUsuarioConCuenta(UsuarioDTO usuarioDTO);
}

