package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member); //join한것과
        Member findMember = memberService.findMember(1L); //찾은 값이
        ///then
        Assertions.assertThat(member).isEqualTo(findMember); //똑같다면 테스트 성공

    }
}
