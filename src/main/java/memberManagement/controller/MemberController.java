package memberManagement.controller;

import memberManagement.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;


//    Setter injection -> 중간에 의존 관계가 비뀔 일이 있다면..?
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // member service를 갖다가 연결해줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    필드 주입
//    @Autowired private MemberService memberService;


}
