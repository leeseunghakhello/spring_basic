package hello.coreMain.member;

public interface MemberService {//회원 서비스 인터페이스
    void join(Member member);

    Member findMember(Long memberId);
}
