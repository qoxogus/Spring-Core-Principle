package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //구성정보 (설정정보) 애플리케이션이 어떻게구성되는지 설정되는지
public class AppConfig {

    @Bean //스프링 컨테이너에 등록이 된다
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); //MemberServiceImpl을 만들고 이 MemberServiceImpl  MemoryMemberRepository를 사용할거야.
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //memoryMemberRepository, FixDiscountPolicy
        //OrderServiceImpl생성 -> MemoryMemberRepository와 FixDiscountPolicy를 넘김
        //OrderServiceImpl이 MemoryMemberRepository와 FixDiscountPolicy를 참조시키도록 함.
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}