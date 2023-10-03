package greatSage.memo.reprository;

import greatSage.memo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemeberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> fintByName(String name);
    List<Member> findAll();
}
