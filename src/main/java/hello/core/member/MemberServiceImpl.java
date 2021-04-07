package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //MemberServiceImpl는 스프링 빈으로 등록이 된다 @Component 애노테이션이 붙어있으면 자동으로 스프링빈(싱글톤) 등록이 된다
//이때 스프링 빈 기본이름은 클래스 명을 사용하되 맨 앞글자만 소문자를 사용한다
public class MemberServiceImpl implements MemberService{ //구현체가 하나만 있을때는 인터페이스 명 뒤에 Impl이라고 관례상 많이씀

    private final MemberRepository memberRepository;

    @Autowired //주입(MemoryMemberRepository)  ac.getbean(MemberRepository.class)
    //스프링 컨테이너가 자동으로 해당 스프링빈을 찾아서 주입한다. 여기선 MemoryMemberRepository가 주입되었다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트 용도
    public  MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
