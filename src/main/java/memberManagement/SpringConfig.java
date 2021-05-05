package memberManagement;

import memberManagement.Service.MemberService;
import memberManagement.repository.MemberRepository;
//import memberManagement.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //private final DataSource dataSource;
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        //this.dataSource = dataSource;
        this.memberRepository = memberRepository;
        //this.em = em;
    }



    //private EntityManager em;

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//
//        //return new JdbcMemberRepository(dataSource);
//       // return new JpaMemberRepository(em);
//        return
//
//    }

}
