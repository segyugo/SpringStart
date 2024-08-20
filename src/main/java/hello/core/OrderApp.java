package hello.core;

import hello.core.Discount.DiscountPolicy;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Order.Order;
import hello.core.Order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
        public static void main(String[] args) {

            ApplicationContext AC = new AnnotationConfigApplicationContext(AppConfig.class);
            MemberService memberService = AC.getBean("memberService", MemberService.class);
            OrderService orderService = AC.getBean("orderService", OrderService.class);



            long memberId = 1L;
            Member member = new Member(memberId, "memberA", Grade.VIP);
            memberService.join(member);
            Order order = orderService.createOrder(memberId, "itemA", 10000);
            System.out.println("order = " + order);
        }
    }

