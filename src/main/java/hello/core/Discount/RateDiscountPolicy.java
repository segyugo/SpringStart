package hello.core.Discount;

import hello.core.Member.Member;
import hello.core.Member.Grade;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountRate = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * 10 / 100;
        } else {
            return 0;
        }
    }
}
