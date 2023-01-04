package hello.coreMain.order;

import hello.coreMain.discount.FixDiscountPolicy;
import hello.coreMain.member.Grade;
import hello.coreMain.member.Member;
import hello.coreMain.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository=new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService=new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
        Order order=orderService.createOrder(1L,"itemA",10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}