package com.example.biblioteca_back.repository;

import com.example.biblioteca_back.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberName(String name);
}