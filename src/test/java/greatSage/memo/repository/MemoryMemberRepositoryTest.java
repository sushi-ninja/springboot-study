package greatSage.memo.repository;

import greatSage.memo.domain.Member;
import greatSage.memo.reprository.MemberRepository;
import greatSage.memo.reprository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    // 각 테스트가 끝날때마다 실행
    @AfterEach
    public void aferEach(){
        repository.clearStore();
    };

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        repository.findById(member.getId());

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));

        // static import 로 간결하게 코드 정리
        assertThat(member).isEqualTo(result);
//        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName() {
        Member member1 =  new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
 
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

    }
}
