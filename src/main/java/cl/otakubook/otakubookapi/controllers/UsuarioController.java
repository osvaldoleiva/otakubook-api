package cl.otakubook.otakubookapi.controllers;

import cl.otakubook.otakubookapi.dto.UsuarioDTO;
import cl.otakubook.otakubookapi.dto.response.UsuarioCuentaDTO;
import cl.otakubook.otakubookapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioCuentaDTO> crearUsuarioConCuenta(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        UsuarioCuentaDTO response = usuarioService.guardarUsuarioConCuenta(usuarioDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
