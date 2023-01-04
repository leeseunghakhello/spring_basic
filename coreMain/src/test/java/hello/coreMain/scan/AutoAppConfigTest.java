package hello.coreMain.scan;

import hello.coreMain.AutoAppConfig;
import hello.coreMain.member.MemberRepository;
import hello.coreMain.member.MemberService;
import hello.coreMain.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);//->

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean=ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository=bean.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }
}
