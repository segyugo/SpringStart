package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.Discount.DiscountPolicy;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class MultBeanTest {
    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        Member member = new Member(1, "고세규", Grade.VIP);

        DiscountService discountService = ac.getBean(DiscountService.class);



        int discountPrice = discountService.discount(member, 1000, "fixDiscountPolicy");

        System.out.println(discountPrice);


    }

   @Component
    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;


        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap : " + policyMap);
            System.out.println("policyList : " + policyList);
        }


        public int discount(Member member ,int price, String discountCode ){
            DiscountPolicy discountPolicy = this.policyMap.get(discountCode);
            System.out.println("discountPolicy = " + discountPolicy);


            return discountPolicy.discount(member, price);
        }
    }
}
