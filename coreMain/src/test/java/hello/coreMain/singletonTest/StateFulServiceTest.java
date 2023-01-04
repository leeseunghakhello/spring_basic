package hello.coreMain.singletonTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1= ac.getBean(StateFulService.class);
        StateFulService stateFulService2= ac.getBean(StateFulService.class);
        
        //ThreadA: A사용자 1000원 주문
        int userAPrice=stateFulService1.order("userA",10000);
        //ThreadB : B사용자 2000원 주문
        int userBPrice=stateFulService2.order("userB",20000);
        //객체가 같은 것이기 때문에 10000원이였던 사용자가 20000원으로 바뀌게 되서 20000원으로 출력된다.

        //ThreadA : 사용자A 주문 금액 조회
//        int price = stateFulService1.getPrice();
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(stateFulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }

}