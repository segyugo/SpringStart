package hello.core.Order;

import Member.Member;
import Member.Grade;
import Member.MemberService;
import Member.MemberServiceImpl;
import Order.Order;
import Order.OrderService;
import Order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderTest {

    MemberService memberService = new MemberServiceImpl();

    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Member member = new Member(1L, "세규", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "연필", 1500);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(500);

    }


}
