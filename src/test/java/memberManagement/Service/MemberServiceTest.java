package memberManagement.Service;

import memberManagement.domain.Member;
import memberManagement.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService;


    //테스트 전마다 돌게 됨
    @BeforeEach
    public void beforeEach(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberService(memberRepository);
    }

    // 테스트 끝날 때마다 돌게 됨 -> 초기화
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("spring");
        // when
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        //memberService.join(member2);

        assertThrows(IllegalStateException.class,()-> memberService.join(member2));
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}