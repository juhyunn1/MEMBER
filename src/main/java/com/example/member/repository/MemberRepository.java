package com.example.member.repository;

import com.example.member.domain.Member;

import java.util.List;

public interface MemberRepository {

  Member save(Member member);
  Member findById(long id);
  List<Member> findAll();
}
