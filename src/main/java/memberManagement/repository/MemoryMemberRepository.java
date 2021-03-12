package memberManagement.repository;

import memberManagement.domain.Member;

import java.util.*;


// 아직 디비가 없다는 가정이 껴있기 때문에 이 클래스가 디비의 역할을 한다.
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findByID(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {

        // stream : 컬렉션의 요소를 하나씩 참조해서 람다식으로 처리할 수 있는 반복자이다.
        // filter : stream 중에서 조건을 만족하는 애들을 반환할 수 있게 해줌
        // findAny : 순서 상관 없이 먼저 찾아지는 애를 반환하는데, 끝까지 전부 찾았는데도 안나오면 Optional을 반환한다.
        // 매개변수가 한 개일 때는 람다식의 ()를 생략할 수 있다.
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        // store에 저장된 모든 값을 다 반환한다.
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
