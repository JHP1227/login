package com.study0406.member3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study0406.member3.dto.MemberDTO;
import com.study0406.member3.entity.MemberEntity;
import com.study0406.member3.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

    // 생성자 주입
    private final MemberService memberService;

    // 기본페이지 요청 메서드
    @GetMapping("/member")
    public String index() {
        return "index"; // template폴더의 index.html파일을 띄우겠다는 것
    }

    // 사용자 등록
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) { // save.html에서 name들하고 DTO의 이름이 같다면 memberDTO객체에 다 들고온다
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "login";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            // login 성공
            session.setAttribute("loginUid", loginResult.getUid());
            return "main";
        } else {
            // login 실패

            return "login";
        }
    }

    @GetMapping("/member/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "List";
    }

    // @GetMapping("/member/")
    // public String findAll(Model model) {
    // List<PersonDTO> memberDTOList = memberService.findAll();
    // model.addAttribute("memberList", memberDTOList);
    // return "PersonList";
    // }
}
