package hello.core.Discount;

import Discount.RateDiscountPolicy;
import Member.Member;
import Member.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용")
    void vip_o() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
//given
        Member member = new Member(2L, "memberBASIC", Grade.NORMAL);
//when
        int discount = discountPolicy.discount(member, 5000);
//then
        assertThat(discount).isEqualTo(0);
    }
}