package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()); //MemberServiceImpl을 만들고 이 MemberServiceImpl  MemoryMemberRepository를 사용할거야.
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        //OrderServiceImpl생성 -> MemoryMemberRepository와 FixDiscountPolicy를 넘김
        //OrderServiceImpl이 MemoryMemberRepository와 FixDiscountPolicy를 참조시키도록 함.
    }
}
