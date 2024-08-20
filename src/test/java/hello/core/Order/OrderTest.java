package hello.core.Order;

import hello.core.AppConfig;
import hello.core.Member.Member;
import hello.core.Member.Grade;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Member member = new Member(1L, "세규", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "연필", 1500);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(500);

    }


}
