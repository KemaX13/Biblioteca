package com.example.proyecto_biblioteca.dto.dtoLoan;

import com.example.proyecto_biblioteca.model.Book;
import com.example.proyecto_biblioteca.model.Member;

import java.time.LocalDate;

public record LoanDTOResponse(
        Member member,
        Book book,
        LocalDate loanDate,
        LocalDate returnDate
) {
}
