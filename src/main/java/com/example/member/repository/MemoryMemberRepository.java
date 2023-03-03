package com.example.member.repository;

import com.example.member.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository {
  private static long id;
  private static Map<Long, Member> members = new HashMap<>(); // db 대신 사용

  // create
  public Member save(Member member) {
    member.setId(id);
    members.put(id++, member);

    return member;
  }

  // read
  public Member findById(long id) {
    try {
      return members.get(id);
    }
    catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public List<Member> findAll() {
    List<Member> list = new ArrayList<>(members.values());
    return list;
  }
}
