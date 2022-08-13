package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //웰컴페이지는 Controller부터 찾고 없으면 정적 리소스를 찾는 것이다. (ex> resources/static/index.html)
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
