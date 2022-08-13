package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
/*
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
*/
    //ResponseBody 사용 시 HttpMessageConverter가 동작을 함
    //객체가 반환되면 JsonConverter(MappingJackson2HttpMessageConverter)가 json방식의 응답을 만들어 반환한다.
    //문자가 반환되면 StringConverter(StringHttpmessageConverter)가 문자형식의 응답을 만들어 반환한다.
    //byte 기타 등등 처리가 HttpMessageConverter에 등록되어 있음
    @GetMapping("hello-mvc")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

}
