package memberManagement.repository;

import memberManagement.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    // Must implemented Functions

    Member save(Member member);
    Optional<Member> findByID(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
