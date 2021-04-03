package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; //메모리회원리포
    private final DiscountPolicy discountPolicy;

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정할인 금액정책


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository; //AppConfig에서 바꿀 수 있다.
        this.discountPolicy = discountPolicy; //AppConfig에서 바꿀 수 있다.
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { //주문생성 요청이 오면
        Member member = memberRepository.findById(memberId); //회원정보를 먼저 조회를 하고
        int discountPrice = discountPolicy.discount(member, itemPrice);// 할인정책에 회원을 넘긴다

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종 생성된 주문 반환
    }
}