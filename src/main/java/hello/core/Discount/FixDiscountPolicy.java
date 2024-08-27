package hello.core.Discount;

import hello.core.Member.Member;
import hello.core.Member.Grade;

@Component
// 같은 이름의 빈이 2개일 때 추가 구분자를 붙여준다.
//@Qualifier("fixDiscountPolicy")

// 같은 이름의 빈이 2개일 때 우선권을 제공한다.
//@Primary
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