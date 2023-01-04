package hello.coreMain.discount;

import hello.coreMain.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);


}
