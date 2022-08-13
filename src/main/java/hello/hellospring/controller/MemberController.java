package hello.hellospring.controller;

import hello.hellospring.Service.MemberService;
import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@Controller 에노테이션이 있으면 스피링이 뜰 때 객체를 만들어 공간을 확보해놈
//Controller 통해서 외부 요청을 받고 service 에서 비지니스 로직을 만들고  repository 에서 데이터를 저장
@Controller
public class MemberController {

    private final MemberService memberService;

    //생성자를 통한 의존주입 << 선호중 의존관계가 실행중에 동적으로 변하는 상황은 거의 없다.
    @Autowired  //의존주입(dependency injection DI) 컨트롤러가 생성이 될 때 스프링 빈에 등록되어 있는 서비스 객체를 넣어줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        //spring이 setter를 호출해서 키값을 넣어줌 key:name
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findmembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
