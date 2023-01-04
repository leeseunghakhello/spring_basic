package hello.coreMain.order;
import hello.coreMain.discount.DiscountPolicy;
import hello.coreMain.member.Member;
import hello.coreMain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//클라이언트 코드
@Component
public class OrderServiceImpl implements OrderService {//AppConfig로 역할을 분리시켰다. 실행만 관여하게
  //이런 식으로 배우는 본인의 역할만 수행하는 것으로 속성만 생성하고 객체 생성은 appconfig에서 하게 만든다.
      private final MemberRepository memberRepository;
      private final DiscountPolicy discountPolicy;

    //new OrderServiceImpl(memberRepository, discountPolicy)

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
    this.memberRepository=memberRepository;
    this.discountPolicy=rateDiscountPolicy;
    }


//    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//구현체
//  //  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();//추상화

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    ///테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
