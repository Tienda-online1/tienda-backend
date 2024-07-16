package com.tienda.domain.dtos;

import com.tienda.domain.entities.Role;
import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Role role;
}
