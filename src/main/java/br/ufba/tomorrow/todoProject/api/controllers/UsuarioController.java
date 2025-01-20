package br.ufba.tomorrow.todoProject.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.tomorrow.todoProject.api.dto.UsuarioCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.UsuarioDTO;
import br.ufba.tomorrow.todoProject.domain.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    public final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioCreateDTO dto) {
        return new ResponseEntity<UsuarioDTO>(service.criar(dto), HttpStatus.OK);
    }
}

