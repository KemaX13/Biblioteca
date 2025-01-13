package com.example.proyecto_biblioteca.dto.dtoLoan;

import com.example.proyecto_biblioteca.model.Book;
import com.example.proyecto_biblioteca.model.Member;

public record LoanDTORequest(
        Member member,
        Book book
) {
}
