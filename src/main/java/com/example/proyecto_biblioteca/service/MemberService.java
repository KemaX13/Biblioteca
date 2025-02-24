package com.example.proyecto_biblioteca.service;

import com.example.proyecto_biblioteca.model.Member;
import com.example.proyecto_biblioteca.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // Encontrar miembros
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMember(int id){
        return memberRepository.findById(id);
    }

    public Optional<Member> findMember(String name) {
        return memberRepository.findByMemberName(name);
    }

    // Agregar miembros
    public Member addMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    // Actualizar miembros
    public Member updatedMember(int id, Member updatedMember){
        Optional<Member> foundMember = memberRepository.findById(id);

        if(foundMember.isPresent()){
            Member existingMember = foundMember.get();
            existingMember.setMemberName(updatedMember.getMemberName());
            existingMember.setMemberEmail(updatedMember.getMemberEmail());
            return memberRepository.save(existingMember);
        }

        throw new RuntimeException();
    }

    // Eliminar miembros
    public void deleteMembersById(List<Integer> id) {
        List<Member> membersToDelete = memberRepository.findAllById(id);
        if (membersToDelete.size() != id.size()) {
            throw new RuntimeException();
        }
        memberRepository.deleteAll(membersToDelete);
    }
}
