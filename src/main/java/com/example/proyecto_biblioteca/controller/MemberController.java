package com.example.proyecto_biblioteca.controller;

import com.example.proyecto_biblioteca.dto.dtoMember.MemberDTORequest;
import com.example.proyecto_biblioteca.dto.dtoMember.MemberDTOResponse;
import com.example.proyecto_biblioteca.dto.dtoMember.MemberMapper;
import com.example.proyecto_biblioteca.model.Member;
import com.example.proyecto_biblioteca.service.LoanService;
import com.example.proyecto_biblioteca.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService, LoanService loanService) {
        this.memberService = memberService;
    }

    // Encontrar miembros
    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberService.getAll();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> findMemberById(@PathVariable int id) {
        return memberService.findMember(id)
                .map(member -> new ResponseEntity<>(member, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/members/name/{name}")
    public ResponseEntity<Member> findMemberByName(@PathVariable String name) {
        return memberService.findMember(name)
                .map(member -> new ResponseEntity<>(member, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear miembro
    @PostMapping("/members")
    public ResponseEntity<MemberDTOResponse> createMembers(@RequestBody MemberDTORequest memberDTORequest) {
        Member newMember = MemberMapper.dtoToEntity(memberDTORequest);
        Member createdMember = memberService.addMember(newMember);
        MemberDTOResponse newMemberDTO = MemberMapper.entityToDTO(createdMember);

        return new ResponseEntity<>(newMemberDTO, HttpStatus.CREATED);
    }

    // Actualizar miembros
    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member member) {
        return memberService.findMember(id)
                .map(foundMember -> {
                    Member updated = memberService.updatedMember(id, member);
                    return new ResponseEntity<>(updated, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar miembros
    @DeleteMapping("/members")
    public ResponseEntity<Void> deleteMembersById(@RequestBody List<Integer> id) {
        memberService.deleteMembersById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
