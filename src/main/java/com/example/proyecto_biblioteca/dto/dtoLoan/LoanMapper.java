package com.example.proyecto_biblioteca.dto.dtoLoan;

import com.example.proyecto_biblioteca.model.Loan;

public class LoanMapper {
    //dtoToEntity
    public static Loan dtoToEntity(LoanDTORequest loanDTORequest, Loan loan) {
        return new Loan(loanDTORequest.member(), loanDTORequest.book(), loan.getLoanDate(), loan.getReturnDate());
    }

    //entityToDTO
    public static LoanDTOResponse entityToDTO(Loan loan) {
        return new LoanDTOResponse(loan.getMember(), loan.getBook(), loan.getLoanDate(), loan.getReturnDate());
    }
}
