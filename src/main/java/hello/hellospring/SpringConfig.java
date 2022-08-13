package hello.hellospring;

import hello.hellospring.Service.MemberService;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
//스프링 빈으로 등록되어 있지 않거나, @Component scan(@Controller,@Service,@Repository)을 안타면 @Autowired가 존재하여도 클래스가 동작하지 않음
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //private DataSource dataSource;
    //private EntityManager em;

    //@Autowired
    //public SpringConfig(EntityManager em) {        this.em = em;    }

    //public SpringConfig(DataSource dataSource) {        this.dataSource = dataSource;    }

    @Bean
    public MemberService memberService(){
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

    //@Bean
    //public TimeTraceAop timeTraceAop(){
    //    return new TimeTraceAop();
    //}

    //@Bean
    //public MemberRepository memberRepository() {

        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);

    //}

}
