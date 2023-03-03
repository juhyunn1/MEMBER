package com.example.member.service;

import com.example.member.domain.Member;
import com.example.member.repository.JdbcTemplateMemberRepository;
import com.example.member.repository.MemberRepository;
import com.example.member.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service // 서비스 부품이다 라고 알려줌
public class MemberService {
  //MemoryMemberRepository mr = new MemoryMemberRepository(); // MemberService는 MemoryMemberRepository에 의존적
  // MemberRepository mr = new MemoryMemberRepository(); // MemberService는 MemberRepository에 의존적, 경우에 따라 뒤에 구현체만 바꾸어주면 됨
  // MemberRepository mr = JdbcTemplateMemberRepository(DataSource dataSource);
  private final MemberRepository mr;

  @Autowired
  public MemberService(MemberRepository mr) {
    this.mr = mr;
  }

  // 회원가입
  public long join(Member member) {
    return mr.save(member).getId();
  }

  // 전체 조회
  public List<Member> getMemberList() {
    return mr.findAll();
  }

  // 특정멤버 조회
  public Member getMember(long id) {
    return mr.findById(id);
  }
}
