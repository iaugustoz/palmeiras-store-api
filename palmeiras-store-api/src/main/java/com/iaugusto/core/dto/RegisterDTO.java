package com.iaugusto.core.dto;

import com.iaugusto.core.domains.enums.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}
