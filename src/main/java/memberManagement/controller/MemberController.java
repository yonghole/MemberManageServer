package memberManagement.controller;

import memberManagement.Service.MemberService;
import memberManagement.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;


//    Setter injection -> 중간에 의존 관계가 비뀔 일이 있다면..?
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // member service를 갖다가 연결해줌 !!
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    필드 주입
//    @Autowired private MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(test t){
        Member member = new Member();
        member.setName(t.getNamerr());
        System.out.println(member.getName());
        System.out.println(t.getNamerr());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
