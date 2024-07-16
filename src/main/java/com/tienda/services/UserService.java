package com.tienda.services;

import com.tienda.domain.dtos.LoginDto;
import com.tienda.domain.dtos.UserRequestDto;
import com.tienda.domain.dtos.UserResponseDto;
import com.tienda.domain.entities.UsuarioEntity;
import com.tienda.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {


    private PasswordEncoder passwordEncoder;
    private UsuarioRepository usuarioRepository;

    public UserResponseDto register(UserRequestDto userRequestDto) {

        //Se arma un objeto entidad para almacenar en la bd
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsername(userRequestDto.getUsername());
        usuario.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        usuario.setRole(userRequestDto.getRole());

        //Se hace el guardado en la base de datos
        UsuarioEntity usuarioGuardado = this.usuarioRepository.save(usuario);

        //Se arma la respuesta para pasarla al controlador
        UserResponseDto respuesta = new UserResponseDto();
        respuesta.setUsername(usuarioGuardado.getUsername());
        respuesta.setRole(usuarioGuardado.getRole().name());
        return respuesta;
    }

    public UserResponseDto login(LoginDto loginDto) {
        UsuarioEntity usuario = this.usuarioRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        if (!passwordEncoder.matches(loginDto.getPassword(), usuario.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        UserResponseDto respuesta = new UserResponseDto();
        respuesta.setUsername(usuario.getUsername());
        respuesta.setRole(usuario.getRole().name());

        return respuesta;
    }
}
