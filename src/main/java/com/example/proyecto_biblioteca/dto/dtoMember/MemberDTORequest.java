package com.example.proyecto_biblioteca.dto.dtoMember;

public record MemberDTORequest(
        String name,
        String surname,
        String email,
        Boolean isActive
) {
}
