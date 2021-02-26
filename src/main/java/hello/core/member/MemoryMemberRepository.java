package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements  MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 동시성 이슈가 발생할 수 있음. 그래서 원래는 concurrent 해시맵씀.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}