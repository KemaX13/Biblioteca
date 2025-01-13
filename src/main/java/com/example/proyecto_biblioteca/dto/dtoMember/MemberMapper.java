package com.example.proyecto_biblioteca.dto.dtoMember;

import com.example.proyecto_biblioteca.model.Member;

public class MemberMapper {
    //dtoToEntity
    public static Member dtoToEntity(MemberDTORequest memberDTORequest) {
       return new Member(memberDTORequest.name(), memberDTORequest.surname(), memberDTORequest.email(), memberDTORequest.isActive());
    }

    //entityToDTO
    public static MemberDTOResponse entityToDTO(Member member) {
        return new MemberDTOResponse(member.getMemberName(), member.getMemberSurname(), member.getMemberEmail());
    }
}
