package greatSage.memo.service;

import greatSage.memo.domain.Member;
import greatSage.memo.reprository.MemberRepository;
import greatSage.memo.reprository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /** 
     * 회원 가입
     * @param member
     * @return
     * */
    public Long join(Member member) {
        // 같은 이름 회원 중복x
        // memberRepository.findByName(member.getName()); 에서 option + command + v 를 눌러주면 자동완성으로 아래 코드가 완성된다
        // Optional 은 result 의 값이 있는지 없는지를 판단하여 true false 로 값을 준다
        // isPresent() 메소드는 Boolean 타입으로 결과를 리턴한다
        // Optional 객체가 값을 가지고 있다면 true, 값이 없다면 false 리턴
        // 고로 아래 코드는 memberRepository에서 findByName을 실행해봤을때 true가 되면 이미 존재하는 회원이라는
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException(" 이미 존재하는 회원입니다");
        });

        memberRepository.save(member);
        return member.getId();
    }
}
