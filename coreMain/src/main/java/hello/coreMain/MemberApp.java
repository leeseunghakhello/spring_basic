package hello.coreMain;

import hello.coreMain.member.Grade;
import hello.coreMain.member.Member;
import hello.coreMain.member.MemberService;
import hello.coreMain.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService=appConfig.memberService();//memberSerivice 안에는 memberServiceImpl이 들어가있다.

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);

//        MemberService memberService= new MemberServiceImpl();appConfig에서 다 한다.
        Member member =new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember=memberService.findMember(1L);
        System.out.println("new Member="+member.getName());
        System.out.println("find Member="+findMember.getName());
    }
}
