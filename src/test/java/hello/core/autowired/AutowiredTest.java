package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.RateDiscountPolicy;
import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemberService;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import jakarta.annotation.Nullable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class AutowiredTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    void AutowiredNullableTest() {
        MemberService ms = ac.getBean(MemberService.class);
        assertThat(ms).isInstanceOf(MemberService.class);

        OrderServiceImpl os = ac.getBean(OrderServiceImpl.class);
        DiscountPolicy discountPolicy = os.getDiscountPolicy();
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }


    @Configuration
    @ComponentScan
    public static class tempConfig{

        @Autowired(required = false)
        void setMember(Member member1) {
            System.out.println(member1);
        }

        @Autowired
        void setMember2(@Nullable Member member2) {
            System.out.println(member2);
        }

        @Autowired
        void setMember3(Optional<Member> member3) {
            System.out.println(member3);
        }

    }

}




