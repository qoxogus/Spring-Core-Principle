package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //실무에서는 동시성문제가 있을 수 있어서 복류되는 변수일때는 ConcurrentHashMap<>()을 써야하지만(동시성이슈가 발생할 수 있음) 예제니까 단순히 HashMap<>()울 쓴다.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
