package com.example.proyecto_biblioteca.controller;

import com.example.proyecto_biblioteca.dto.dtoLoan.LoanDTORequest;
import com.example.proyecto_biblioteca.dto.dtoLoan.LoanDTOResponse;
import com.example.proyecto_biblioteca.dto.dtoLoan.LoanMapper;
import com.example.proyecto_biblioteca.dto.dtoMember.MemberDTOResponse;
import com.example.proyecto_biblioteca.dto.dtoMember.MemberMapper;
import com.example.proyecto_biblioteca.model.Loan;
import com.example.proyecto_biblioteca.model.Member;
import com.example.proyecto_biblioteca.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/search")
    public List<Loan> searchLoans(
            @RequestParam(name = "memberId", required = false) Integer memberId,
            @RequestParam(name = "memberName", required = false) String memberName) {
        if (memberId != null) {
            return loanService.getLoanHistoryByMemberId(memberId);
        } else if (memberName != null) {
            return loanService.getLoanHistoryByMemberName(memberName);
        } else {
            throw new IllegalArgumentException("Debe proporcionar un 'memberId' o un 'memberName' para buscar préstamos.");
        }
    }

    @PostMapping("/create")
    public Loan createLoan(@RequestParam LoanDTORequest loanDTORequest, @RequestParam Loan loan, @RequestParam int memberId, @RequestParam int bookId) {
//        Loan newLoan = LoanMapper.dtoToEntity(loanDTORequest, loan);
//        Loan createdLoan = loanService.createLoan(newLoan);
//        LoanDTOResponse newLoanDTO = LoanMapper.entityToDTO(createdLoan);
//
//        return new ResponseEntity<>(newLoanDTO, HttpStatus.CREATED);
        return loanService.createLoan(memberId, bookId);
    }

}
