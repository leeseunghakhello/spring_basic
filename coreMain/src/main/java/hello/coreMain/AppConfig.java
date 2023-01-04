package hello.coreMain;

import hello.coreMain.discount.DiscountPolicy;
import hello.coreMain.discount.FixDiscountPolicy;
import hello.coreMain.discount.RateDiscountPolicy;
import hello.coreMain.member.MemberRepository;
import hello.coreMain.member.MemberService;
import hello.coreMain.member.MemberServiceImpl;
import hello.coreMain.member.MemoryMemberRepository;
import hello.coreMain.order.OrderService;
import hello.coreMain.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    //기대하는 출력값//
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //실제 출력값 -> 스프링은 싱글톤을 유지하기 때문에
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService



    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl( memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
