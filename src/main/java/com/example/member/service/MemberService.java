package com.example.member.service;

import com.example.member.domain.Member;
import com.example.member.repository.MemoryMemberRepository;

import java.util.List;

public class MemberService {
  MemoryMemberRepository mmr = new MemoryMemberRepository(); // MemberService는 MemoryMemberRepository에 의존적

  // 회원가입
  public long join(Member member) {
    return mmr.save(member).getId();
  }

  // 전체 조회
  public List<Member> getMemberList() {
    return mmr.findAll();
  }

  // 특정멤버 조회
  public Member getMember(long id) {
    return mmr.findById(id);
  }
}
