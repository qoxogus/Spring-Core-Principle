package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; //메모리회원리포
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정할인 금액정책
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository; //메모리멤버리포
        this.discountPolicy = discountPolicy; //픽스디스카운트폴리시
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { //주문생성 요청이 오면
        Member member = memberRepository.findById(memberId); //회원정보를 먼저 조회를 하고
        int discountPrice = discountPolicy.discount(member, itemPrice);// 할인정책에 회원을 넘긴다

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종 생성된 주문 반환
    }
}
