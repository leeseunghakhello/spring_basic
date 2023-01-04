package hello.coreMain;
import hello.coreMain.member.Grade;
import hello.coreMain.member.Member;
import hello.coreMain.member.MemberService;
import hello.coreMain.member.MemberServiceImpl;
import hello.coreMain.order.Order;
import hello.coreMain.order.OrderService;
import hello.coreMain.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        //스프링전
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService =appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService=applicationContext.getBean("orderService",OrderService.class);

//        MemberService memberService = new MemberServiceImpl();-> dip 성립립
//       OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
    }
    }
