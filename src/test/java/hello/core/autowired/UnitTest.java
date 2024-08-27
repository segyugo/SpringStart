package hello.core.autowired;

import hello.core.Discount.FixDiscountPolicy;
import hello.core.Member.MemoryMemberRepository;
import hello.core.Order.OrderServiceImpl;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    void unitTest() {
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

        orderService.createOrder(1L, "itemA", 10000);

    }

}
