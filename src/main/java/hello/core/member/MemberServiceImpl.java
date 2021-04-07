package hello.core.member;

public class MemberServiceImpl implements MemberService{ //구현체가 하나만 있을때는 인터페이스 명 뒤에 Impl이라고 관례상 많이씀

    private final MemberRepository memberRepository;

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
