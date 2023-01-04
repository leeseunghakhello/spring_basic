package hello.coreMain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{//회원 서비스 구현체 -> memberService인 인터페이스를 구현하는 것.

    //인터페이스를 의존
    private final MemberRepository memberRepository;//MemberServiceImpl은 MemoryMemberRepository 를 의존하지 않는다. -> dip를 지킨다.

    @Autowired //마치 이런식으로 -> ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    ///테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
