package com.example.member.controller;

import com.example.member.domain.Member;
import com.example.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {

  private final MemberService memberService = new MemberService();

  @GetMapping("/member/home") // 맨 앞은 / 생략 가능
  public String home() {
    return "member/homePage"; // 뷰에서 html 렌더링
  }

  @GetMapping("/member/new")
  public String newMember() {
    return "member/newMember";
  }

  @PostMapping("/member/new")
  // form에서 name 값만 넘어오기 떄문에 다른 필드가 포함된 Member 대신 MemberFromForm 사용
  // 주소의 파라미터 이름이랑 객체의 필드명이 같으면 알아서 setter 통해서 객체로 만든다
  public String newMember(MemberFromForm memberFromForm) {
    Member member = new Member();
    member.setName(memberFromForm.getName());
    System.out.println(memberService.join(member) + "번 사용자 가입 완료");

    return "redirect:/member/home"; // /member/home 컨트롤러 호출, get 방식이 default
  }

  // @GetMapping("/members")
  // @ResponseBody // 객체로 바로 넘김
  // public List<Member> members(Model model) {
  //   List<Member> memberList = memberService.getMemberList();
  //   return memberList;
  // }

  @GetMapping("/members")
  public String members(Model model) {
    List<Member> memberList = memberService.getMemberList();
    model.addAttribute("memberList", memberList);
    return "member/memberList";
  }
}
