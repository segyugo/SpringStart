package hello.core.Discount;

import hello.core.Member.Member;
import hello.core.Member.Grade;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountPrice = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountPrice;
        } else {
            return 0;
        }
    }
}