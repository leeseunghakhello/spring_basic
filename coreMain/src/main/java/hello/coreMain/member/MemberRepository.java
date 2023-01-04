package hello.coreMain.member;

public interface MemberRepository {//회원 저장장소
    void save(Member member);
    Member findById(Long memberId);
}
